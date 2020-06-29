package SwordToOffer;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

/**
 *
 从上到下打印出二叉树的每个节点，
 同一层的节点按照从左到右的顺序打印。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],
           3
         /   \
       9     20
            /   \
          15     7
 返回：
 [3,9,20,15,7]

 提示：
 节点总数 <= 1000
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> treeNodes = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        treeNodes.add(root);
        while(treeNodes.size()>0){
            Queue<TreeNode> nextLevel = new LinkedList<>();
            for(TreeNode treeNode:treeNodes){
                if(treeNode.left!=null){
                    nextLevel.add(treeNode.left);
                    list.add(treeNode.left.val);
                }
                if(treeNode.right!=null){
                    nextLevel.add(treeNode.right);
                    list.add(treeNode.right.val);
                }
            }
            treeNodes = nextLevel;
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return  result;
    }


}
