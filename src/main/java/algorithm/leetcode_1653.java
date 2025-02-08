package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 *
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 *
 * 请你返回使 s 平衡 的 最少 删除次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author zhouxianghui6
 * @description
 * @date 2023/3/6
 */
public class leetcode_1653 {

    public static int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        // 1、全a  2、全b 3、ab

        int numA = 0;
        int numB = 0;
        List<int[]> count = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'a'){
                numA ++;
            }else {
                numB ++;
            }
            count.add(new int[]{i,numA,numB});
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count.size(); i++) {
            int[] ints = count.get(i);
            int i1 = ints[2] + (numA - ints[1]);
            min = Math.min(min, i1);
        }
        min = Math.min(min,numA);
        min = Math.min(min,numB);
        return min;
    }

    public static void main(String[] args) {
        minimumDeletions("aababba");

    }
}
