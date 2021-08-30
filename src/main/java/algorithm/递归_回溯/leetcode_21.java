package algorithm.递归_回溯;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 1->2->4
 * 1->3->4
 * 新：
 *   1->->1->2->3->4->4
 * @author 17826
 */
public class leetcode_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null||l2 == null){
            return l1==null?l2:l1;
        }

        if(l1.val>l2.val){
            if(l2.next!=null){
                l2.next = mergeTwoLists(l1,l2.next);
            }else {
                l2.next = l1;
            }
            return l2;
        }
        if(l1.next!=null){
            l1.next = mergeTwoLists(l1.next,l2);
        }else {
            l1.next = l2;
        }
        return l1;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}