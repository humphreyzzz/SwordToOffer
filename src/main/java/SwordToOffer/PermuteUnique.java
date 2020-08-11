package SwordToOffer;

import java.util.*;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/30 16:14
 * @Version 1.0
 **/
public class PermuteUnique {

    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] used = new boolean[nums.length];
        dfs(new ArrayList<>(),nums,used);
        return res;
    }



    void dfs(List<Integer> curList,int[] nums,boolean[] used){
        Set<Integer> set = new HashSet<>();
        if(curList.size()==nums.length){
            res.add(new ArrayList<>(curList));
            return;
        }else{
            for(int i=0;i<nums.length;i++){
                if(!used[i]){
                    if(!set.contains(nums[i])){
                        set.add(nums[i]);
                        used[i] = true;
                        curList.add(nums[i]);
                        dfs(curList,nums,used);
                        curList.remove(curList.size()-1);
                        used[i] = false;
                    }

                }
            }

        }
    }




}
