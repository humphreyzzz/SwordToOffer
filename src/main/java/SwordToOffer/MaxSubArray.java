package SwordToOffer;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int b[] = new int[nums.length];
        b[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            if(b[i-1]<0) b[i] = nums[i];
            else b[i] = b[i-1]+nums[i];
        }
        int max = b[0];
        for(int i =0;i<nums.length;i++){
            if(max<=b[i]) max = b[i];
        }
        return max;
    }
    public static void main(String[] args){
        MaxSubArray maxSubArray =new MaxSubArray();
        maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
