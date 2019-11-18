package arithmetic;

import java.util.Arrays;

/**
 * @ClassName CountingSort
 * @Description 计数排序
 * @Author Administrator
 * @Date 2019/11/12 17:25
 * @Version 1.0
 */
public class CountingSort {
	public static void main(String[] args) {
		int[] nums = new int[10];
		MergeSort.putValue(nums);
		MergeSort.print(nums);
		int[] r = countingSort(nums);
		MergeSort.print(r);
	}

	public static int[] countingSort(int[] nums){
		int max = Integer.MIN_VALUE;
		for (int num: nums){
			if (num > max){
				max = num;
			}
		}
		int[] c= new int[max + 1];
		Arrays.fill(c, 0);
		for (int i = 0; i < nums.length; i++){
			c[nums[i]]++;
		}
		// 经过处理后下标为实际值，c[i]为i在数组中的位置
		for (int i = 1; i <= max; i++){
			c[i] = c[i] + c[i - 1];
		}
		int[] r = new int[nums.length];
		for (int i = r.length - 1; i >= 0; i--){
			int index = c[nums[i]] - 1;
			r[index] = nums[i];
			c[nums[i]]--;
		}
		return r;
	}
}
