package SwordToOffer;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
    List<Integer> list = new ArrayList<>();
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    private int getIndex(int num){
        for(int i = 0;i<list.size();i++){
            if(list.get(i)>num) return i;
        }
        return -1;
    }

    public void addNum(int num) {
        if(list.size()==0) list.add(num);
        else {
            int index = getIndex(num);
            if(index==-1) list.add(num);//num本身为最大的数
            //从index开始往后移一位，把num放在index位置上
            else{
                list.add(-1);
                for(int i=list.size()-1;i>index;i--){
                    list.set(i,list.get(i-1));
                }
                list.set(index,num);
            }
        }
    }

    public double findMedian() {
        if(list.size()%2==1) return list.get(list.size()/2);
        return ((double)list.get(list.size()/2)+(double)list.get((list.size()/2)-1))/2;
    }

    public static void main(String args[]){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(0);
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.list.toArray();

    }
}
