package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/6/30 11:03
 * @Version 1.0
 **/

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 *
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 * 限制：
 * 1 <= n <= 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiceTwoSum {
    public double[] twoSum(int n) {
        int[][] res = new int[n+1][6*n+1];
        for(int i=1;i<7;i++){
            res[1][i] = 1;
        }
        for(int i=2;i<n;i++){
            for(int s=i;s<=6*i;s++){
                for(int d=1;d<7;d++){
                    if(s-d<i-1) break;
                    res[i][s]+=res[i-1][s-d];
                }
            }
        }
        double total = Math.pow(6,n);
        double[] ans = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)res[n][i])/total;
        }
        return ans;


    }
}
