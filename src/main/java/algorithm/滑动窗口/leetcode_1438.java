package algorithm.滑动窗口;

/**
 * @author zhouxh-z
 * @date 2021/9/27 15:35
 */
public class leetcode_1438 {

    public int longestSubarray(int[] nums, int limit) {
        int lowIndex = 0, highIndex = 0,minNum = Integer.MAX_VALUE,maxNum = Integer.MIN_VALUE,ans = 0;
        while (lowIndex < nums.length && highIndex < nums.length){



        }
        return ans ;
    }

    public static void main(String[] args) {
        leetcode_1438 l = new leetcode_1438();
        System.out.println(l.longestSubarray(new int[]{8,2,4,7}, 4));
    }
}
