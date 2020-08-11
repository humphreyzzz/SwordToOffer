package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/30 9:10
 * @Version 1.0
 **/

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveKdigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();
        for(int i=0;i<num.length();i++){
            if(stack.isEmpty()){
                stack.push(chars[i]);
            }else{
                while(!stack.isEmpty()&&stack.peek()>chars[i]&&k>0){
                    stack.pop();
                    k--;
                }
                stack.push(chars[i]);
            }
            if(k==0){
                for(int j=i+1;j<num.length();j++){
                    stack.push(chars[j]);
                }
                break;
            }
        }
        while (k>0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty())
            return "0";
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        //去掉sb尾部的0（也就是结果头部的0），且只剩0的时候不能删
        while(sb.length()>1&&sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);
        }
        //从后往前添加所以我们要逆序
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(removeKdigits("1234567890",9));
    }
}
