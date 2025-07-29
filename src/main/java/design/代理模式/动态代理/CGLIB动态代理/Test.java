package design.代理模式.动态代理.CGLIB动态代理;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhouxh-z
 * @date 2021/9/26 14:46
 */
public class Test {
    /**
     * CGLIB 动态代理需要依赖第三方类库 ：cglib
     *
     * <dependency>
     *     <groupId>cglib</groupId>
     *     <artifactId>cglib</artifactId>
     *     <version>3.2.10</version>
     * </dependency>
     *
     * @param args
     */
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ImageReal.class);
        enhancer.setCallback(new ProxyFactory());
        ImageReal proxy = (ImageReal) enhancer.create();
        proxy.watch();
    }
}
