package SwordToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 示例:
 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL

 限制：
 0 <= 节点个数 <= 5000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {
//    public ListNode reverseList(ListNode head) {
//        if(head==null){
//            return null;
//        }
//        ListNode listNode = head;
//        List<Integer> list = new ArrayList<>();
//        while(listNode.next!=null){
//            list.add(listNode.val);
//            listNode = listNode.next;
//        }
//        ListNode newHead = new ListNode(list.get(list.size()-1));
//        listNode = newHead;
//        for(int i=list.size()-2;i>-1;i--){
//            listNode.next = new ListNode(list.get(i));
//            listNode = listNode.next;
//        }
//        listNode = null;
//        return newHead;
//    }
        public ListNode reverseList(ListNode head) {
            ListNode former = head ;
            ListNode latter = null;
            ListNode temp = null;
            while(former!=null){
                temp = former.next;
                former.next = latter;
                latter = former;
                former = temp;
            }
            return latter;
        }
        public static void main(String args[]){
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            System.out.println(new ReverseList().reverseList(head));
        }
}
