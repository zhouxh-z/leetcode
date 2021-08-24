package algorithm.滑动窗口;

import java.util.Arrays;

/**
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 */
public class leetcode_567 {

    public boolean checkInclusion2(String s1, String s2) {
        // 情况一：s2 长度小于 s1
        if(s2.length()<s1.length()){
            return false;
        }
        int length = s1.length();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int low = 0;
        for (int i = 0; i < length; i++) {
            cnt1[s1.charAt(i)-'a'] ++;
            cnt2[s2.charAt(low+i)-'a'] ++;
        }
        if(Arrays.equals(cnt1,cnt2)){
            return true;
        }
        while (low<s2.length()-s1.length()){
            cnt2[s2.charAt(low+length)-'a'] ++;
            cnt2[s2.charAt(low)-'a'] --;
            low++;
            if(Arrays.equals(cnt1,cnt2)){
                return true;
            }
        }
        return false;
    }
}
