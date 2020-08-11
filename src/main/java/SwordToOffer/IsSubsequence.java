package SwordToOffer;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/27 10:14
 * @Version 1.0
 **/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int i=0,j=0;
        while (j<tArray.length){
            if(sArray[i]==tArray[j]){
                i++;
                if(i==s.length()){
                    return true;
                }
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        System.out.println(new IsSubsequence().isSubsequence("abc","aaaasafsbasdfasdasdfwer"));
    }
}
