package algorithm.双指针;

/**
 * 给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 
 * 示例 1：
 *
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhouxh-z
 */
public class leetcode_167 {
    public static int[] twoSum(int[] numbers, int target) {
        final int length = numbers.length;
        int[] ints = new int[2];
        int low = 0;
        int high = length-1;
        for (int i = 0; i < length; i++) {
            if(numbers[low]+numbers[high] > target){
                high--;
            }else if(numbers[low]+numbers[high] < target){
                low++;
            }else if(numbers[low]+numbers[high] == target){
                ints[0] = low;
                ints[1] = high;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] in = new int[]{2,3,4};
        final int[] ints = twoSum(in, 6);
        System.out.println();
    }
}