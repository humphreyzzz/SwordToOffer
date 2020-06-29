package SwordToOffer;

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

    public static void main(String[] args){
        int num[] = new int[]{5,4,3,2,1,2,45,6,23,23423,1};
        fastSort(num,0,10);
        for(int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }
}
