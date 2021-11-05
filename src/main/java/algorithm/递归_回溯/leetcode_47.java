package algorithm.递归_回溯;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @author zhouxh-z
 * @date 2021/11/4 14:43
 */
public class leetcode_47 {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> an = new ArrayDeque<>();
    boolean[] flag ;
    int size = 0;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        size = nums.length;
        flag = new boolean[nums.length];
        permuteUnique1(nums);
        return ans;
    }
    public void permuteUnique1(int[] nums) {
        if(an.size() == size){
            ans.add(new ArrayList<>(an));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(flag[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && flag[i - 1]) {
                continue;
            }
            an.addLast(nums[i]);
            flag[i] = true;
            permuteUnique1(nums);
            an.removeLast();
            flag[i] = false;
        }
    }



        public static void main(String[] args) {
        leetcode_47 l = new leetcode_47();
        l.permuteUnique(new int[]{1,1,2,2});
    }

}
