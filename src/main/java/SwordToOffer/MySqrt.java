package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/31 20:05
 * @Version 1.0
 **/
public class MySqrt {
    public int mySqrt(int x) {
        int leftBound = 0;
        int rightBound = x;
        int mid = 0;
        while (leftBound<=rightBound){
            mid = leftBound+(rightBound-leftBound)/2;
            if(mid*mid==x) return mid;
            if((long)mid*mid>x){
                rightBound = mid-1;
            }else{
                leftBound = mid+1;
            }
        }
        if(mid*mid>x) return mid-1;
        return mid;
    }

    public static void main(String[] args){
        System.out.println(new MySqrt().mySqrt(101));
    }
}
