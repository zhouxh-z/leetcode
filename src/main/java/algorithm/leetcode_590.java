package algorithm;

/**
 *
 * 给你一个正整数数组nums，请你移除 最短子数组（可以为 空），使得剩余元素的 和能被 p整除。 不允许将整个数组都移除。
 *
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1。
 *
 * 子数组定义为原数组中连续的一组元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/make-sum-divisible-by-p
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhouxianghui6
 * @description
 * @date 2023/3/10
 */
public class leetcode_590 {

    public static int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum<p){
            return -1;
        }
        long ys = sum % p;
        if(ys == 0){
            return 0;
        }
        int mod = 0;
        for (int i = 0; i < nums.length; i++) {
            mod = (mod + nums[i]) % p;
            if(mod%p == 0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        System.out.println(minSubarray(nums, 26));
    }
}
