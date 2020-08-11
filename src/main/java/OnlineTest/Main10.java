package OnlineTest;

import java.util.Scanner;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/11 19:37
 * @Version 1.0
 **/
public class Main10 {

    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        if(n==1){
            System.out.println(1);
        }else{
            int[] dp = new int[n];
            int[] len = new int[n];
            dp[0] = nums[0];
            len[0] = 1;
            for(int i=1;i<n;i++){
                if((nums[i]|dp[i-1])>nums[i]){
                    dp[i] = nums[i]|dp[i-1];
                    len[i] = len[i-1]++;
                }else{
                    dp[i] = nums[i];
                    len[i] = 1;
                }
            }
            int minLen = Integer.MIN_VALUE;
            int max = 0;
            for(int i=0;i<n;i++){
                if(max<dp[i]){
                    max = dp[i];
                }
            }
            for(int i=0;i<n;i++){
                if(dp[i]==max){
                    if(minLen<len[i]){
                        minLen=len[i];
                    }

                }
            }
            System.out.println(minLen);
        }


    }
}
