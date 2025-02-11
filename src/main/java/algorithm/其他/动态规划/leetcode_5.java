package algorithm.其他.动态规划;

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

    public String longestPalindrome2(String s) {
        // 动态规划
        // 1、列出动态方程 如果 s(x) == f(x-1)  || s(x) == f(x-2) 开始回文，且
        // 2、明确边界条件
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        int rtnStart = 0 ,rtnEnd = 1;
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            // 开始回文
            int start = 0, end = 0;
            if (c == s.charAt(i-1)){
                start = i-1;
                end = i;
                while (start>=0 && end<length){
                    if (s.charAt(start) == s.charAt(end)){
                        start --;
                        end ++;
                    }else {
                        break;
                    }
                }
                if (end - start - 1 > rtnEnd - rtnStart){
                    rtnStart = start+1;
                    rtnEnd = end;
                }
            }
            if (i>=2 && c == s.charAt(i - 2)){
                // 开始回文
                start = i-2;
                end = i;
                while (start>=0 && end<length){
                    if (s.charAt(start) == s.charAt(end)){
                        start --;
                        end ++;
                    }else {
                        break;
                    }
                }
                if (end - start - 1 > rtnEnd - rtnStart){
                    rtnStart = start+1;
                    rtnEnd = end;
                }
            }
        }
        return s.substring(rtnStart,rtnEnd);
    }


    public static void main(String[] args) {
        leetcode_5 l = new leetcode_5();
        System.out.println(l.longestPalindrome2("aaaa"));
    }
}
