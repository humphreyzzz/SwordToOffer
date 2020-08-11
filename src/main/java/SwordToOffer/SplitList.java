package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/22 19:38
 * @Version 1.0
 **/
public class SplitList {
    public static void splitList(ListNode head){
        ListNode firstHead = head;
        ListNode secondHead =null;
        if(head!=null) secondHead = head.next;
        ListNode temp = head;
        ListNode tempNext = secondHead;

        while (tempNext!=null){
            temp.next = temp.next.next;
            temp = tempNext;
            tempNext = tempNext.next;
        }
        while (firstHead!=null){
            System.out.print(firstHead.val+" ");
            firstHead= firstHead.next;
        }
        System.out.println();
        while (secondHead!=null){
            System.out.print(secondHead.val+" ");
            secondHead = secondHead.next;
        }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        splitList(head);
    }
}
