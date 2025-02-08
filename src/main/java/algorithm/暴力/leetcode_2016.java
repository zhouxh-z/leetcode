package algorithm.暴力;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 *
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-difference-between-increasing-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author zhouxianghui6
 * @description
 * @date 2023/3/2
 */
public class leetcode_2016 {

    public int maximumDifference(int[] nums) {
        int max = -1;
        int min = nums[0];
        for (int i = 0; i <nums.length; i++) {
            // 判断遍历中的最小值，并保存
            int num = nums[i] - min;
            if(num>0){
                max = Math.max(max,num);
            }else {
                min = nums[i];
            }
        }

        return max;
    }

}
