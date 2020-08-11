package OnlineTest;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/11 19:12
 * @Version 1.0
 **/

/**
 *         Scanner in = new Scanner(System.in);
 *         int n = in.nextInt();
 *         for (int i=0;i<n;i++){
 *             long x = in.nextLong();
 *             long y = in.nextLong();
 *
 *             if(x%2==0||y%2==0){
 *                 System.out.println(2);
 *             }else{
 *                 System.out.println(Math.max(x,y));
 *             }
 *         }
 */

public class Main9 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            if(n==1||m==1){
                System.out.println(1);
            }else {
                int del[] = new int[n*m+1];
                int son[] = new int[n*m+1];

                List<Integer> data = new ArrayList<>();
                for(int j=2;j<=n*m;j++){
                    if(del[j]==0){
                        data.add(j);
                        son[j] = j;
                    }
                    for(int i1=0;i1<data.size();i1++){
                        if(i*data.get(i1)>n*m){
                            break;
                        }
                        del[i*data.get(i1)] = 1;
                        son[i*data.get(i1)] = data.get(i1);
                        if(i%data.get(i1)==0){
                            break;
                        }
                    }
                }
                System.out.println(son[n*m]);
            }

        }

    }


}
