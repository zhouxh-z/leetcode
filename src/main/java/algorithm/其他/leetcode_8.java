package algorithm.其他;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ClassName algorithm
 * @Description:
 * @Author zhouxianghui6
 * @Date 2022/4/21 15:18
 * @since
 **/
public class leetcode_8 {

    public static String convert(String s, int numRows) {
        int length = s.length();
        // 第一行的 2*numRows - 2
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            // 左边 和上一个差值
            int l = 2 * (numRows - i - 1);
            // 右边 和上一个差值
            int r = 2 * i;
            int index = i;
            sb.append(s.charAt(index));
            boolean flag = true;
            while ((index+l<length && flag) || (index+r<length && !flag)){
                if(index+l<length && flag){
                    if(l>0){
                        sb.append(s.charAt(index+l));
                        index = index+l;
                    }
                    flag = false;
                }
                if(index+r<length && !flag){
                    if(r>0){
                        sb.append(s.charAt(index+r));
                        index = index +r;
                    }
                    flag = true;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert("ABCDE", 4));
    }


    // 广度优先搜索 不行。。。
    public static String convert1(String s, int numRows) {
        int length = s.length();
        if (length <= numRows || numRows == 1) {
            return s;
        }
        // 如果字符串的长度是 2*numsRows -2  的倍数，那么一行的长度就是 length / (2*numsRows -2)  * (numRows - 1)  的长度
        // 多出来的 length / (2*numsRows -2)  * (numRows - 1) + 1
        int index = 0;
        StringBuilder sb = new StringBuilder();
        // 第一行的下标
        Queue<Integer> rowIndex = new LinkedList<>();
        // 剪枝
        boolean[] flags = new boolean[length];
        while (index < length) {
            rowIndex.add(index);
            sb.append(s.charAt(index));
            flags[index] = true;
            index += 2 * numRows - 2;
        }
        while (rowIndex.size() > 0) {
            Integer peek = rowIndex.poll();
            if (peek - 1 > 0 && !flags[peek - 1]) {
                rowIndex.add(peek - 1);
                sb.append(s.charAt(peek - 1));
                flags[peek - 1] = true;
            }
            if (peek + 1 < length && !flags[peek + 1]) {
                rowIndex.add(peek + 1);
                sb.append(s.charAt(peek + 1));
                flags[peek + 1] = true;
            }
        }
        return sb.toString();
    }
}