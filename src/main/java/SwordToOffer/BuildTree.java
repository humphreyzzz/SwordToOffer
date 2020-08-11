package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 例如，给出
 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

                   3
                /    \
               9      20
                    /   \
                  15     7

 限制：
 0 <= 节点个数 <= 5000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inIndex);
    }

    public TreeNode buildTree(int[] preorder, int inLeft, int inRight, int preLeft, int preRight, Map<Integer, Integer> inIndex) {
        int rootVal = preorder[inLeft];
        TreeNode root = new TreeNode(rootVal);
        if (inLeft == inRight) {
            return root;
        }
        int index = inIndex.get(rootVal);

        int leftLength = index - preLeft;
        int rightLength = preRight - index;
        if (leftLength <= 0) {
            root.left = null;
        } else {
            root.left = buildTree(preorder, inLeft + 1, inLeft + leftLength, preLeft, preLeft + leftLength - 1, inIndex);
        }
        if (rightLength <= 0) {
            root.right = null;
        } else {
            root.right = buildTree(preorder, inLeft + leftLength + 1, inLeft + leftLength + rightLength, index + 1, preRight, inIndex);
        }
        return root;
    }

    public static void main(String args[]){
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(preorder,inorder);
    }
}
