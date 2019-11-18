package arithmetic;

/**
 * @ClassName CountingTarget
 * @Description 输出和为目标值的数目
 * @Author Administrator
 * @Date 2019/11/13 16:26
 * @Version 1.0
 */
public class CountingTarget {
	static int count = 0;
	static int[] nums = {1, 2, 5, 10};

	public static void main(String[] args) {
		dfs(0, 5);
		System.out.println(count);
	}

	public static void dfs(int current, int target){
		if (current == target){
			count++;
			return;
		}
		if (current > target){
			return;
		}
		for (int i = 0; i < nums.length; i++){
			current += nums[i];
			dfs(current, target);
		}
	}
}
