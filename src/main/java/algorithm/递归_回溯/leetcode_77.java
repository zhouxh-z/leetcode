package algorithm.递归_回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * @author 17826
 */
public class leetcode_77 {
    /**
     * ans 中的一个元素
     */
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combine(0,n,k);
        return ans;
    }
    public void combine(int num,int n, int k) {
        if((n - num + 1) + temp.size() < k){
            return;
        }
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // num 被选中
        temp.add(num);
        combine(num+1,n,k);
        // num 不被选中
        temp.remove((Object)num);
        combine(num+1,n,k);
    }


    public static void main(String[] args) {
        leetcode_77 leetcode77 = new leetcode_77();
        final List<List<Integer>> combine = leetcode77.combine(4, 2);
        System.out.println();
    }
}
