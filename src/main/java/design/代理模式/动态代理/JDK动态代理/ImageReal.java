package design.代理模式.动态代理.JDK动态代理;

/**
 * @author zhouxh-z
 * @date 2021/9/26 14:16
 */
public class ImageReal implements Image{
    @Override
    public void watch() {
        System.out.println("查看照片");
    }
}
