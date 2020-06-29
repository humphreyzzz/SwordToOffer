package SwordToOffer;

import java.util.Arrays;

/**
 * Created with IDEA
 * author:hh
 * Date:2020/6/28
 * Time:15:41
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        fastSort(nums,0,nums.length-1);
        StringBuilder res = new StringBuilder();
        String strs[] = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        for (String s : strs)
            res.append(s);
        return res.toString();
    }


    public static void fastSort(int num[],int start,int end){
        if(start<end){
            int index = partition(num,start,end);
            fastSort(num,start,index-1);
            fastSort(num,index+1,end);
        }
    }





    public static int partition(int num[],int start,int end){
        int flag = num[end];
        int i =start-1;
        for(int j=start;j<end;j++){
            if((String.valueOf(num[j])+String.valueOf(flag)).compareTo(String.valueOf(flag)+String.valueOf(num[j]))<0){
                i++;
                swap(num,i,j);
            }
        }
        swap(num,i+1,end);
        return i+1;
    }


    public static void swap(int num[],int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

}
