package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/31 11:16
 * @Version 1.0
 **/
public class LongestZigZag {
    private int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root==null) return 0;
        dfs(root,true,0);
        dfs(root,false,0);
        return max;
    }

    public void dfs(TreeNode root,boolean direction,int len){
        max = Math.max(max,len);
        //left
        if(direction){
            if(root.left!=null){
                dfs(root.left,true,1);
            }
            if(root.right!=null){
                dfs(root.right,false,len+1);
            }
            //right
        }else{
            if(root.left!=null){
                dfs(root.left,true,len+1);
            }
            if(root.right!=null){
                dfs(root.right,false,1);
            }
        }

    }
}
