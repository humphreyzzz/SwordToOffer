package OnlineTest;

import java.util.HashSet;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] nums = new int[m];
        int[]  res = new int[n];

        HashSet<Integer> index = new HashSet<>();
        for(int i=0;i<m;i++){
            nums[i] = in.nextInt();
            index.add(nums[i]);
        }

        int j=0;
        int count = 1;
        for(int i=0;i<n;i++){
            while (index.contains(count)){
                count++;
            }
            if(i<n&&j<m&&count>nums[j]){
                res[i] = nums[j];
                j++;
            }
            else if((i<n&&j<m&&count<=nums[j])||(i<n&&j>=m)){
                res[i] = count++;
            }
        }
        for(int i=0;i<n;i++){
            if(i==n-1){
                System.out.println(res[i]);
            }else {
                System.out.print(res[i]+" ");
            }
        }


    }
}
