package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/6/30 15:07
 * @Version 1.0
 **/

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePairs {
    private int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return count;
    }

    public void mergeSort(int[] nums,int start,int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,end,mid);
        }
    }

    public void merge(int[] nums,int start,int end,int mid){
        int[] temp = new int[end-start+1];
        int left = start,right = mid+1,index = 0;
        while (left<=mid&&right<=end){
            if(nums[left]<=nums[right]){
                temp[index++] = nums[left++];
            }
            else{
                temp[index++] = nums[right++];
                count += mid-left+1;
            }
        }
        while (left<=mid){
            temp[index++] = nums[left++];
        }
        while (right<=end){
            temp[index++] = nums[right++];
        }
        for(int i = 0;i< temp.length;i++){
            nums[i+start] = temp[i];
        }
    }

    public static void main(String[] args){
        System.out.println(new ReversePairs().reversePairs(new int[]{8,7,6,5,4,3,2,1}));
    }
}
