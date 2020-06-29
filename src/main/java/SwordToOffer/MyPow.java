package SwordToOffer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

 示例 1:
 输入: 2.00000, 10
 输出: 1024.00000

 示例 2:
 输入: 2.10000, 3
 输出: 9.26100

 示例 3:
 输入: 2.00000, -2
 输出: 0.25000
 解释: 2-2 = 1/22 = 1/4 = 0.25

 说明:
 -100.0 < x < 100.0
 n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 快速幂，思想是不断地将n/2，以减少总的乘法次数
 */
public class MyPow {
    public double myPow(double x, int n) {
        double res = 1;
        long nLong = (long)n;
        if(nLong<0){
            x=1/x;
            nLong=-nLong;
        }
        while(nLong>0){
            if(nLong%2 == 1) res = res * x;
            x = x *x;
            nLong = nLong / 2;
        }
        return res;
    }

    public static void main(String args[]){
        System.out.println(new MyPow().myPow(0.00001 ,2147483647));
    }
}
