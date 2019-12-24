package arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName BucketSort
 * @Description 桶排序
 * @Author Administrator
 * @Date 2019/11/12 16:51
 * @Version 1.0
 */
public class BucketSort {

	public static void main(String[] args) {
		int[] nums = new int[50];
		MergeSort.putValue(nums);
		MergeSort.print(nums);
		bucketSort(nums);
		MergeSort.print(nums);
	}

	public static void bucketSort(int[] nums){
		int length = 10;
		List<List<Integer>> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for (int num: nums){
			if (num > max){
				max = num;
			}
		}
		// max = 50   partition = 5
		int partition = max / length;
		length = max / partition;
		for (int i = 0; i <= length; i++){
			List<Integer> c = new ArrayList<>();
			list.add(c);
		}

		for (int num: nums){
			int index = num / partition;
			list.get(index).add(num);
		}
		int tmp = 0;
		for (int i = 0; i <= length; i++){
			List<Integer> c = list.get(i);
			Collections.sort(c);
			for (int j = 0; j < c.size(); j++){
				nums[tmp++] = c.get(j);
			}
		}
	}

}
