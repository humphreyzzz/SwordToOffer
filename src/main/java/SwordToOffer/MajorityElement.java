package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    Map<Integer,Integer>  map = new HashMap<>();
    public int majorityElement(int[] nums) {
        if(nums.length==1) return nums[0];
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int res = map.get(nums[i]);
                res++;
                map.replace(nums[i],res);
                if(res>nums.length/2) return nums[i];
            }
            else map.put(nums[i],1);
        }
        return -1;
    }

    public static void main(String args[]){
        System.out.println(new MajorityElement().majorityElement(new int[]{1,2,3,2,2,2,5,4,2}));
    }

}
