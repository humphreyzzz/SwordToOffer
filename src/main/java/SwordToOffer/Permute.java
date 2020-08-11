package SwordToOffer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/30 15:16
 * @Version 1.0
 **/
public class Permute {
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(new ArrayList<>(),nums,used);
        return res;
    }

    void dfs(List<Integer> curList,int[] nums,boolean[] used){
        if(curList.size()==nums.length){
            res.add(new ArrayList<>(curList));
            return;
        }else{
            for(int i=0;i<nums.length;i++){
                if(!used[i]){
                    used[i] = true;
                    curList.add(nums[i]);
                    dfs(curList,nums,used);
                    curList.remove(curList.size()-1);
                    used[i] = false;
                    }
                }
            }
    }

    public static void main(String[] args){
        System.out.println(new Permute().permute(new int[]{1,2,2}));
    }
}
