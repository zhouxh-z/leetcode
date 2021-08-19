package algorithm;

/**
 * 二分法查找数据
 * @author zhouxh-z
 */
public class 二分法 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        final int search = searchInsert(nums, 8);
        System.out.println(search);
    }

    /**
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>target){
                high = mid-1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else if(nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low<high){
            int mid = low + (high-low)/2;
            if(nums[mid]>target){
                high = mid;
            }else if(nums[mid]<target){
                low = mid+1;
            }else {
                return mid ;
            }
        }
        return low;
    }

}
