package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/2 19:30
 * @Version 1.0
 **/

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int left =0,right = nums.length-1;
        while (left<=right){
            int m = (left + right) / 2;
            if(nums[m] == m) left = m + 1;
            else right = m - 1;
        }
        return left;
    }

    public int findDuplicate(int[] nums) {
        int left = 1,right = nums.length-1;
        int cnt = 0;
        while (left<right){
            int mid = (left+right)/2;
            for(int num:nums){
                if(num<=mid){
                    cnt++;
                }
            }
            if(cnt>mid){
                right = mid;
            }else{
                left=mid+1;
            }
            cnt=0;
        }
        return left;
    }

    public static int binarySearch(int[] nums,int target){
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                return mid;
            }

        }
        return -1;
    }

    /**
     * 旋转数组中的二分法，通过判断target的值是否比递增区间的首位大，末尾小来判断target是否落在递增区间，
     * 若不在，则target在另一个半区
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchInRotatedArray(int[] nums,int target){
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(target==nums[mid]) return mid;
            //左半区有序，判断target是否在左半区
            if(nums[left]<=nums[mid]){

                //target在左半区，区间缩小至[left,mid-1]
                if(target>=nums[left]&&target<nums[mid]){
                    right = mid-1;
                }
                //target在右半区，区间缩小至[mid+1,right]
                else{
                    left = mid+1;
                }
                //右半区有序，判断target是否在右半区
            }else{
                //target在右半区，区间缩小至[mid+1,right]
                if(target>nums[mid]&&target<=nums[right]){
                    left = mid+1;
                //target在左半区，区间缩小至[left,mid-1]
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(binarySearchInRotatedArray(new int[]{8,9,10,1,2,3,4,5,6},5));
    }
}
