package algorithm.位运算;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 *
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 *
 *
 *
 * @ClassName algorithm
 * @Description:
 * @Author zhouxianghui6
 * @Date 2022/4/24 9:55
 * @since
 **/
public class leetcode_868 {
    public static int binaryGap(int n) {
        int i = 1;
        int rtn = 0;
        int before = -1;
        while (i<=n){
            int index = n & i;
            if (index>0){
                // 2的x次方
                int x =(int) (Math.log(index) / Math.log(2));
                if(before>=0){
                    rtn = Math.max(x-before,rtn);
                }
                before = x;
            }
            i = i*2;
        }
        return rtn;
    }

    public static void main(String[] args) {
        binaryGap(78);
    }
}
