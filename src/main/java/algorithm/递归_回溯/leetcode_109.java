package algorithm.递归_回溯;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @author zhouxh-z
 */
public class leetcode_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        int count = 1;
        ListNode tmp = head;
        while (head.next!=null){
            head = head.next;
            count++;
        }
        // 确认 root 节点
        ListNode leftNode = tmp;
        for (int i = 1; i < count/2; i++) {
            tmp = tmp.next;
        }
        if(tmp.next==null){
            return new TreeNode(tmp.val);
        }
        TreeNode root = new TreeNode(tmp.next.val);
        ListNode rightNode = tmp.next.next;
        tmp.next =null;
        // 左边
        root.right= sortedListToBST(rightNode);
        // 右边
        root.left = sortedListToBST(leftNode);
        return root;
    }



    public static void main(String[] args) {
        leetcode_109 l = new leetcode_109();
        final ListNode listNode = new ListNode(-10, new ListNode(-3, new ListNode(0,
                new ListNode(5, new ListNode(9)))));
        final TreeNode treeNode = l.sortedListToBST(listNode);
        System.out.println(
        );
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