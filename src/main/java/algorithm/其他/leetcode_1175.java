package algorithm.其他;

/**
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 *
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 *
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-arrangements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/10/11 9:49
 */
public class leetcode_1175 {
    public int numPrimeArrangements(int n) {
        int zNums = 0;
        for (int i = 1; i <= n; i++) {
            if(i == 1||i == 100){
                continue;
            }
            if (i == 2||i == 3||i == 5||i == 7){
                zNums++;
            }
            if(i%2==0 || i%3 == 0 || i%5 == 0 || i%7 == 0){
                continue;
            }else {
                zNums++;
            }
        }
        long zCount = 1L;
        int y = 1000000000 + 7;
        for (int i = zNums; i >0; i--) {
            long tmp = zCount * i;
            zCount = tmp % y;
            System.out.println(zCount);
        }
        int fNums = n - zNums;
        for (int i = fNums; i >0; i--) {
            long tmp = zCount * i;
            zCount = tmp % y;
        }
        return (int)zCount;
    }

    public static void main(String[] args) {
        leetcode_1175 l = new leetcode_1175();
        System.out.println(l.numPrimeArrangements(100));
    }
}
