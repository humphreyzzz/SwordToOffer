package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/26 15:01
 * @Version 1.0
 **/

import java.util.LinkedList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
    LinkedList<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return res;
    }

    private void dfs(int lNumber,int rNumber,String curString){
        if(lNumber==0&&rNumber==0){
            res.add(curString);
            return;
        }
        if(lNumber>rNumber){
            return;
        }
        if(rNumber>0){
            dfs(lNumber,rNumber-1,curString+")");
        }
        if(lNumber>0){
            dfs(lNumber-1,rNumber,curString+"(");
        }

    }

    public static void main(String[] args){
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
