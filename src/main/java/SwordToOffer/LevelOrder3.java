package SwordToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

  

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

             3
          /   \
         9    20
             /  \
           15    7
 返回其层次遍历结果：

 [
 [3],
 [20,9],
 [15,7]
 ]
 提示：

 节点总数 <= 1000
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        boolean leftToRight = true;
        while (treeNodes.size()>0){
            List<TreeNode> tempList = new ArrayList<>();
            List<Integer> layerRes = new ArrayList<>();
            if(leftToRight){
                leftToRight = false;
                for(int i=0;i<treeNodes.size();i++){
                    if(treeNodes.get(i)!=null){
                        layerRes.add(treeNodes.get(i).val);
                    }
                }
            }else{
                leftToRight =true;
                for(int i=treeNodes.size()-1;i>=0;i--){
                    if(treeNodes.get(i)!=null){
                        layerRes.add(treeNodes.get(i).val);
                    }
                }
            }
            for(int i=0;i<treeNodes.size();i++){
                if(treeNodes.get(i)!=null){
                    tempList.add(treeNodes.get(i).left);
                    tempList.add(treeNodes.get(i).right);
                }
            }
            treeNodes = tempList;
            if(layerRes.size()>0){
                result.add(layerRes);
            }

        }
        return result;
    }
}
