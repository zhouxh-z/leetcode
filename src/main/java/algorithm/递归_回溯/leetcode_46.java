package algorithm.递归_回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author 17826
 */
public class leetcode_46 {


    /**
     * 思路：遍历答案的每个位置
     *               1        2       3    答案的第1个位置的可能性
     *           1   2   3                 答案的第2个位置的可能性
     *         1 2 3                       答案的第3个位置
     *                      ·                     ·
     *                      ·                     ·
     *                      ·                     ·
     * @param nums
     * @return
     */
    List<List<Integer>> ans = new ArrayList<>();
    // 每一次的集合
    List<Integer> an = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(an.size() == nums.length){
            ans.add(new ArrayList<>(an));
        }
        for (int i = 0; i < nums.length; i++) {
            if(!an.contains(nums[i])){
                an.add(nums[i]);
                permute(nums);
                an.remove((Object)nums[i]);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        final leetcode_46 leetcode_46 = new leetcode_46();
        final List<List<Integer>> permute = leetcode_46.permute(new int[]{1, 2,3});
    }
}
