package algorithm.其他;

import java.util.Map;

/**
 * 给定一个长度为 n 的整数数组nums。
 *
 * 假设arrk是数组nums顺时针旋转 k 个位置后的数组，我们定义nums的 旋转函数F为：
 *
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回F(0), F(1), ..., F(n-1)中的最大值。
 *
 * 生成的测试用例让答案符合32 位 整数。
 *
 * 输入: nums = [4,3,2,6]
 * 输出: 26
 * 解释:
 *
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 *
 * 
 * @ClassName algorithm
 * @Description:
 * @Author zhouxianghui6
 * @Date 2022/4/22 9:45
 * @since
 **/
public class leetcode_396 {

    public static int maxRotateFunction(int[] nums) {
        int length = nums.length;
        int max = 0;
        int sum = 0;
        int bf = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            max += i*nums[i];
        }
        bf = max;
        for (int i = 1; i < length; i++) {
            max = Math.max(max,bf - sum + length * nums[i-1]);
            bf = bf - sum + length * nums[i-1];
        }
        return max;
    }


    public static void main(String[] args) {
        maxRotateFunction(new int[]{4,15,14,3,14,-8,12,-9,17,-1,15,1,10,19,-7,15,8,7,-8,11});
    }
}
