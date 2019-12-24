package arithmetic;

/**
 * @ClassName ChooseSort
 * @Description 选择排序
 * @Author Administrator
 * @Date 2019/12/21 15:41
 * @Version 1.0
 */
public class ChooseSort {
    public static void main(String[] args) {
        int[] nums = new int[10];
        MergeSort.putValue(nums);
        MergeSort.print(nums);
        chooseSort(nums);
        MergeSort.print(nums);
    }

    private static void chooseSort(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int min = Integer.MAX_VALUE;
            int index = i;
            for (int j = i; j < nums.length; j++){
                if (nums[j] < min){
                    index = j;
                    min = nums[j];
                }
            }
            if (index > i){
                nums[index] = nums[i];
                nums[i] = min;
            }
        }
    }
}
