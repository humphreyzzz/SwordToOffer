package SwordToOffer;

import java.util.*;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/24 11:21
 * @Version 1.0
 **/
public class LetterCombinations {

    Map<String,String> index = new HashMap<String,String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};

    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0){
            backTrack("",digits);
        }
        return res;
    }

    private void backTrack(String curString,String digits){
        if(digits.length()==0){
            res.add(curString);
            return;
        }
        else{
            String number = digits.substring(0,1);
            for(int i=0;i<index.get(number).length();i++){
                String newString = curString+index.get(number).substring(i,i+1);
                backTrack(newString,digits.substring(1));
            }
        }
    }

    public static void main(String[] args){

    }
}
