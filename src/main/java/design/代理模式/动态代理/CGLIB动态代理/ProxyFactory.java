package design.代理模式.动态代理.CGLIB动态代理;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @author zhouxh-z
 * @date 2021/9/26 15:31
 */
public class ProxyFactory implements MethodInterceptor {
    Object proxy;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB 代理模式 之前");
        Object invoke = method.invoke(proxy, objects);
        System.out.println("CGLIB 代理模式 之后");
        return invoke;
    }
}
