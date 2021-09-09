package algorithm.位运算;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 *
 * 0000000000000001 --> 100000000000000000
 * @author zhouxh
 */
public class leetcode_190 {

    public int reverseBits(int n) {
        // 将最后一位取出
        int res = n&1;
        int i = 0;
        while (i < 31){
            // 左移一位
            res = res << 1;
            // n 右移一位
            n = n >> 1;
            // res 加上一位
            res += n&1;
            i++;
        }
        return res;
    }
}
