package SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 示例 1：
 输入：m = 2, n = 3, k = 1
 输出：3

 示例 2：
 输入：m = 3, n = 1, k = 0
 输出：1

 提示：
 1 <= n,m <= 100
 0 <= k <= 20

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingCount {
//    class Coor{
//        int x;
//        int y;
//        private Coor(int x,int y){
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (obj instanceof Coor) {
//                Coor coor= (Coor) obj;
//                if(x == coor.x&&y==coor.y){
//                    return true;
//                }
//                return false;
//            }
//            return false;
//
//        }
//    }
//    public int movingCount(int m, int n, int k) {
//        List<Coor> reachable = new ArrayList<>();
//        reachable.add(new Coor(0,0));
//        int[][] plus = {{1,0},{-1,0},{0,1},{0,-1}};
//        int total = 0;
//        while (total!=reachable.size()){
//            total = reachable.size();
//            List<Coor> temp = new ArrayList<>(reachable);
//            for (Coor coor:reachable){
//                for(int[] adding:plus){
//                    int newX = coor.x+adding[0];
//                    int newY = coor.y+adding[1];
//                    if(newX<0||newX>=m||newY<0||newY>=n||getNumCount(newX)+getNumCount(newY)>k){
//                    }
//                    else{
//                        if(!temp.contains(new Coor(newX,newY))){
//                            temp.add(new Coor(newX,newY));
//                        }
//                    }
//                }
//            }
//            reachable = temp;
//
//        }
//        return reachable.size();
//    }
//


    private int getNumCount(int num){
        int hundreds = num/100;
        int tens = (num-100*hundreds)/10;
        int ones = (num-100*hundreds-10*tens);
        return hundreds+tens+ones;
    }

//    public int movingCount(int m, int n, int k) {
//        int count[][] = new int[m][n];
//        int total = 0;
//        dfs(count,k,0,0);
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                total = total + count[i][j];
//            }
//        }
//        return total;
//    }
//
//    private void dfs(int[][] count,int k,int x,int y){
//        if(x<0||x>=count.length||y<0||y>=count[0].length||getNumCount(x)+getNumCount(y)>k||count[x][y]==1){
//            return;
//        }
//        else{
//            count[x][y]=1;
//            dfs(count,k,x+1,y);
//            dfs(count, k, x-1, y);
//            dfs(count, k, x, y+1);
//            dfs(count, k, x, y-1);
//        }
//    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        int[][] plus = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{0,0});
        while (queue.size()>0){
            int[] element = queue.poll();
            for(int[] adding:plus){
                int x = element[0]+adding[0];
                int y = element[1]+adding[1];
                if(x<0||x>m-1||y<0||y>n-1||visited[x][y]||getNumCount(x)+getNumCount(y)>k){
                    continue;
                }
                queue.add(new int[]{x,y});
                res++;
                visited[x][y]=true;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        MovingCount movingCount = new MovingCount();
        System.out.println(movingCount.movingCount(5,4,0));//4146
    }
}
