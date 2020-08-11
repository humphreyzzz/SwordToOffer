package OnlineTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args){
//        Scanner cin = new Scanner(System.in);
//        int N,K;
//        while(cin.hasNext()){
//            N = cin.nextInt();
//            K = cin.nextInt();
//            int num[] = new int[N];
//            for(int i=0;i<N;i++){
//                num[i]=cin.nextInt();
//            }
//            for(int i=0;i<N;i++){
//                for(int j=i+1;j<N;j++){
//                    if(num[i]>num[j]){
//                        int temp = num[i];
//                        num[i]=num[j];
//                        num[j]=temp;
//                    }
//                }
//            }
//            int index = -1;
//            int times = 0;
//            int oringin_mid = (N+1)/2-1;
//            for(int i=0;i<N;i++){
//                if(num[i]==K){
//                    if(times==0){
//                        index=i;
//                    }
//                    times++;
//                }
//            }
//
//            if(index!=-1){
//                if(index<oringin_mid){
//                    System.out.println((N-index-times+1)*2-N);
//                }
//                else if(index<=oringin_mid&&index+times-1>=oringin_mid){
//                    System.out.println(0);
//                }else System.out.println(index*2-N+1);
//            }
//            else {
//                for(int i=0;i<N-1;i++){
//                    if(num[i]<K&&num[i+1]>K){
//                        index=i;
//                    }
//                }
//                if(index==-1) {
//                    System.out.println(N);
//                }
//                else{
//                    if(index<oringin_mid){
//                        System.out.println((N-index-1)*2-N);
//                    }
//                    else System.out.println((index+1)*2-N);
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n,m;
        while (cin.hasNext()){
            n=cin.nextInt();
            for(int i=0;i<n;i++){
                m = cin.nextInt();
                int a[] = new int[m];
                for(int j=0;j<m;j++){
                    a[j] = cin.nextInt();
                }

            }
        }
        ThreadLocal<Integer> integerThreadLocal;
    }


//public static void main(String[] args) {
//    Scanner cin = new Scanner(System.in);
//    int t,n,m,w2,w3;
//    while (cin.hasNext()){
//        t=cin.nextInt();
//        for(int i=0;i<t;i++){
//            n=cin.nextInt();
//            m=cin.nextInt();
//            w2=cin.nextInt();
//            w3=cin.nextInt();
//            int max3 = 0;
//            while(n*Math.pow(3,max3)<m){
//                max3++;
//            }
//            int totalCount = 0;
//            if(n>=m) System.out.println(totalCount);
//            else{
//
//                totalCount = max3*w3;
//                for(int j =0;j<max3;j++){
//                    int times2 = 0;
//                    while (n*Math.pow(3,j)*Math.pow(2,times2)<m){
//                        times2++;
//                    }
//                    int tempCount = w3*j+w2*times2;
//                    if(totalCount>tempCount) totalCount = tempCount;
//                }
//                System.out.println(totalCount);
//            }
//        }
//    }
//
//    }

//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int cookTime,singleRunTime,eatTime,fishNum;
//        while (cin.hasNext()){
//            cookTime=cin.nextInt();
//            singleRunTime=cin.nextInt();
//            eatTime=cin.nextInt();
//            fishNum=cin.nextInt();
//            int totalTime = 0;
//            int cookedFish = 0;
//            int eatedFish = 0;
//            boolean eatOneFish = false;
//            List<Integer> finishTime = new ArrayList<>();
//            while(eatedFish<fishNum){
//                while(!eatOneFish){
//                    int getFishNum;
//                    totalTime=totalTime+singleRunTime;
//                    cookedFish = totalTime/cookTime;
//                    getFishNum = cookedFish-eatedFish;
//                    if(getFishNum>0){
//                        totalTime = totalTime + singleRunTime;
//                        for(int i=0;i<getFishNum;i++){
//                            totalTime+=eatTime;
//                            finishTime.add(totalTime);
//                        }
//                        eatedFish = eatedFish+getFishNum;
//                        eatOneFish = true;
//                    }else{
//                        totalTime = totalTime+((cookedFish+1)*cookTime-totalTime);
//                        getFishNum = 1;
//                        totalTime = totalTime + singleRunTime + eatTime*getFishNum;
//                        eatedFish = eatedFish+getFishNum;
//                        finishTime.add(totalTime);
//                        eatOneFish = true;
//                    }
//                }
//                eatOneFish = false;
//            }
//            for(int i=0;i<fishNum;i++){
//                System.out.println(finishTime.get(i));
//            }
//
//        }
//
//    }
//    public static void main(String[] args){
//        Scanner cin = new Scanner(System.in);
//        int N,K;
//        while(cin.hasNext()){
//            N=cin.nextInt();
//            K=cin.nextInt();
//            int[] num = new int[N];
//            for(int i=0;i<N;i++){
//                num[i]=cin.nextInt();
//            }
//            //排序
//            for(int i=0;i<N;i++){
//                for(int j=i+1;j<N;j++){
//                    if(num[i]>num[j]){
//                        int temp = num[i];
//                        num[i]=num[j];
//                        num[j]=temp;
//                    }
//                }
//            }
//            int index1 = K/N;
//            int index2 = K%N;
//            System.out.println("("+num[index1]+","+num[index2-1]+")");
//        }
//    }


//    public static void main(String[] args){
//        Scanner cin = new Scanner(System.in);
//        int a,b,m,x;
//        while(cin.hasNext()){
//            a=cin.nextInt();
//            b=cin.nextInt();
//            m=cin.nextInt();
//            x=cin.nextInt();
//            List<Integer> resultList = new ArrayList<>();
//            while(!resultList.contains(x)){
//                resultList.add(x);
//                x=(a*x+b)%m;
//            }
//            System.out.println(resultList.size());
//        }
//    }

//    public static void main(String[] args){
//        Scanner cin = new Scanner(System.in);
//        int n,m;
//        while(cin.hasNext()){
//            n=cin.nextInt();
//            m=cin.nextInt();
//            List<List<Integer>> scores= new ArrayList<>();
//            for(int i=0;i<m;i++){
//                scores.add(new ArrayList<>());
//            }
//
//            for(int i=0;i<n;i++){
//                for(int j=0;j<m;j++){
//                    scores.get(j).add(cin.nextInt());
//                }
//            }
//            boolean isExe[] = new boolean[n];
//            for(int i=0;i<n;i++){
//                isExe[i]=false;
//            }
//
//            int result = 0;
//            for(int j=0;j<scores.size();j++){
//                int max =0;
//                int index = -1;
//                for(int i=0;i<scores.get(j).size();i++){
//                    if(Integer.parseInt(scores.get(j).get(i).toString())>=max){
//                        max=Integer.parseInt(scores.get(j).get(i).toString());
//                        index = i;
//                    }
//                }
//                isExe[index] = true;
//            }
//            for(int i=0;i<n;i++){
//                if(isExe[i]){
//                    result++;
//                }
//            }
//            System.out.println(result);
//        }
//    }

}
