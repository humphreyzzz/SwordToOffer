package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/26 21:17
 * @Version 1.0
 **/

/**
 * 问题描述：给定一个未排序的数组，找出其中没有出现的最小正整数（num>=1）
 *
 * 示例1:
 * >输入：[1,2,0]
 * >输出：3
 *
 * 示例2:
 * >输入：[3,4,-1,1]
 * >输出:2
 *
 * 示例3:
 * >输入：[7,8,9,10]
 * >输出:1
 */
public class FindPositiveNumber {
    public int findPositiveNumber(int[] nums){
        int[] temp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0&&nums[i]<=nums.length){
                temp[nums[i]-1] = nums[i];
            }
        }
        for (int i=0;i<temp.length;i++){
            if(temp[i]==0) return i+1;
        }
        return nums.length+1;
    }

    public int findPositiveNumberO1(int[] nums){
        for(int i=0;i<nums.length;i++){
            while (nums[i]>0&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]){
                swap(nums[i]-1,i,nums);
            }
        }
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }

    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        System.out.println(new FindPositiveNumber().findPositiveNumberO1(new int[]{1,2,0}));
        System.out.println(new FindPositiveNumber().findPositiveNumberO1(new int[]{3,4,-1,1}));
        System.out.println(new FindPositiveNumber().findPositiveNumberO1(new int[]{7,8,9,10}));
        System.out.println(new FindPositiveNumber().findPositiveNumberO1(new int[]{1,2,3,4}));
    }
}
