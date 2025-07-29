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
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("【增强方法】代理对象正在执行的方法：" + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }
}
