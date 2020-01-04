package arithmetic;

/**
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * @Author Administrator
 * @Date 2019/12/21 15:38
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[10];
        MergeSort.putValue(nums);
        MergeSort.print(nums);
        bubbleSort(nums);
        MergeSort.print(nums);
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }
}
