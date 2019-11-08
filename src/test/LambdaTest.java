package test;

import service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LambdaTest
 * @Description Test Lambda Expression
 * @Author Administrator
 * @Date 2019/11/6 16:07
 * @Version 1.0
 */
public class LambdaTest<T> {

    public void run(UserService userService){
        userService.run();
    }

    public int add(AddOption option, int a, int b){
        return option.add(a, b);
    }

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.run(new UserService() {
            @Override
            public void run() {
                System.out.println("奔跑");
            }
        });

        lambdaTest.run( () -> System.out.println("run"));

        AddOption option = (int a, int b) -> {return a + b;};
        int add = option.add(1, 2);
        System.out.println(add);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> {
            System.out.println(n);
        });
    }
}

interface AddOption{
    /**
     * 返回两数之和
     * @param a
     * @param b
     * @return
     */
    int add(int a, int b);
}