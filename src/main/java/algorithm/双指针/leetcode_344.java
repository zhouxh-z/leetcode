package algorithm.双指针;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhouxh-z
 */
public class leetcode_344 {
    public void reverseString(char[] s) {
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
        while (low>0){
            char c = s[low];
            s[low] = s[high];
            s[high] = c;
            low -- ;
            high ++;
        }
    }
}