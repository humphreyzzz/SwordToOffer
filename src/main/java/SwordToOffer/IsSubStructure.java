package SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 * (约定空树不是任意一个树的子结构)

 B是A的子结构， 即 A中有出现和B相同的结构和节点值。

 例如:
 给定的树 A:

             3
            / \
          4    5
          / \
        1    2
 给定的树 B：

            4 
           /
         1
 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

 示例 1：
 输入：A = [1,2,3], B = [3,1]
 输出：false

 示例 2：
 输入：A = [3,4,5,1,2], B = [4,1]
 输出：true

 限制：
 0 <= 节点个数 <= 10000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null) return false;
        List<TreeNode> startNodes = getSameNode(A,B);
        for(TreeNode node:startNodes){
            if(judge(node,B)){
                return true;
            }
        }
        return false;
    }

    public List<TreeNode> getSameNode(TreeNode A, TreeNode B){
        TreeNode temp = A;
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(temp);
        while (treeNodes.size()>0){
            for(int i=treeNodes.size();i>0;i--){
                temp = treeNodes.poll();
                if(temp!=null){
                    if(temp.val == B.val){
                        list.add(temp);
                    }
                    treeNodes.add(temp.left);
                    treeNodes.add(temp.right);
                }

            }
        }
        return list;
    }

    public boolean judge(TreeNode A, TreeNode B){
        if(B==null) return true;
        if(A==null) return false;
        if(A.val!=B.val) return false;
        return judge(A.left,B.left)&&judge(A.right,B.right);
    }
}
























