package algorithm.双指针;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 * @author zhouxh-z
 * @date 2021/11/18 14:32
 */
public class leetcode_offer_56 {
    List<Integer> ans = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        findTarget(root);
        int left = 0 ,right = ans.size()-1;
        while (left<right){
            int val = ans.get(left) + ans.get(right);
            if(val > k){
                right --;
            }
            if(val<k){
                left++;
            }
            if(val == k){
                return true;
            }
        }
        return false;
    }

    public void findTarget(TreeNode root) {
        if(root == null){
            return;
        }
        findTarget(root.left);
        ans.add(root.val);
        findTarget(root.right);
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
