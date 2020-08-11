package SwordToOffer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

 示例 1：
 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[1,2,3,6,9,8,7,4,5]

 示例 2：
 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
  
 限制：
 0 <= matrix.length <= 100
 0 <= matrix[i].length <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int left = 0,right = matrix[0].length-1,top = 0,bottom = matrix.length-1;
        int len = (right+1)*(bottom+1);
        int[] res = new int[len];
        int index = 0;
        while (true){
            for(int i=left;i<=right;i++){
                res[index++] = matrix[top][i];
            }
            if(index==len) break;
            top++;
            for(int i=top;i<=bottom;i++){
                res[index++] = matrix[i][right];
            }
            if(index==len) break;
            right--;
            for(int i=right;i>=left;i--){
                res[index++] = matrix[bottom][i];
            }
            if(index==len) break;
            bottom--;
            for(int i =bottom;i>=top;i--){
                res[index++] = matrix[i][left];
            }
            if(index==len) break;
            left++;
        }
        return res;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new SpiralOrder().spiralOrder(mat);
    }
}
