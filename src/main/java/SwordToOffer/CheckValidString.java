package SwordToOffer;

import java.util.Stack;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/24 10:24
 * @Version 1.0
 **/
public class CheckValidString {
    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i= 0;i<chars.length;i++){
            if( chars[i] =='(') leftStack.push(i);
            else if(chars[i]==')'){
                if(!leftStack.isEmpty()) leftStack.pop();
                else if(!starStack.isEmpty()) starStack.pop();
                else return false;
            }
            else if(chars[i]=='*') starStack.push(i);
        }
        while (!leftStack.isEmpty()){
            if (starStack.isEmpty()) return false;
            if(leftStack.peek()>starStack.peek()) return false;
            else{
                leftStack.pop();
                starStack.pop();
            }
        }
        return true;
    }
}
