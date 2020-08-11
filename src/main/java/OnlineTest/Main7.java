package OnlineTest;

import java.util.Scanner;

public class Main7 {
    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        //
        for(int i=0;i<nums.length+1;i++){
            dp[0][i]=true;
        }
        for(int i=1;i<nums.length+1;i++){
            for (int j=0;j<target+1;j++){
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]]||dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0;i<T;i++){
            int len = in.nextInt();
            int[] nums = new int[len];
            for(int j=0;j<nums.length;j++){
                nums[j] = in.nextInt();
            }
            if(canPartition(nums)){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }

        }
    }
}
