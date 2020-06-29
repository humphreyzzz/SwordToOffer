package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:hh
 * Date:2020/6/28
 * Time:19:30
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            if(map.get(target-nums[i])!=null){
                return new int[] {nums[i],target-nums[i]};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
