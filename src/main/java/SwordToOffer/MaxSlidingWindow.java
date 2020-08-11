package SwordToOffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/13 11:11
 * @Version 1.0
 **/
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        if(nums.length<k||k<1) return new int[]{};

        //将k个值放入deque
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.add(nums[i]);
        }
        int[] res = new int[nums.length-k+1];
        for(int i=0;i<nums.length-k;i++){
            res[i]=deque.peek();
            //出队
            if(nums[i]==deque.peek()){
                deque.removeFirst();
            }
            //入队
            while(!deque.isEmpty() && deque.peekLast() < nums[i+k]) deque.removeLast();
            deque.add(nums[i+k]);

        }
        res[res.length-1] = deque.peek();
        return res;
    }
    public static void main(String[] args){
        new MaxSlidingWindow().maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
    }
}
