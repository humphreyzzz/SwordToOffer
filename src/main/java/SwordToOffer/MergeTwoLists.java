package SwordToOffer;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode head = newList;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                newList.next = l1;
                l1 = l1.next;
            }else{
                newList.next= l2;
                l2 = l2.next;
            }
            newList = newList.next;
        }
        newList.next = l1==null?l2:l1;
        return head.next;
    }
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next  = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(new MergeTwoLists().mergeTwoLists(l1,l2));
    }
}
