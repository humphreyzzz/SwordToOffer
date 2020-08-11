package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/5 14:57
 * @Version 1.0
 **/
public class MaxValue {
    public int maxValue(int[][] grid) {

        int lines = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[lines][columns];
        dp[0][0] = grid[0][0];
        for(int i=1;i<columns;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<lines;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i = 1;i<lines;i++){
            for(int j =1;j<columns;j++){
                dp[i][j] = Math.max(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[lines-1][columns-1];
    }

    public static void main(String[] args){
        System.out.println(new MaxValue().maxValue(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

}
