package algorithm.双指针;

import java.util.Arrays;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/9/15 13:43
 */
public class leetcode_844 {
    public boolean backspaceCompare(String s, String t) {
        final char[] chars = s.toCharArray();
        final char[] chart = t.toCharArray();
        final int length = chars.length;
        final int length1 = chart.length;
        final int l = length >= length1 ? length : length1;
        StringBuilder sstringBuilder = new StringBuilder();
        StringBuilder tstringBuilder = new StringBuilder();
        for (int i = 0; i < l; i++) {
            if(i<length && chars[i] == '#'){
                final int length2 = sstringBuilder.length();
                if(length2>0){
                    sstringBuilder.deleteCharAt(length2-1);
                }

            }else if(i<length && chars[i] != '#'){
                sstringBuilder.append(chars[i]);
            }
            if(i<length1 && chart[i] == '#'){
                final int length2 = tstringBuilder.length();
                if(length2>0){
                    tstringBuilder.deleteCharAt(length2-1);
                }
            }else if(i<length1 && chart[i] != '#'){
                tstringBuilder.append(chart[i]);
            }
        }
        return sstringBuilder.toString().equals(tstringBuilder.toString());
    }

    public static void main(String[] args) {
        leetcode_844 l = new leetcode_844();
        System.out.println(l.backspaceCompare("xywrrmp",
                "xywrrmu#p"));
    }
}
