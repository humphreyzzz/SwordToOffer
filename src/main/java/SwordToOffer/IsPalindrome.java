package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/5 14:58
 * @Version 1.0
 **/
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        //如果链表只有一个有效节点或者不存在有效节点，那么就直接返回false
        if (head == null || head.next == null) {
            return true;
        }
        //通过快慢指针找到中间节点
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            //快指针比慢指针快一倍，快指针指向nuLl的时候慢指针就是指向链表中点
            quick = quick.next.next;
            slow = slow.next;
        }
        //找到指针中点之后。从slow 开始对后面的链表进行反转
        ListNode tempHead = null;
        ListNode p = slow;
        while (p != null) {
            ListNode cur = p.next;//保存后面的节点，防止丢失
            p.next = tempHead;
            tempHead = p;
            p = cur;
        }

        //得到了新的链表tempHead 然后将前后两条链表进行比对，完全相同为true 否则为false
        while (tempHead != null) {
            if (tempHead.val == head.val) {
                tempHead = tempHead.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        new IsPalindrome().isPalindrome(head);
    }
}
