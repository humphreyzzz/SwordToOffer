package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/24 16:30
 * @Version 1.0
 **/
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;

        ListNode xHead = new ListNode(x);
        ListNode xTail = xHead;
        while (head!=null&&head.val>=x){
            ListNode temp = head;
            head = head.next;
            xTail.next =temp;
            xTail =xTail.next;
            xTail.next =null;
        }
        if(head==null) return xHead.next;
        ListNode listNode = head.next;
        ListNode pre = head;

        while (listNode!=null){


            if(listNode.val>=x){
                ListNode temp = listNode;
                listNode = listNode.next;
                pre.next =listNode;
                xTail.next = temp;
                xTail = xTail.next;
                xTail.next = null;
            }
            else{
                pre = listNode;
                listNode = listNode.next;
            }
        }
        pre.next = xHead.next;
        xHead.next = null;
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        new Partition().partition(head,5);
        ListNode listNode = head;
        while (listNode!=null){
            System.out.print(listNode.val+"->");
            listNode = listNode.next;
        }
    }
}
