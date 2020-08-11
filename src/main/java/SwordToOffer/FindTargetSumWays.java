package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/4 15:44
 * @Version 1.0
 **/
public class FindTargetSumWays {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int sum) {
        dfs(nums,0,0,sum,true);
        dfs(nums,0,0,sum,false);
        return count;
    }

    private void dfs(int[] nums,int index,int curValue,int target,boolean isPositive){

        if(isPositive){
            target = target + nums[index];
        }else{
            target = target - nums[index];
        }
        index++;
        if(index==nums.length){
            if(curValue==target){
                count++;
            }
            return;
        }
        dfs(nums,index,curValue,target,true);
        dfs(nums,index,curValue,target,false);
    }
}
