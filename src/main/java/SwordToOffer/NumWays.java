package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 示例 1：
 输入：n = 2
 输出：2

 示例 2：
 输入：n = 7
 输出：21

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumWays {
    Map<Integer,Integer> fibMap = new HashMap();//java直接递归会超时，设置一个hashMap存放计算过的值，减少运算次数
    public int numWays(int n) {
        if(fibMap.containsKey(n)){
            return fibMap.get(n);
        }
        int result;
        if(n==0){
            result = 1;
        }
        else if(n==1) {
            result = 1;
        }
        else if(n==2){
            result=2;
        }
        else{
            result =(numWays(n-1)+numWays(n-2))%1000000007;
        }
        fibMap.put(n,result);
        return result;
    }
}
