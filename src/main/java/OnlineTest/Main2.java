package OnlineTest;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Meal{
    int calory;
    int delicious;
    Meal(int a,int b){
        calory = a;
        delicious = b;
    }
}


public class Main2 {



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int lunchType = in.nextInt();
        int dinnerType = in.nextInt();
        int expectDeli = in.nextInt();
        int calory,delicious;
        List<Meal> lunchList = new ArrayList<>();
        List<Meal> dinnerList = new ArrayList<>();
        for(int i=0;i<lunchType;i++){
            calory = in.nextInt();
            delicious = in.nextInt();
            lunchList.add(new Meal(calory,delicious));
        }
        for(int i =0;i<dinnerType;i++){
            calory = in.nextInt();
            delicious = in.nextInt();
            dinnerList.add(new Meal(calory,delicious));
        }


        if(expectDeli == 0){
            System.out.println(0);
            return;
        }

        ArrayList<Meal> total = new ArrayList<>(lunchList);
        total.addAll(dinnerList);

        //一顿饭
        int min = Integer.MAX_VALUE;
        for(int i=0;i<total.size();i++){
            if(total.get(i).delicious>=expectDeli&&total.get(i).calory<min){
                min = total.get(i).calory;
            }
        }
        if(min != Integer.MAX_VALUE){
            System.out.println(min);
            return;
        }

        for(int i=0;i<lunchList.size();i++){
            for (int j=0;j<dinnerList.size();j++){
                int deli = lunchList.get(i).delicious+dinnerList.get(j).delicious;
                int calo = lunchList.get(i).calory+dinnerList.get(j).calory;
                if(deli>=expectDeli&&calo<min){
                    min = calo;
                }
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }

    }
}
