package design.代理模式.静态代理;

/**
 * @author zhouxh-z
 * @date 2021/9/26 14:03
 */
public class ImageProxy implements Image{
    ImageReal real;

    public ImageProxy(ImageReal real) {
        this.real = real;
    }

    @Override
    public void watch() {
        System.out.println("ImageProxy: 代理模式，主要作用是对被代理对象的增强");
        real.watch();
        System.out.println("个人理解是：代码迭代过程中，静态代理模式可以在不修改原方法的基础，对业务进行拓展");
    }
}
