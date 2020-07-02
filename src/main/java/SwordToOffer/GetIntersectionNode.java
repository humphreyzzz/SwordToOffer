package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/6/30 15:55
 * @Version 1.0
 **/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }

    public static void fastSort(int num[],int start,int end){
        if(start<end){
            int index = partition(num,start,end);
            fastSort(num,start,index-1);
            fastSort(num,index+1,end);
        }
    }

    public static int partition(int[] nums,int start,int end){
        int flag = nums[end];
        int index = start-1;
        for(int i=start;i<end;i++){

            if(nums[i]<flag){
                index++;
                swap(nums,i,index);
            }
        }
        swap(nums,index+1,end);
        return index+1;
    }

    public static void swap(int num[],int i,int j){
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
    }

    public static void main(String[] args){
        int num[] = new int[]{5,4,3,2,1,2,45,6,23,23423,1};
        fastSort(num,0,10);
        for(int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }
}
