package algorithm.双指针;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/9/10 14:37
 */
public class leetcode_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans =new ListNode();
        ListNode bns = ans;
        ListNode nHead = new ListNode(-1000);
        nHead.next = head;
        ListNode before = nHead;
        ListNode after = head;
        while (after!=null && after.next!=null){
            if(before.val != after.val && after.val != after.next.val){
                ans.next = new ListNode(after.val) ;
                ans = ans.next;
            }
            before = before.next;
            after = after.next;
        }
        if(before.val != after.val){
            ans.next = new ListNode(after.val);
        }
        return bns.next;
    }

    public static void main(String[] args) {
        leetcode_82 l = new leetcode_82();
        ListNode ans1 =new ListNode(1);
        ListNode ans2 =new ListNode(2);
        ListNode ans3 =new ListNode(2);
//        ListNode ans4 =new ListNode(3);
//        ListNode ans5 =new ListNode(3);
//        ListNode ans6 =new ListNode(4);
//        ListNode ans7 =new ListNode(5);
        ans1.next = ans2;
        ans2.next = ans3;
//        ans3.next = ans4;
//        ans4.next = ans5;
//        ans5.next = ans6;
//        ans6.next = ans7;

        l.deleteDuplicates(ans1);
    }
}
