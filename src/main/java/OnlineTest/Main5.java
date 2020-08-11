package OnlineTest;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        long[] nums = new long[len];
        for(int i=0;i<nums.length;i++){
            nums[i] = in.nextInt();
        }
        long res = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]<=1) continue;
            else{
                res+=nums[i]/2;
            }
        }
        System.out.println(res);
    }
}
