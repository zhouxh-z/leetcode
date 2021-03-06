package algorithm.双指针;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例：
 *  输入: [0,1,0,3,12]
 *  输出: [1,3,12,0,0]
 *
 * 说明：
 *  必须在原数组上操作，不能拷贝额外的数组。
 *  尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 */
public class leetcode_283 {
    public void moveZeroes(int[] nums) {
        int low = 0;
        int high = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(nums[i] == 0){
                low ++;
            }else {
                nums[high] = nums[i];
                high++;
            }
        }
        for (int i = 0; i < low; i++) {
            nums[length-1-i] = 0;
        }

    }
}