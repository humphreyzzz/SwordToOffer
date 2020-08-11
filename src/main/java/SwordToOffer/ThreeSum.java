package SwordToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/23 15:03
 * @Version 1.0
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res =  new ArrayList<>();
        if(nums.length<3) return res;
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            int  j = i + 1 , k = nums.length - 1;
            if(i>0&&nums[i]==nums[i-1]) continue;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[k], nums[j])));
                    while (j<k&&nums[j]==nums[++j]);
                    while (j<k&&nums[k]==nums[--k]);
                }
                else {
                    if(sum<0){
                        while (j<k&&nums[j]==nums[++j]) ;
                    }

                    else {
                        while (j<k&&nums[k]==nums[--k]);
                    }

                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new ThreeSum().threeSum(new int[]{-2,0,0,2,2}));
    }
}
