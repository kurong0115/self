package proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import service.UserService;
import service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    private UserService userService;

    public ProxyTest(UserService userService) {
        this.userService = userService;
    }

    public Object generateProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("prepare");
                method.invoke(userService);
                System.out.println("close");
                return proxy;
            }
        });
    }

    public Object generateCglib(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userService.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("start");
                method.invoke(userService);
                System.out.println("end");
                return o;
            }
        });
        return enhancer.create();
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyTest proxy = new ProxyTest(userService);
        UserService target = (UserService)proxy.generateProxy();
        target.run();

        target = (UserService)proxy.generateCglib();
        target.run();
    }
}
