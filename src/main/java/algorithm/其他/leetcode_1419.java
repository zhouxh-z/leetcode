package algorithm.其他;

/**
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以croakOfFrogs 中会混合多个 “croak”
 * 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 *
 * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
 *
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 *
 *
 * 示例 1：
 *
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 *
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用大小写区分
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "CRcOAKroak"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-frogs-croaking
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-frogs-croaking
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/10/20 9:50
 */
public class leetcode_1419 {
    /**
     * 思路：青蛙叫必然从 c 开始，到 k 结束，否则就是不合法 直接返回 -1
     * 那么只要得出青蛙同时叫的最大值就好了
     * 任意时刻 字母的出现次数 都有 c>r>o>a>k 的规则
     * @param croakOfFrogs
     * @return
     */
    public static int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length()%5>0){
            return -1;
        }
        int length = croakOfFrogs.length();
        char[] chars = croakOfFrogs.toCharArray();
        int count = 0,ccount = 0,rcount = 0, ocount = 0, acount = 0, kcount = 0, ts = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i]=='c') {
                ccount++;
                count++;
            }
            if (chars[i]=='r') {
                rcount++;
            }
            if (chars[i]=='o') {
                ocount++;
            }
            if (chars[i]=='a') {
                acount++;
            }
            if (chars[i] == 'k'){
                kcount++;
                count--;
            }
            if(!(ccount>=rcount&&rcount>=ocount&&ocount>=acount&&acount>=kcount)){
                return -1;
            }
            ts = Math.max(count,ts);
        }
        return ts;
    }
    public static void main(String[] args) {

        System.out.println(minNumberOfFrogs("croakcroak"));
    }
}
