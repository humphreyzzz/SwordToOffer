package SwordToOffer;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IDEA
 * author:hh
 * Date:2020/6/28
 * Time:15:10
 */
public class Sort {

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
            if(num[j]<flag){
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






    public static void mergeSort(int num[],int start,int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(num,start,mid);
            mergeSort(num,mid+1,end);
            merge(num,start,mid,end);
            for(int i=0;i<num.length;i++){
                System.out.print(num[i]+" ");
            }
            System.out.println();
        }
    }

    public static void merge(int[] num,int start,int mid,int end){
        int[] temp = new int[end-start+1];
        int i=start,j=mid+1;
        int index = 0;
        while (i<mid+1&&j<end+1){
            if(num[i]<num[j]){
                temp[index] = num[i];
                i++;
            }else{
                temp[index] = num[j];
                j++;
            }
            index++;
        }
        while(i<mid+1){
            temp[index++] = num[i++];
        }
        while(j<end+1){
            temp[index++] = num[j++];
        }
        for(int k=0;k<temp.length;k++){
            num[k+start] = temp[k];
        }
    }


    public static void heapSort(int[] nums,int bound){
        for(int i=bound/2;i>=0;i--){
            maxHeapify(nums,i,bound);
        }
        while (bound>0){
            swap(nums,0,bound);
            bound--;
            maxHeapify(nums,0,bound);
        }

    }


    public static void maxHeapify(int[] nums,int index,int bound){
        int left = index*2+1;
        int right = index*2+2;

        int largest = index;
        if(left<=bound&&nums[left]>nums[largest]){
            largest = left;
        }
        if(right<=bound&&nums[right]>nums[largest]){
            largest = right;
        }

        if(index!=largest){
            swap(nums,largest,index);
            maxHeapify(nums,largest,bound);
        }
    }


    public static void quickSort(int[] nums,int start, int end){
        if(start<end){
            int index = quickSortPartition(nums,start,end);
            quickSort(nums,start,index-1);
            quickSort(nums,index+1,end);
        }
    }

    public static int quickSortPartition(int[] nums,int start,int end){
        int i = start-1;
        int flag = nums[end];
        for(int j=start;j<end;j++){
            if(nums[j]<flag){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,end);
        return i+1;
    }

    public static void mergingSort(int[] nums,int start,int end){
        if(start<end){
            int mid = (start+end)/2;
            mergingSort(nums,start,mid);
            mergingSort(nums,mid+1,end);
            merging(nums,start,mid,end);
        }
    }

    public static void merging(int nums[],int start,int mid,int end){
        int len = end -start+1;
        int[] temp = new int[len];
        int i = start,j= mid+1;
        int index = 0;
        while (i<mid+1&&j<end+1){
            if(nums[i]<nums[j]){
                temp[index++] = nums[i++];
            }else {
                temp[index++] = nums[j++];
            }
        }
        while (i<mid+1){
            temp[index++] = nums[i++];
        }
        while (j<end+1){
            temp[index++] = nums[j++];
        }
        for(int k=0;k<len;k++){
            nums[k+start] = temp[k];
        }
    }

    public static void main(String[] args){
        int num[] = new int[]{5,4,3,2,1,2,45,6,23,23423,1};
        heapSort(num,num.length-1);
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }
}
