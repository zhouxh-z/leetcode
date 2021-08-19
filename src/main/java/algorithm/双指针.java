package algorithm;

/**
 * @author zhouxh-z
 */
public class 双指针 {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * 请你设计时间复杂度为 O(n) 的算法解决本问题
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int length = nums.length;
        int j = length -1;
        int [] newNums = new int[length];
        for (int k = length -1; k >=0 ; k--) {
            final int i1 = nums[i] * nums[i];
            final int j1 = nums[j] * nums[j];
            if(i1>j1){
                i++;
                newNums[k] = i1;
            }else {
                j--;
                newNums[k] = j1;
            }
        }
        return newNums;
    }

    /**
     * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。

     * 进阶：
     *
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] ints = new int[nums.length * 2];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = nums[i % nums.length];
        }

        for (int i = 0; i< nums.length; i++) {
            nums[i] = ints[i+ nums.length - k];
        }

// jdk 自带方法

//        k = k%nums.length;
//
//        int[] ints = Arrays.copyOf(nums, nums.length-k);
//        int[] ints1 = Arrays.copyOfRange(nums, nums.length-k, nums.length);
//        System.arraycopy(ints1,0,nums,0,ints1.length);
//        System.arraycopy(ints,0,nums,ints1.length,ints.length);
    }


    public static void main(String[] args) {

        rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
