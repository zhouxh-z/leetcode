package algorithm.双指针;

/**
 *给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author zhouxh-z
 */

public class leetcode_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(0, head);
        ListNode slowNode = listNode;
        ListNode fastNode = listNode;
        if(head.next==null){
            return null;
        }
        int i=0;
        while (fastNode.next!=null){
            fastNode = fastNode.next;
            if(i>=n){
                slowNode = slowNode.next;
            }
            i++;
        }
        // 如果头还在 0 的位置，意味着删除第一个
        if(slowNode == listNode){
            return listNode.next.next;
        }
        // n=1 删除最后一个
        if(n == 1){
            slowNode.next = null;
        }else {
            slowNode.next = slowNode.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
    }


}
