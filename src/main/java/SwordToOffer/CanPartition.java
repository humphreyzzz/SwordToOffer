package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/4 17:15
 * @Version 1.0
 **/

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        //
        for(int i=0;i<nums.length+1;i++){
            dp[0][i]=true;
        }
        for(int i=1;i<nums.length+1;i++){
            for (int j=0;j<target+1;j++){
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]]||dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    public static void main(String[] args){
        new CanPartition().canPartition(new int[]{1,5,11,5});
    }
}
