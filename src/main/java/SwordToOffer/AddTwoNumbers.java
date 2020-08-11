package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/24 20:00
 * @Version 1.0
 **/
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        int intial = (l1==null?0:l1.val)+(l2==null?0:l2.val);
        l1 = l1.next;l2 = l2.next;
        int carry =0;
        if(intial>=10){
            intial = intial%10;
            carry=1;
        }
        ListNode newHead = new ListNode(intial);
        ListNode listNode = newHead;
        int sum;
        while (l1!=null&&l2!=null){
            sum = l1.val+l2.val+carry;
            if(sum>=10){
                sum = sum%10;
                carry=1;
            }
            else {
                carry=0;
            }
            listNode.next = new ListNode(sum);
            listNode = listNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            sum = l1.val+carry;
            if(sum>10){
                sum = sum%10;
                carry=1;
            }
            else {
                carry=0;
            }
            listNode.next = new ListNode(sum);
            listNode = listNode.next;
            l1 = l1.next;
        }
        while (l2!=null){
            sum = l2.val+carry;
            if(sum>10){
                sum = sum%10;
                carry=1;
            }
            else {
                carry=0;
            }
            listNode.next = new ListNode(sum);
            listNode = listNode.next;
            l2 = l2.next;
        }
        if(carry>0){
            listNode.next = new ListNode(carry);
            listNode = listNode.next;
        }
        return newHead;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(7);
        head.next = new ListNode(1);
        head.next.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(2);
        System.out.println(new AddTwoNumbers().addTwoNumbers(head,l2));
    }
}
