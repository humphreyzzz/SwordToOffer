package OnlineTest;

import java.util.Scanner;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/11 19:01
 * @Version 1.0
 **/
public class Main8 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        int count = 0;
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                count++;
            }
        }
        System.out.println(count);
    }
}
