package arithmetic;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[10];
        MergeSort.putValue(nums);
        MergeSort.print(nums);
        quickSort(nums,0,nums.length - 1);
        MergeSort.print(nums);
    }

    public static void quickSort(int[] nums, int start, int end){
        int low = start;
        int high = end;
        int key = nums[start];
        while (low < high){
            while (low < high && nums[high] >= key){
                high--;
            }
            if (low < high && nums[high] <= key){
                int t = nums[low];
                nums[low] = nums[high];
                nums[high] = t;
            }
            while (low < high && nums[low] <= key){
                low++;
            }
            if (low < high && nums[low] >= key){
                int t = nums[low];
                nums[low] = nums[high];
                nums[high] = t;
            }
        }
        if (low > start){
            quickSort(nums, start, low - 1);
        }
        if (high < end){
            quickSort(nums, high + 1, end);
        }

    }
}
