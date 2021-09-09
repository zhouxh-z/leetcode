package algorithm.二分法;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给你一个输入数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设nums[-1] = nums[n] = -∞
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/9/9 10:27
 */
public class leetcode_162 {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int low = 0,high = nums.length-1,mid = (low+high)/2 ;
        while (low<=high){
            if(low == mid){
                return nums[low]>=nums[high]?low:high;
            }
            if(nums[mid]>nums[mid-1]){
                // 升序
                low = mid;
                mid = (low+high)/2;
            }else if(nums[mid]<nums[mid-1]){
                // 降序
                high = mid-1;
                mid = (low+high)/2;
            }
        }
        return 0;

    }
}
