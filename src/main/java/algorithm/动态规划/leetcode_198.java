package algorithm.动态规划;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhouxh
 */
public class leetcode_198 {

    // ff2 ff3 有问题 需要是 上两位的和
    public int rob(int[] nums) {
        int ff3 = 0,ff2 = 0,ff1 = 0,sum = 0;
        for (int i = 0; i < nums.length; i++) {
            ff2 =  ff1;
            ff3 = ff2;
            ff1 = sum;
            sum = Math.max(Math.max(ff3, ff2) + nums[i],ff1);

        }
        return sum;
    }
    
}
