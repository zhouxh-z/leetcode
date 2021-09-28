package design.代理模式.动态代理.JDK动态代理;

import java.lang.reflect.Proxy;

/**
 * @author zhouxh-z
 * @date 2021/9/26 14:16
 */
public class Test {
    public static void main(String[] args) {
        // 构建了一个jdk 的 动态代理对象
        Image proxyInstance = (Image) Proxy.newProxyInstance(Test.class.getClassLoader(),
                ImageReal.class.getInterfaces(), (o, method, objects) -> {
                    System.out.println("JDK 动态代理 处理之前");
                    // method.invoke 需要传入一个实例对象
                    Object rtn = method.invoke(ImageReal.class.getDeclaredConstructor().newInstance(), objects);
                    System.out.println("JDK 动态代理 处理之后");
                    return rtn;
                });
        proxyInstance.watch();
    }
}
