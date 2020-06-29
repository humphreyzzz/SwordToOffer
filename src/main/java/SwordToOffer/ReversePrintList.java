package SwordToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 示例 1：
 输入：head = [1,3,2]
 输出：[2,3,1]
  
 限制：
 0 <= 链表长度 <= 10000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePrintList {
    public int[] reversePrint(ListNode head) {
        /**
         * 最简单的方式
         */
//        ListNode listNode = head;
//        List<Integer> list = new ArrayList<>();
//        while (listNode!=null){
//            list.add(listNode.val);
//            listNode = listNode.next;
//        }
//        int[] result = new int[list.size()];
//        for(int i=list.size()-1;i>=0;i--){
//            result[list.size()-1-i]=list.get(i);
//        }
        /**
         * 先计算长度，再逆序输入进数组
         */
        ListNode listNode = head;
        int length = 0;
        while (listNode!=null){
            length++;
            listNode = listNode.next;
        }
        int[] result = new int[length];
        listNode = head;
        for(int i=0;i<length;i++){
            result[length-1-i]=listNode.val;
            listNode = listNode.next;
        }
        return result;
    }
}
