package algorithm.位运算;

import java.time.chrono.MinguoDate;
import java.util.Arrays;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/20
 */
public class leetcode_2595 {

    public static int[] evenOddBit(int n) {
        int[] ans = new int[2];
        int index = 0;
        while (n > 0){
            if ((n & 1) == 1) {
                ans[index & 1] ++;
            }
            n = n >>> 1;
            index ++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenOddBit(50)));
    }
}
