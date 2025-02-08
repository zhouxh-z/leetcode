package algorithm.二分法;
/**
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 *
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 *
 * 两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 *
 * @ClassName algorithm.二分法
 * @Description:
 * @Author zhouxianghui6
 * @Date 2022/4/19 10:07
 * @since
 **/
public class leetcode_821 {
    public int[] shortestToChar(String s, char c) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = Integer.MAX_VALUE;
        }
        int start= 0,end = length -1 ;
        while (start <= end){
            if (chars[start] == c){
                for (int j = 0; j < length; j++) {
                    ints[j] = Math.min(ints[j],Math.abs(start-j));
                }
            }
            if (chars[end] == c){
                for (int j = 0; j < length; j++) {
                    ints[j] = Math.min(ints[j],Math.abs(end-j));
                }
            }
            start ++;
            end --;
        }
        return ints;
    }

}
