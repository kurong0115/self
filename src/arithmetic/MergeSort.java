package arithmetic;

import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[10];
        putValue(nums);
        print(nums);
        mergeSort(nums,0, nums.length - 1);
        print(nums);
    }

    public static void putValue(int[] nums){
        Random r = new Random();
        for (int i = 0; i < nums.length; i++){
            nums[i] = r.nextInt(50);
        }
    }

    public static void print(int[] nums){
        for (int num: nums){
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    public static void merge(int[] nums, int start, int end){
        int[] temp = new int[end - start + 1];
        int mid = (start + end) >> 1;
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end){
            if (nums[i] > nums[j]){
                temp[k++] = nums[j++];
            } else{
                temp[k++] = nums[i++];
            }
        }
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= end){
            temp[k++] = nums[j++];
        }
        for (i = 0; i < temp.length; i++){
            nums[i + start] = temp[i];
        }
    }

    public static void mergeSort(int[] nums, int start, int end){
        if (start < end){
            int mid = (start + end) >> 1;
            mergeSort(nums, start, mid);
            mergeSort(nums,mid + 1, end);
            merge(nums, start, end);
        }
    }
}
