package SwordToOffer;

import java.util.*;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/20 14:11
 * @Version 1.0
 **/
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return new LinkedList<>();
        queue.add(root);

        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()){
            LinkedList<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode treeNode = queue.poll();
                if(treeNode.left!=null) temp.add(treeNode.left);
                if(treeNode.right!=null) temp.add(treeNode.right);
                if(queue.isEmpty()) res.add(treeNode.val);
            }
            queue = temp;
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.print(new RightSideView().rightSideView(root));
    }
}
