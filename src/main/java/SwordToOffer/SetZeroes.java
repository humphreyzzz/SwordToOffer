package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/31 21:39
 * @Version 1.0
 **/

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2:
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0) return;
        boolean col = false;
        boolean row = false;

        if(matrix[0][0]==0){
            col=true;
            row=true;
        }

        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(i==0&&j==0) continue;
                else{
                    if(matrix[i][j]==0){
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                        if(i==0) row=true;
                        if(j==0) col=true;
                    }
                }
            }
        }

        //横向
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j] =0;
                }
            }
        }

        //纵向
        for(int j = 1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }

        //处理第一行
        if(row){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        //处理第一列
        if(col){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] =0;
            }
        }
    }

    public static void main(String[] args){
        new SetZeroes().setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }
}
