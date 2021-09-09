package algorithm.位运算;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @author zhouxh-z
 * @date 2021/9/8 10:43
 */
public class leetcode_136 {
    /**
     * 异或 n^n = 0
     * 0^n = n
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
