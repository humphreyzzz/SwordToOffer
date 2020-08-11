package OnlineTest;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/29 10:14
 * @Version 1.0
 **/
import java.util.*;

public class Sort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[] =  new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            Map<Integer,Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < a.length; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0)+1);
            }

            Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                if(iterator.next().getValue()>m) iterator.remove();
            }
            int temp = 0;
            for(int x:map.keySet()){
                for(int i = 0; i<map.get(x);i++){
                    if(temp==map.size()&&i==map.get(x)-1) System.out.print(x);
                    else System.out.print(x+" ");
                    temp++;
                }
            }
        }

    }

    static void fastSort(int[] nums,int start,int end,int type){
        if(start<end){
            int index = partition(nums,start,end,type);
            fastSort(nums,start,index-1,type);
            fastSort(nums,index+1,end,type);
        }
    }

    static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static int partition(int[] nums,int start,int end,int type){
        int flag = nums[end];
        int index = start - 1;
        for(int i=start;i<end;i++){
            if(type==0){
                if(nums[i]<flag){
                    index++;
                    swap(nums,i,index);
                }
            }
            else{
                if(nums[i]>flag){
                    index++;
                    swap(nums,i,index);
                }
            }
        }
        swap(nums,index+1,end);
        return index+1;
    }
}
