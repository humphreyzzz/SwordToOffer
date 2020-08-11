package SwordToOffer;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/14 21:00
 * @Version 1.0
 **/
public class TraversalTree {

    /**
     * 中序遍历递归实现
     * @param root
     */
    public static void inTraversal(TreeNode root){
        if(root==null) return;
        inTraversal(root.left);
        System.out.println(root.val);
        inTraversal(root.right);
    }

    /**
     * 中序遍历栈实现
     * @param root
     */

    public static void inTraversalStack(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()){
            while (stack.peek().left!=null){
                stack.push(stack.peek().left);
            }
            while (!stack.isEmpty()){
                TreeNode treeNode = stack.pop();
                System.out.print(treeNode.val+" ");
                if(treeNode.right!=null){
                    stack.push(treeNode.right);
                    break;
                }
            }


        }
    }

    /**
     * 前序遍历递归实现
     * @param root
     */
    public static void preTraversal(TreeNode root){
        if(root==null) return;
        System.out.println(root.val);
        preTraversal(root.left);
        preTraversal(root.right);
     }

    /**
     * 前序遍历栈实现
     * @param root
     */
     public static void preTraversalStack(TreeNode root){
        if(root ==null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val);
            //注意，此处先压右结点，再压左节点
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }

    }


    public static void postTraversal(TreeNode root){
         if(root==null) return;
         postTraversal(root.left);
         postTraversal(root.right);
         System.out.print(root.val+" ");
    }

    public static void postTraversalStack(TreeNode root){
         if(root==null){
             return;
         }
         Stack<TreeNode> stack = new Stack<>();
         stack.push(root);
        while (!stack.empty()){
            while (stack.peek().right!=null){
                stack.push(stack.peek().right);
            }
            while (!stack.isEmpty()){
                TreeNode treeNode = stack.pop();
                System.out.print(treeNode.val+" ");
                if(treeNode.left!=null){
                    stack.push(treeNode.left);
                    break;
                }
            }


        }
    }
    public static void levelOrder(TreeNode root) {
        TreeNode node = root;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(node);
        while(!list.isEmpty()) {
            node=list.poll();
            System.out.print(node.val);
            if(node.left!=null)
                list.offer(node.left);
            if(node.right!=null)
                list.offer(node.right);
        }
    }




    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        //postTraversal(root);
        levelOrder(root);
    }
}
