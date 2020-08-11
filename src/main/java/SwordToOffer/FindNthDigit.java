package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/5 9:49
 * @Version 1.0
 **/
public class FindNthDigit {
    public int findNthDigit(int n) {
        if(n<10) return n;
        long temp = 9;
        int digit = 1;
        while (n-temp*digit>0){
            n = (int)(n - temp*digit);
            temp = temp*10;
            digit++;
        }
        int numberCount = n/digit;
        int digitCount = n%digit;
        String resString;
        if(digitCount==0){
            long resNumber = (long)Math.pow(10,digit-1)+numberCount-1;
            resString = String.valueOf(resNumber);
            return resString.charAt(resString.length()-1)-'0';
        }
        else{
            long resNumber = (long)Math.pow(10,digit-1)+numberCount;
            resString = String.valueOf(resNumber);
            return resString.charAt(digitCount-1)-'0';
        }



    }

    public static void main(String[] args){
        System.out.println(new FindNthDigit().findNthDigit(1000000000));
    }
}
