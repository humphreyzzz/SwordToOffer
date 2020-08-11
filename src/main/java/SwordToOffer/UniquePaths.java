package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/21 19:33
 * @Version 1.0
 **/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[n][m];
        for(int i=0;i<m;i++){
            res[0][i] = 1;
        }
        for(int i=1;i<n;i++){
            res[i][0] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                res[i][j] = res[i-1][j]+res[i][j-1];
            }
        }
        return res[n-1][m-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0) return 0;
        int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean isObsExist = false;

        for(int i=0;i<obstacleGrid[0].length;i++){
            if(obstacleGrid[0][i]==1) isObsExist=true;
            if(!isObsExist){
                res[0][i] = 1;
            }else{
                res[0][i] = 0;
            }
        }
        isObsExist =obstacleGrid[0][0]==1;

        for(int i=1;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0]==1) isObsExist=true;
            if(!isObsExist){
                res[i][0] = 1;
            }else{
                res[i][0] = 0;
            }
        }


        for(int i=1;i<obstacleGrid.length;i++){
            for (int j=1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1) res[i][j]=0;
                else{
                    res[i][j] = res[i-1][j]+res[i][j-1];
                }
            }
        }
        return res[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args){
        System.out.println(new UniquePaths().uniquePathsWithObstacles(new int[][]{{1},{0}}));
    }

}
