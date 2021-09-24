package algorithm.动态规划;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * @author zhouxh-z
 * @date 2021/9/22 21:02
 */
public class leetcode_5 {
    /**
     * 没用 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        final int length = s.length();
        boolean [][] ax = new boolean[length][length];
        int beginIndex = 0;
        int endIndex = 1;
        // 先找到最小回文
        for (int i = 0; i < length; i++) {
            // 情况1： 两个相连的相同
            if(i+1<length && s.charAt(i) == s.charAt(i+1)){
                int begin = i;
                int end = i+1;
                while (begin>=0&&end<length&&s.charAt(begin) == s.charAt(end)){
                    begin--;
                    end ++;
                }
                if(endIndex-beginIndex < end-(begin+1)){
                    beginIndex = begin+1;
                    endIndex = end;
                }
            }
            // 情况2： 空一格的两个相同
            if(i+2<length && s.charAt(i) == s.charAt(i+2)){
                int begin = i;
                int end = i+2;
                while (begin>=0&&end<length&&s.charAt(begin) == s.charAt(end)){
                    begin--;
                    end ++;
                }
                if(endIndex-beginIndex < end-(begin+1)){
                    beginIndex = begin+1;
                    endIndex = end;
                }
            }
        }
        return s.substring(beginIndex,endIndex);
    }

    public static void main(String[] args) {
        leetcode_5 l = new leetcode_5();
        System.out.println(l.longestPalindrome("abcbca"));
    }
}
