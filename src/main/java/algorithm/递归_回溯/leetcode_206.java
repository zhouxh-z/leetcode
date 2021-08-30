package algorithm.递归_回溯;


/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 1->2->3->4
 *
 * 4->3->2->1
 * @author zhouxh_Z
 */
public class leetcode_206 {
    ListNode next = null;   // 2,
    ListNode parent = null; // 1,
    public ListNode reverseList(ListNode head) {
        if(head == null|| head.next == null){
            return head;
        }
        next = head.next;
        if(parent == null){
            head.next = null;
            parent = head;
        }else {
            head.next = parent;
            parent = head;
        }
        ListNode lastNode = reverseList(next);
        if(lastNode.next == null){
            lastNode.next = head;
        }
        return lastNode;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        leetcode_206 l = new leetcode_206();
        final ListNode listNode = l.reverseList(head);
    }
}