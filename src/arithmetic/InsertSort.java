package arithmetic;

/**
 * @ClassName InsertSort
 * @Description 插入排序
 * @Author Administrator
 * @Date 2019/12/21 15:13
 * @Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[10];
        MergeSort.putValue(nums);
        MergeSort.print(nums);
        insertSort(nums);
        MergeSort.print(nums);
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            int key = nums[i];
            int j = i - 1;
            for (; j >= 0; j--){
                if (key <= nums[j]){
                    nums[j + 1] = nums[j];
                } else {
                    // 当key大于前面的一个值得时候j会一直减到0
                    break;
                }
            }
            nums[j + 1] = key;
        }
    }
}
