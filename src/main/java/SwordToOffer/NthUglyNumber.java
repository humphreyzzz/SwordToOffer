package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/6/30 14:41
 * @Version 1.0
 **/

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int a=0,b=0,c=0;
        for(int i=1;i<n;i++){
            result[i]=Math.min(Math.min(result[a]*2,result[b]*3),result[c]*5);
            if(result[i]==result[a]*2) a++;
            if(result[i]==result[b]*3) b++;
            if(result[i]==result[c]*5) c++;
        }
        return result[n-1];
    }
}
