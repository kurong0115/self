package arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName TransformScale
 * @Description 36进制加法
 * @Author Administrator
 * @Date 2019/11/13 16:32
 * @Version 1.0
 */
public class TransformScale {
	static Map<String, Integer> map = new HashMap<>(64);
	static Map<Integer, String> m1 = new HashMap<>(64);
	static {
		for (int i = 0; i < 36; i++){
			if  (i < 10){
				map.put(i + "", i);
				m1.put(i, i + "");
			} else {
				Character a = (char)('a' + i - 10);
				map.put(a.toString(), i);
				m1.put(i, a.toString());
			}
		}
	}
	public static void main(String[] args) {
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for (Map.Entry<String, Integer> entry: entries){
			System.out.println(entry.getKey() + "--->" + entry.getValue());
		}
		String exp = getFinalExpression("2c1b", "2x");
		System.out.println(exp);
		System.out.println(parseExpression(exp));

		System.out.println(maxDepth(new TreeNode(1)));
	}

	public static String getFinalExpression(String a, String b){
		StringBuilder sb = new StringBuilder();
		int num = 0;
		int lenA = a.length() - 1;
		int lenB = b.length() - 1;
		while (lenA > 0 || lenB > 0 || num > 0){
			String k1 = lenA >= 0? a.substring(lenA, lenA + 1): "0";
			String k2 = lenB >= 0? b.substring(lenB, lenB + 1): "0";
			int sum = map.get(k1) + map.get(k2) + num;
			if (sum >= 36){
				sum -= 36 ;
				num = 1;
			} else{
				num = 0;
			}
			sb.append(m1.get(sum));
			lenA--;
			lenB--;
		}
		return sb.reverse().toString();
	}

	public static int parseExpression(String exp){
		int length = exp.length();
		int sum = 0;
		for (int i = length - 1; i >= 0; i--){
			sum += map.get(exp.substring(i, i + 1)) * Math.pow(36, length - i - 1);
		}
		return sum;
	}

	static int depth = 0;
	public static int maxDepth(TreeNode root) {
		if (root == null){
			return 0;
		}
		preOrder(root, 0);
		return depth;
	}
	public static void preOrder(TreeNode root, int i){
		if (root == null){
			depth = i > depth? i: depth;
			return;
		}
		preOrder(root.left, i + 1);
		preOrder(root.right, i + 1);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}