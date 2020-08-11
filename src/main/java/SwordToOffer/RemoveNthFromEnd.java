package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/27 10:27
 * @Version 1.0
 **/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode listNode = head;
        while (listNode!=null){
            count++;
            listNode = listNode.next;
        }
        if(count==1) return null;
        else if(count==n) return head.next;
        count = count -n+1;
        ListNode pre = head;
        listNode = pre.next;
        count = count-1;
        while (count>1){
            count--;
            pre = pre.next;
            listNode = listNode.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(head,2));
    }
}
