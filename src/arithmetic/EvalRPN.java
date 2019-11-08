package arithmetic;

import java.util.Stack;

/**
 * @ClassName EvalRPN
 * @Description 模拟算术栈
 * @Author Administrator
 * @Date 2019/11/7 19:46
 * @Version 1.0
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> options = new Stack<>();
        for (String str: tokens) {
            if (str.matches("\\-?\\d+")){
                nums.push(Integer.valueOf(str));
            } else{
                if ("*".equals(str) || "/".equals(str)){
                    options.push(str);
                    continue;
                }
                if ("+".equals(str) || "-".equals(str)){
                    String option = options.peek();
                    if (option != null){
                        if (("+".equals(option) || "-".equals(option))){

                        } else{
                            while (!options.empty()){
                                Integer b = nums.pop();
                                Integer a = nums.pop();
                                Integer result = null;
                                String op = options.pop();
                                switch (op){
                                    case "+":
                                        result = a + b;
                                        break;
                                    case "-":
                                        result = a - b;
                                        break;
                                    case "*":
                                        result = a * b;
                                        break;
                                    case "/":
                                        result = a / b;
                                        break;
                                    default:
                                }
                                nums.push(result);
                            }
                        }
                        options.push(str);
                    }
                }
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {

    }
}
