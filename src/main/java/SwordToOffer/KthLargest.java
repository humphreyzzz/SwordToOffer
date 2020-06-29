package SwordToOffer;

/**
 * Created with IDEA
 * author:hh
 * Date:2020/6/28
 * Time:20:11
 */
public class KthLargest {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
