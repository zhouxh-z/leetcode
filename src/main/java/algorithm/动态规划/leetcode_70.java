package algorithm.动态规划;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * @author zhouxh
 */
public class leetcode_70 {
    public int climbStairs(int n) {
        int sum = 0,f0 = 0,f1 = 1;
        for (int i = 0; i < n; i++) {
            sum = f0+f1;
            f0 = f1;
            f1 = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        leetcode_70 l  =new leetcode_70();
        l.climbStairs(3);
    }

}
