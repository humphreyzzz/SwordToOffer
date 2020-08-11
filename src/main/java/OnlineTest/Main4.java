package OnlineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/7 19:05
 * @Version 1.0
 **/
public class Main4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder origin = new StringBuilder(in.nextLine());
        int num = Integer.parseInt(in.nextLine());
        String[] strings = new String[num];
        boolean[] state = new boolean[num];
        for(int i=0;i<num;i++){
            strings[i] = in.nextLine();
        }
        boolean isDone =  false;

        while (!isDone){
            for (int i=0;i<num;i++){
                int index = origin.indexOf(strings[i]);
                if(index!=-1){
                    origin.replace(index,index+strings[i].length(),"");
                    state[i] = true;
                }else{
                    state[i] = false;
                }
            }
            isDone = true;
            for (int i=0;i<num;i++){
                if(state[i]){
                    isDone = false;
                }
            }
        }
        System.out.println(origin);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
    }
}
