package SwordToOffer;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            if(res[i-1]+nums[i]>nums[i]) res[i]=res[i-1]+nums[i];
            else res[i] = nums[i];
        }
        int max = res[0];
        for(int i=1;i<nums.length;i++){
            if (max<res[i]) max=res[i];
        }
        return max;
    }
    public static void main(String[] args){
        MaxSubArray maxSubArray =new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
