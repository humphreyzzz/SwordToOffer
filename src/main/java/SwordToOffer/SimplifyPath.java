package SwordToOffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/31 21:24
 * @Version 1.0
 **/
public class SimplifyPath {
    public String simplifyPath(String path) {
        LinkedList<String> linkedList = new LinkedList<>();
        String[] xs = path.split("/");
        for (String string:xs){
            if(".".equals(string)) {

            }
            else if ("..".equals(string)){
                if(!linkedList.isEmpty()){
                    linkedList.pollLast();
                }
            }
            else if(string.length()>0){
                linkedList.addLast(string);
            }
        }
        StringBuilder builder = new StringBuilder("/");
        while (!linkedList.isEmpty()){
            builder.append(linkedList.pollFirst());
            builder.append("/");
        }
        return builder.length()>1?builder.substring(0,builder.length()-1):builder.toString();
    }

    public static void main(String[] args){
        System.out.println(new SimplifyPath().simplifyPath("/a/./b/../../c/"));
    }
}
