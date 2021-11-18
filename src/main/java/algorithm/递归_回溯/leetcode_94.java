package algorithm.递归_回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 中序遍历 左节点 -> 根节点 -> 右节点
 * @author zhouxh-z
 * @date 2021/11/17 13:39
 */
public class leetcode_94 {

    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }
}
