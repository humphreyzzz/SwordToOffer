package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/17 15:02
 * @Version 1.0
 **/
public class AddWithoutOperation {
    public int add(int a, int b) {
        while(b!=0){
            int c = (a&b)<<1;
            a = a^b;
            b = c;
        }
        return a;
    }


    public static void main(String[] args){
        System.out.print(new AddWithoutOperation().add(18,15));
    }
}
