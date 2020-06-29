package SwordToOffer;

/**
 * Created with IDEA
 * author:hh
 * Date:2020/6/28
 * Time:16:13
 */
public class TranslateNum {

    public int translateNum(int num) {
        char chars[]=String.valueOf(num).toCharArray();
        int originNum[] = new int[chars.length];
        for(int i=0;i<chars.length;i++){
            originNum[i] = (int)chars[i] - (int)('0');
        }
        int f[] = new int[originNum.length+1];
        f[1] = 1;
        if(originNum[0]*10+originNum[1]<26){
            f[2] = 2;
        }else{
            f[2] = 1;
        }
        for(int i=3;i<f.length;i++){
            if(originNum[i-1]!=0&&originNum[i-2]*10+originNum[i-1]<26){
                f[i] = f[i-1]+ f[i-2];
            }
            else{
                f[i] = f[i-1];
            }
        }
        return f[f.length-1];
    }

    public static void main(String[] args){
        System.out.println(new TranslateNum().translateNum(12258));
    }
}
