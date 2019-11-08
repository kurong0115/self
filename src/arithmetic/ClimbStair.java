package arithmetic;

/**
 * @ClassName ClimbStair
 * @Description 爬台阶的走法
 * @Author Administrator
 * @Date 2019/11/7 20:20
 * @Version 1.0
 */
public class ClimbStair {
    public static int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs(int n, String str){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        for (int i = 2; i < n; i++){
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
        System.out.println(climbStairs(44, ""));
    }
}
