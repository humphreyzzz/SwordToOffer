package SwordToOffer;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        ListNode listNode = next;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(val);
        while (listNode!=null){
            stringBuffer.append("->");
            stringBuffer.append(listNode.val);
            listNode= listNode.next;
        }
        return stringBuffer.toString();
    }
}
