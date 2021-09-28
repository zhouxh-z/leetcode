package design.代理模式.静态代理;

/**
 * @author zhouxh-z
 * @date 2021/9/26 14:13
 */
public class Test {
    public static void main(String[] args) {
        ImageProxy proxy = new ImageProxy(new ImageReal());
        proxy.watch();
    }
}
