package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/31 20:36
 * @Version 1.0
 **/
public class ClimbStairs {
    public int climbStairs(int n) {
        if(n<3) return n;
        int a = 1,b =1;
        for(int i=1;i<n;i++){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args){
        System.out.println(new ClimbStairs().climbStairs(4));
    }
}
