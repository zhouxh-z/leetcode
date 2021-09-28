package design.代理模式.静态代理;

/**
 * @author zhouxh-z
 * @date 2021/9/26 14:04
 */
public class ImageReal implements Image{
    @Override
    public void watch() {
        System.out.println("ImageReal 查看照片");
    }
}
