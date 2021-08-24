package algorithm.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhouxh-z
 */
public class leetcode_3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<=0){
            return 0;
        }
        int low =0;
        int high = 1;
        Map<Object, Object> map = new HashMap<>();
        int length = 0;
        map.put(s.charAt(low),"");
        while(high<s.length()){
            char c = s.charAt(high);
            if(!map.containsKey(c)){
                map.put(c,"");
                high++;
            }else{
                length = Math.max(length,high - low);
                map.remove(s.charAt(low),"");
                low++;
            }

        }
        length = Math.max(length,high - low);
        return length;
    }

    public static void main(String[] args) {
        String s = "aab";
        final int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
