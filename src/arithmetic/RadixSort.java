package arithmetic;

/**
 * @ClassName RadixSort
 * @Description 基数排序
 * @Author Administrator
 * @Date 2019/12/21 15:27
 * @Version 1.0
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] nums = new int[10];
        MergeSort.putValue(nums);
        MergeSort.print(nums);
        radixSort(nums);
        MergeSort.print(nums);
    }

    private static void radixSort(int[] nums) {
        int max = getMaxNum(nums);
        int[] c = new int[max + 1];
        for (int num: nums){
            c[num]++;
        }
        int index = 0;
        for (int i = 0; i < c.length; i++){
            while (c[i]-- > 0){
                nums[index++] = i;
            }
        }
    }

    /**
     * 获取数组中的最大值
     * @param nums
     * @return
     */
    public static int getMaxNum(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int num: nums){
            if (num > max){
                max = num;
            }
        }
        return max;
    }
}
