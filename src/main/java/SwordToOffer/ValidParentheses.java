package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/27 14:33
 * @Version 1.0
 **/

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    private Map<Character,Character> map= new HashMap<Character, Character>(){{
       put('(',')');
       put('[',']');
       put('{','}');
    }};
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for(char c:s.toCharArray()){
            if(map.containsKey(c)) {
                left.push(c);
            }
            else{
                if(left.isEmpty()){
                    return false;
                }
                else{
                    if(map.get(left.pop())!=c) return false;
                }
            }
        }
        if(left.isEmpty()) return true;
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);


    }

    private boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(!(left!=null&&right!=null)) return false;
        if(left.val!=right.val) return false;
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }


    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                     dfs(board,i,j,word.substring(1));
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,int i,int j,String word){
        if(word.length()==0) return true;
        return false;
    }

}
