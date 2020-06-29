package SwordToOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 [["a","b","c","e"],
 ["s","f","c","s"],
 ["a","d","e","e"]]
 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

 示例 1：
 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 输出：true

 示例 2：
 输入：board = [["a","b"],["c","d"]], word = "abcd"
 输出：false

 提示：
 1 <= board.length <= 200
 1 <= board[i].length <= 200

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathExistence {
//    Map<String,List<String>> result = new HashMap<>();
//    public boolean exist(char[][] board, String word) {
//        if(board.length<1){
//            return false;
//        }
//        result.put(word.substring(0,1),new ArrayList<>());
//        for(int i=0;i<board.length;i++){
//            for(int j = 0; j<board[i].length;j++){
//                if(board[i][j]==word.charAt(0)){
//                    result.get(word.substring(0,1)).add(i+","+j);
//                }
//            }
//        }
//        if(result.get(word.substring(0,1)).size()==0){
//            return false;
//        }
//        int index = 1;
//        while(index<word.length()){
//            index++;
//            result.put(word.substring(0,index),new ArrayList<>());
//            for(String ans:result.get(word.substring(0,index-1))){
//                int lastIndex = ans.lastIndexOf(' ');
//                String coor = ans.substring(lastIndex+1);
//                int x = Integer.parseInt(coor.split(",")[0]);
//                int y = Integer.parseInt(coor.split(",")[1]);
//                //左
//                if(jugdgeExsitence(x-1,y,board)){
//                    if(board[x-1][y]==word.substring(0,index).charAt(index-1)){
//                        if(!ans.contains((x-1)+","+y)){
//                            result.get(word.substring(0,index)).add(ans+" "+(x-1)+","+y);
//                        }
//
//                    }
//                }
//                //右
//                if(jugdgeExsitence(x+1,y,board)){
//                    if(board[x+1][y]==word.substring(0,index).charAt(index-1)){
//                        if(!ans.contains((x+1)+","+y)){
//                            result.get(word.substring(0,index)).add(ans+" "+(x+1)+","+y);
//                        }
//                    }
//                }
//                //上
//                if(jugdgeExsitence(x,y-1,board)){
//                    if(board[x][y-1]==word.substring(0,index).charAt(index-1)){
//                        if(!ans.contains(x+","+(y-1))){
//                            result.get(word.substring(0,index)).add(ans+" "+x+","+(y-1));
//                        }
//                    }
//                }
//                //下
//                if(jugdgeExsitence(x,y+1,board)){
//                    if(board[x][y+1]==word.substring(0,index).charAt(index-1)){
//                        if(!ans.contains(x+","+(y+1))){
//                            result.get(word.substring(0,index)).add(ans+" "+x+","+(y+1));
//                        }
//                    }
//                }
//
//            }
//            if(result.get(word.substring(0,index)).size()==0){
//                return false;
//            }
//        }
//        System.out.println(result);
//        return true;
//    }


    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,char[] words,int x, int y,int length){

        if(x<0||x>=board.length||y<0||y>=board[0].length||words[length]!=board[x][y]){
            return false;
        }
        length++;
        if(length==words.length){
            return true;
        }
        char temp = board[x][y];
        board[x][y]  = '/';
        boolean res = dfs(board,words,x+1,y,length) || dfs(board,words,x-1,y,length)
                || dfs(board,words,x,y+1,length) || dfs(board,words,x,y-1,length);
        board[x][y] = temp;
        return res;
    }

    public static void main(String args[]){
        char[] line1 = {'a','c','c','c'};
        char[] line2 = {'b','b','a','a'};
        char[] line3 = {'c','b','c','a'};

        char[][] matrix = {line1,line2,line3};
        PathExistence pathExistence = new PathExistence();
        boolean isTrue = pathExistence.exist(matrix,"cbb");
        System.out.println(isTrue);
    }

}
