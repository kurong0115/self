package arithmetic;

import java.util.Arrays;

/**
 * @ClassName HeapSort
 * @Description 堆排序
 * @Author Administrator
 * @Date 2019/11/13 10:42
 * @Version 1.0
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] nums = {19, 0, 32, 27, 36, 26, 42, 49};
		MergeSort.print(nums);
		buildHeap(nums);
		MergeSort.print(nums);
	}

	// 32	36	42	49	0	26	19	27
	public static void go(int[] nums){
		for (int i = 0; i < nums.length; i++){
			heapify(nums, i, nums.length);
		}
		MergeSort.print(nums);
	}

	public static void back(int[] nums){
		for (int i = nums.length - 1; i >= 0; i--){
			heapify(nums, i, nums.length);
		}
		MergeSort.print(nums);
	}

	public static void buildHeap(int[] nums){
		int length = nums.length;
		for (int i = length - 1; i >= 0; i--){
			heapify(nums, i, length);
		}
		for (int i = length - 1; i >= 0; i--){
			swap(nums, 0, i);
			heapify(nums, 0, --length);
		}
	}

	public static void heapify(int[] nums, int start, int end){
		int left = (start << 1) + 1;
		int right = (start << 1) + 2;
		int max = start;
		if (left < end && nums[left] > nums[max]){
			max = left;
		}
		if (right < end && nums[right] > nums[max]){
			max = right;
		}
		if (max != start){
			swap(nums, max, start);
			heapify(nums, max, end);
		}
	}

	public static void swap(int[] nums, int start, int end){
		int tmp = nums[start];
		nums[start] = nums[end];
		nums[end] = tmp;
	}

}
