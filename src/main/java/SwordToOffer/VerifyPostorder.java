package SwordToOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。

 参考以下这颗二叉搜索树：

               5
             / \
           2    6
         / \
       1    3
 示例 1：

 输入: [1,6,3,2,5]
 输出: false
 示例 2：

 输入: [1,3,2,6,5]
 输出: true

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0) return true;


        return reccurJudge(postorder,0,postorder.length-1);
    }

    private int getFlag(int[] postorder,int left,int right){
        int root = postorder[right];
        for(int i=left;i<right+1;i++){
            if(postorder[i]>root) return i;
        }
        return right;
    }

    private boolean reccurJudge(int [] postorder,int left, int right){
        if(left>=right) return true;
        int flag = getFlag(postorder,left,right);
        //右子树所有值均大于根节点
        for(int i=flag;i<right;i++){
            if(postorder[i]<postorder[right]) return false;
        }
        //左子树所有值均小于根节点
        for(int i=left;i<flag;i++){
            if(postorder[i]>postorder[right]) return false;
        }
        return reccurJudge(postorder,left,flag-1)&&reccurJudge(postorder,flag,right-1);
    }

    public static void main(String args[]){
        System.out.println(new VerifyPostorder().verifyPostorder(new int[]{1,6,3,2,5}));
    }
}
