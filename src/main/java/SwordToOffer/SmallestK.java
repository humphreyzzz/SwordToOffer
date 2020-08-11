package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/28 10:47
 * @Version 1.0
 **/
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        int[] maxHeap = new int[k];
        if(k==0) return maxHeap;
        if(k==1) {
            int min = arr[0];
            for(int i=1;i<arr.length;i++){
                if(arr[i]<min){
                    min = arr[i];
                }
            }
            maxHeap[0] =min;
            return maxHeap;
        }
        //k>1
        for(int i=0;i<k;i++){
            maxHeap[i]=arr[i];
        }
        int start = k/2-1;
        for(int i=start;i>=0;i--){
            maxHeapify(maxHeap,i);
        }

        for(int i=k;i<arr.length;i++){
            if(arr[i]<maxHeap[0]){
                maxHeap[0] = arr[i];
                maxHeapify(maxHeap,0);
            }
        }
        return maxHeap;
    }

    private void maxHeapify(int[] arr,int i){
        int left = i*2+1;
        int right = i*2+2;
        int largest = i;
        if(left<arr.length&&arr[left]>arr[largest]){
            largest = left;
        }
        if(right<arr.length&&arr[right]>arr[largest]){
            largest = right;
        }
        if(i!=largest){
            swap(arr,i,largest);
            maxHeapify(arr,largest);
        }


    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }

    public static void main(String[] args){
        System.out.println(new SmallestK().smallestK(new int[]{1,3,4,2,0},2));
    }
}
