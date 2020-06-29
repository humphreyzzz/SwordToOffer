package SwordToOffer;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        char space = ' ';
        for(char x:s.toCharArray()){
            if(x==space){
                stringBuffer.append("%20");
            }
            else stringBuffer.append(x);
        }
        return stringBuffer.toString();
    }
}
