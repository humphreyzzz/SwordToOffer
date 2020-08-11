package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/3 9:56
 * @Version 1.0
 **/
public class TreeToDoublyList {
    DoublyListNode head,pre;
    public DoublyListNode treeToDoublyList(DoublyListNode root) {
        if(root==null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void dfs(DoublyListNode node){
        if(node == null) return;
        dfs(node.left);
        if(pre != null) pre.right = node;
        else head = node;
        node.left = pre;
        pre = node;
        dfs(node.right);

    }

    public static void main(String[] args){
        DoublyListNode root = new DoublyListNode(4);
        root.left = new DoublyListNode(2);
        root.right = new DoublyListNode(5);
        root.left.left = new DoublyListNode(1);
        root.left.right = new DoublyListNode(3);

        new TreeToDoublyList().treeToDoublyList(root);
    }
}