package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

//    public Node copyRandomList(Node head) {
//        if(head==null) return null;
//        Map<Node,Node> map = new HashMap<>();
//        Node node = head;
//        while (node!=null){
//            map.put(node,new Node(node.val));
//            node= node.next;
//        }
//        node = head;
//        while (node!=null){
//            map.get(node).next = map.get(node.next);
//            node = node.next;
//        }
//        node = head;
//        while (node!=null){
//            map.get(node).random = map.get(node.random);
//            node = node.next;
//        }
//
//        return map.get(head);
//
//    }

    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node node = head;

        //将新节点添加到原链表，比如原链表为1->2->3，新链表为1->1'->2->2'->3->3`
        while (node!=null){
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        node = head;
        //复制random结点
        while (node!=null){
            if (node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        Node newHead = head.next;
        node = head;
        //拆分链表
        while (node!=null){
            Node temp = node.next;
            node.next = temp.next;
            if(node.next!=null){
                temp.next = node.next.next;
            }
            node = node.next;
        }
        return newHead;

    }
}
