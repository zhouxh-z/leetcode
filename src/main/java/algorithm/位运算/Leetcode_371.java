package algorithm.位运算;

/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 * @author zhouxh-z
 * @date 2021/9/26 17:46
 */
public class Leetcode_371 {
    public int getSum(int a, int b) {
        return ~(~a & ~b) ;
    }

    public static void main(String[] args) {
        Leetcode_371 l = new Leetcode_371();
        System.out.println(l.getSum(2, 3));
    }
}
