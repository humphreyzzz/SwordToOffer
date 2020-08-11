package OnlineTest;

import java.util.*;

public class Algo {
    public static int getBiggestIndex(long a[]){
        int result = 0;
        for(int i=1;i<a.length;i++){
            if(a[result]<=a[i]){
                result=i;
            }
        }
        return result;
    }

    public static long solution2(int n,long a[]){
        long result[] = new long[n];
        long y =0;
        for(int i=0;i<a.length;i++){
            result[i] = a[i]%(n+1);
            y=y+a[i];
        }
        long x=0;
        for(int i=0;i<result.length;i++){
            x=x+result[i];
        }

        return y-x;
    }

    public static long solution(int n,long a[]){
        long count = 0;
        int biggestIndex = getBiggestIndex(a);
        while(a[biggestIndex]>=n){
            count++;
            for(int i=0;i<biggestIndex;i++){
                a[i]=a[i]+1;
            }
            for(int i=biggestIndex+1;i<a.length;i++){
                a[i]=a[i]+1;
            }
            a[biggestIndex]=a[biggestIndex]-n;
            biggestIndex=getBiggestIndex(a);
            for(int i=0;i<a.length;i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
        return count;
    }



    public static long spaceCloister(int n,long m,int a[]){
        long total = 0;
        for(int i=0;i<a.length;i++){
            total = total+a[i];
        }
        long x = 0l;
        long result =0;
        if(total<=m){
            x = m%total;
            result = m/total;
        }
        else {
            x=m;
        }
        result = result*n;
        long pointer = -1;
        while(pointer!=result){
            pointer = result;
            for(int i=0;i<a.length;i++){
                if(x-a[i]>=0){
                    x = x- a[i];
                    result = result+1;
                }
            }
        }
        return result;
    }
    public static String adding(String a,String b){
        int maxIndex,minIndex =0;
        String temp;
        if(a.length()<b.length()){
            temp = a;
            a = b;
            b = temp;
        }
        maxIndex=a.length();
        minIndex=b.length();
        int x = maxIndex-minIndex;
        int jinwei = 0;
        int ans =0;
        List<Integer> result = new ArrayList<Integer>();
        for(int i=maxIndex-1;i>=0;i--){
            int z = i-x ;
            if(z>=0){
                int res = Integer.parseInt(String.valueOf(a.charAt(i)))+Integer.parseInt(String.valueOf(b.charAt(i-x)));
                ans = res%9+jinwei;
                jinwei = res/9;
                result.add(ans);
            }
            else{
                result.add(Integer.parseInt(String.valueOf(a.charAt(i)))+jinwei);
                jinwei = 0;
            }
        }
        if(jinwei ==1){
            result.add(jinwei);
        }
        String re = "";
        for(int i = result.size()-1;i>=0;i--){
            re+=String.valueOf(result.get(i));
        }
        return re;
    }

    public static String add(String a, String b){
        String aIntPart,aPointPart,bIntPart,bPointPart;
        String totalInt;
        String totalPoint;

        if(a.split("\\.").length==2){
            aIntPart = a.split("\\.")[0];
            aPointPart = a.split("\\.")[1];

        }
        else {
            aIntPart = a;
            aPointPart = "";
        }
        if(b.split("\\.").length==2){
            bIntPart = b.split("\\.")[0];
            bPointPart = b.split("\\.")[1];
        }
        else{
            bIntPart = b;
            bPointPart = "";
        }
        totalInt = adding(aIntPart,bIntPart);
        totalPoint = adding(aPointPart,bPointPart);
        if(totalPoint.length()>aPointPart.length()&&totalPoint.length()>bPointPart.length()){
            totalPoint = totalPoint.substring(1);
            totalInt = adding(totalInt,String.valueOf(1));
        }
        if(totalPoint.equals("")){
            return totalInt;
        }
        return totalInt+"."+totalPoint;
    }

    public static void sort(int[] num,int N){
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(num[i]>num[j]){
                    int temp = num[i];
                    num[i]=num[j];
                    num[j]=temp;
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.println(num[i]);
        }
    }


    public static void main(String args[]){
        int[] num = {3,1,2,-1,100,65,78};
        sort(num,6);
    }
}
