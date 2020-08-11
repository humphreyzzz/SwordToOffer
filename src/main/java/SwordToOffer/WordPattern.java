package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/31 11:14
 * @Version 1.0
 **/

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        String[] strings = str.split(" ");
        if(pattern.length()!=strings.length) return false;
        char[] chars = pattern.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(!map.containsKey(chars[i])){
                if(map.containsValue(strings[i])){
                    return false;
                }
                map.put(chars[i],strings[i]);
            }
            else{
                if(!map.get(chars[i]).equals(strings[i])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new WordPattern().wordPattern("abba","dog dog dog dog"));
    }
}
