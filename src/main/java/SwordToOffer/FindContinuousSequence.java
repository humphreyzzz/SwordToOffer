package SwordToOffer;

import java.util.ArrayList;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/6/29 17:23
 * @Version 1.0
 **/

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * 限制：
 * 1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int leftBound=1,rightBound;
        ArrayList<int[]> res = new ArrayList<>();
        while(leftBound<=target){
            int count =0;
            rightBound=leftBound;
            while(count<target){
                count+=rightBound;
                rightBound++;
            }
            if(count==target&&leftBound+1!=rightBound){
                int[] result = new int[rightBound-leftBound];
                for(int i=leftBound;i<rightBound;i++){
                    result[i-leftBound] = i;
                }
                res.add(result);
            }
            leftBound++;
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args){
        new FindContinuousSequence().findContinuousSequence(9);
    }
}
