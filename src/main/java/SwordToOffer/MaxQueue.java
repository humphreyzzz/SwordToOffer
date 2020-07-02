package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/6/30 10:08
 * @Version 1.0
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxQueue {
    private Queue<Integer> queue;
    private LinkedList<Integer> maxList;
    public MaxQueue() {
        queue = new LinkedList<>();
        maxList = new LinkedList<>();
    }

    public int max_value() {
        if(maxList.isEmpty()) return -1;
        return maxList.peek();
    }

    public void push_back(int value) {
        if(maxList.isEmpty()){
            maxList.add(value);
            queue.add(value);
        }
        else {
            while (!maxList.isEmpty()&&maxList.getLast()<value){
                maxList.removeLast();
            }
            maxList.add(value);
            queue.add(value);
        }
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int value = queue.poll();
        if(!maxList.isEmpty()&&maxList.peek()==value){
            maxList.poll();
        }
        return value;
    }

    public static void main(String[] args){
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.max_value();
        maxQueue.pop_front();
        maxQueue.max_value();
    }

}
