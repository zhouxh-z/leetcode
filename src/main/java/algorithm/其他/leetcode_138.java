package algorithm.其他;

import java.util.*;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 
 * 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 *
 * 返回复制链表的头节点。
 *
 * 用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/10/14 13:41
 */
public class leetcode_138 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node tmp = head;
        Node node = null;
        Map<Node,Node> map = new HashMap<>();
        while (tmp!=null){
            Node node1 = new Node(tmp.val);
            if(node == null){
                node = node1;
            }
            map.put(tmp,node1);
            tmp = tmp.next;
        }
        Node tmpNode = node;
        while(head != null){
            if(head.next!=null){
                tmpNode.next = map.get(head.next);
            }
            if(head.random != null){
                tmpNode.random = map.get(head.random);
            }
            head = head.next;
            tmpNode = tmpNode.next;
        }
        return node;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        final leetcode_138 leetcode_138 = new leetcode_138();
        leetcode_138.copyRandomList(node1);
    }



}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}