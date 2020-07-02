package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/1 9:50
 * @Version 1.0
 **/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            // 获取索引 i
            int i = dic.getOrDefault(s.charAt(j), -1);
            // 更新哈希表
            dic.put(s.charAt(j), j);
            // dp[j - 1] -> dp[j]
            tmp = tmp < j - i ? tmp + 1 : j - i;
            // max(dp[j - 1], dp[j])
            res = Math.max(res, tmp);
        }
        return res;
    }

    public int slideWindow(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int head=0,res=0;
        char[] chars = s.toCharArray();
        for(int tail = 0;tail<s.length();tail++){
            if(dic.containsKey(chars[tail])){
                head = Math.max(dic.get(chars[tail])+1,head);
            }
            dic.put(chars[tail],tail);
            res = Math.max(res,tail-head+1);
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new LengthOfLongestSubstring().slideWindow("abba"));
    }
}
