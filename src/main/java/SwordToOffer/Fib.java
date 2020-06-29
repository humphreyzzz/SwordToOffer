package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 示例 1：
 输入：n = 2
 输出：1
 示例 2：
 输入：n = 5
 输出：5

 提示：
 0 <= n <= 100
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Fib {
    Map<Integer,Integer> fibMap = new HashMap();//java直接递归会超时，设置一个hashMap存放计算过的值，减少运算次数
    public int fib(int n) {
        if(fibMap.containsKey(n)){
            return fibMap.get(n);
        }
        int result;
        if(n<2) {
            result = n;
        }
        else{
            result =(fib(n-1)+fib(n-2))%1000000007;
        }
        fibMap.put(n,result);
        return result;
    }

    public static void main(String args[]){
        System.out.println(new Fib().fib(43));
    }
}
