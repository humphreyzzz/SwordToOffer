package OnlineTest;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/1 19:34
 * @Version 1.0
 **/

class Transaction implements Comparable<Transaction> {
    String name;
    int time;
    int money;
    String city;
    Transaction(String name,int time,int money,String city){
        this.name = name;
        this.time = time;
        this.money = money;
        this.city = city;
    }
    @Override
    public String toString(){
        return name+","+time+","+money+","+city;
    }

    @Override
    public int compareTo(@NotNull Transaction o) {
        return o.time-this.time;
    }
}
public class Main1{

    public String[] invalidTransaction(String[] vTransaction){
        List<Transaction> transactions = new ArrayList<>();
        for (String string:vTransaction){
            String name = string.split(",")[0];
            int time = Integer.parseInt(string.split(",")[1]);
            int money = Integer.parseInt(string.split(",")[2]);
            String city = string.split(",")[3];
            if(money<1000){
                transactions.add(new Transaction(name,time,money,city));
            }
        }

        Collections.sort(transactions);
        List<Transaction> res = new ArrayList<>();
        for(int i=0;i<transactions.size();i++){
            int l = i-1,r = i+1;
            boolean lc = false,rc = false;
            while (l>0&&Math.abs(transactions.get(l).time-transactions.get(i).time)<=60){
                if(transactions.get(l).city.equals(transactions.get(r).city)){
                    lc = true;
                }
            }
        }
        return null;

    }
}
