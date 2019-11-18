package arithmetic;

/**
 * @ClassName CalculateSqrt
 * @Description 计算一个数的平方根
 * @Author Administrator
 * @Date 2019/11/18 17:27
 * @Version 1.0
 */
public class CalculateSqrt {

    public static void main(String[] args) {
        System.out.println(getSqrt(8));
    }

    public static int getSqrt(int num){
        if (num == 0){
            return 0;
        }
        int start = 0;
        int end = num >> 1;
        while (start <= end){
            int mid = (start + end) >>> 1;
            int sum = mid * mid;
            if (sum == num){
                return mid;
            } else if (sum > num){
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return -1;
    }
}
