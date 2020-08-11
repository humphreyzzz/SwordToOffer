package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/20 21:03
 * @Version 1.0
 **/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],1);
            else{
                map.replace(nums[i],map.get(nums[i])+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1) return entry.getKey();
        }
        return -1;
    }
}
