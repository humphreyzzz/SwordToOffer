package SwordToOffer;

import java.util.LinkedHashMap;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/6/30 14:56
 * @Version 1.0
 **/
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character,Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for(char c:chars){
            map.put(c,!map.containsKey(c));
        }
        for(char c:map.keySet()){
            if(map.get(c)) return c;
        }
        return ' ';
    }
}
