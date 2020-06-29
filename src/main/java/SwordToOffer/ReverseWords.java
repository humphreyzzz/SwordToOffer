package SwordToOffer;

/**
 * Created with IDEA
 * author:hh
 * Date:2020/6/28
 * Time:20:00
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] arrs = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=arrs.length-1;i>=0;i--){
            if(arrs[i].length()>0){
                stringBuffer.append(arrs[i].trim());
                stringBuffer.append(" ");
            }

        }
        return stringBuffer.toString().trim();
    }

    public static void main(String[] args){
        System.out.println(new ReverseWords().reverseWords("a good   example"));
    }
}
