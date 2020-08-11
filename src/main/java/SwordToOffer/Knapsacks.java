package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/4 16:25
 * @Version 1.0
 **/
public class Knapsacks {
    public int knapsacks(int capacity,int[] weights,int[] values){
        int[][] dp = new int[weights.length+1][capacity+1];
        for(int i=0;i<capacity+1;i++){
            dp[0][i]=0;
        }
        for (int i=1;i<weights.length+1;i++){
            dp[0][i]=0;
        }
        for (int i=1;i<weights.length+1;i++){
            for (int j=1;j<capacity+1;j++){
                if(j>=weights[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j-weights[i-1]]+values[i-1],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[weights.length][capacity]);
        return dp[weights.length][capacity];
    }

    public static void main(String[] args){
        new Knapsacks().knapsacks(5,new int[]{1,2,3},new int[]{6,9,13});
    }
}
