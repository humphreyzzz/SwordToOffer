package SwordToOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 请找出数组中任意一个重复的数字。

 示例 1：
 输入：
 [2, 3, 1, 0, 2, 5, 3]
 输出：2 或 3
  
 限制：
 2 <= n <= 100000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set numbers = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(numbers.contains(nums[i])){
                return nums[i];
            }
            numbers.add(nums[i]);
        }
        return 0;
    }

    public int findRepeatNumberII(int[] nums) {
        int index = 0;
        while (index<nums.length){
            if(nums[index]==index) {
                index++;
            }
            else{
                if(nums[index]==nums[nums[index]]) return nums[index];
                else{
                    int temp = nums[index];
                    nums[index] = nums[nums[index]];
                    nums[temp] = temp;
                }
            }
        }
        return 0;
    }


}
