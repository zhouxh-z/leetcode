package algorithm.双指针;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author zhouxh-z
 */
public class leetcode_557 {

    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder rtn = new StringBuilder();
        for (String str :s1) {
            char[] chars = str.toCharArray();
            reverseString(chars);
            rtn = rtn.append(new String(chars)).append(" ");
        }
        rtn.setLength(rtn.length()-1);
        return rtn.toString();
    }

    public static void reverseString(char[] s) {
        final int i = (s.length - 1) % 2;
        final int mid = (s.length - 1) / 2;
        int low ;
        int high ;
        if(i == 0){
            low = mid -1;
            high = mid+1;
        }else {
            low = mid;
            high = mid+1;
        }
        while (low>=0){
            char c = s[low];
            s[low] = s[high];
            s[high] = c;
            low -- ;
            high ++;
        }
    }

    public static void main(String[] args) {
        final String s = reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }
}