package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/3 9:55
 * @Version 1.0
 **/
public class DoublyListNode {
    public int val;
    public DoublyListNode left;
    public DoublyListNode right;

    public DoublyListNode() {}

    public DoublyListNode(int _val) {
        val = _val;
    }

    public DoublyListNode(int _val, DoublyListNode _left, DoublyListNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
