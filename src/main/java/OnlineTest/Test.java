package OnlineTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/8/3 10:45
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        System.out.println("after add(1): "+linkedList);
        linkedList.add(2);
        System.out.println("after add(2): "+linkedList);
        linkedList.push(3);
        System.out.println("after push(3): "+linkedList);
        linkedList.push(4);
        System.out.println("after push(4): "+linkedList);
        AtomicInteger asfdas;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
    }
}
