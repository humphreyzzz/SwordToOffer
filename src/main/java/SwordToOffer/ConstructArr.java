package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/6/30 17:24
 * @Version 1.0
 **/
public class ConstructArr {
    public int[] constructArr(int[] a) {
        if(a.length == 0) return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new ConstructArr().constructArr(a);
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
    }
}
