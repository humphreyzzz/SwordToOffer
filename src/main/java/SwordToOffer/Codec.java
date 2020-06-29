package SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。

 示例: 

 你可以将以下二叉树：

              1
             / \
            2   3
           / \
         4   5

 序列化为 "[1,2,3,null,null,4,5]"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==null) return "[null]";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer("[");
        queue.add(root);
        while (queue.size()>0){
            TreeNode treNode = queue.poll();
            if(treNode!=null){
                if (stringBuffer.toString().equals("[")){
                    stringBuffer.append(treNode.val);
                }
                else{
                    stringBuffer.append(",");
                    stringBuffer.append(treNode.val);
                }
                queue.add(treNode.left);
                queue.add(treNode.right);
            }
            else{
                stringBuffer.append(",");
                stringBuffer.append("null");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String res = data.substring(1,data.length()-1);
        String nodes[] = res.split(",");
        if(nodes[0].equals("null")) return null;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        treeNodeQueue.add(root);
        int index = 0;
        while(index<nodes.length-1){
            TreeNode treNode = treeNodeQueue.poll();
            if(nodes[index].equals("null")){
                treNode.left = null;
                index++;
            }
            else{
                treNode.left = new TreeNode(Integer.parseInt(nodes[index]));
                index ++;
                treeNodeQueue.add(treNode.left);
            }
            if(nodes[index].equals("null")){
                treNode.right = null;
                index++;
            }else{
                treNode.right = new TreeNode(Integer.parseInt(nodes[index]));
                index ++;
                treeNodeQueue.add(treNode.right);
            }
        }
        return root;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        codec.deserialize(codec.serialize(root));

    }
}
