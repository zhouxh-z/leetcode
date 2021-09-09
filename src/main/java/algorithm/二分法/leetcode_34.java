package algorithm.二分法;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 进阶：
 *      你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/9/8 11:43
 */
public class leetcode_34 {

    // 双指针法
    public int[] searchRange(int[] nums, int target) {
        if(nums.length<=0){
            return new int[]{-1,-1};
        }
        int low = 0;
        int high = nums.length-1;

        while (low <= high&&(nums[low]!=target||nums[high]!=target)){
            if(nums[low]!=target){
                low++;
            }
            if(nums[high]!=target){
                high--;
            }
        }
        if(nums[low]==target&&nums[high]==target){
            return new int[]{low,high};
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        leetcode_34 l = new leetcode_34();
        l.searchRange(new int[]{5,7,7,8,8,10},8);
    }
}
