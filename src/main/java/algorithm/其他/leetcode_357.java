package algorithm.其他;

/**
 * @author zhouxh-z
 * @date 2021/11/17 13:50
 */
public class leetcode_357 {
    public int countNumbersWithUniqueDigits(int n) {
        double pow = Math.pow(10, n);
        double v = pow - 9 * (n - 1);

        return (int) v;
    }
}
