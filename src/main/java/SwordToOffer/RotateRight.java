package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/30 14:52
 * @Version 1.0
 **/
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        if(head==null||head.next==null) return head;
        int count = 1;
        while (tail.next!=null){
            count++;
            tail = tail.next;
        }
        int offset = k%count;
        if(offset==0) return head;
        offset = count -offset;
        ListNode listNode = head;
        ListNode pre = null;
        while (offset>0){
            offset--;
            pre = listNode;
            listNode = listNode.next;
        }
        tail.next = head;
        pre.next = null;
        return listNode;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new RotateRight().rotateRight(head,3));
    }
}
