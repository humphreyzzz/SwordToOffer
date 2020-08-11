package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/30 11:02
 * @Version 1.0
 **/

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 *
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        // 假设给定字符串s可由一个子串x重复n次构成，即s=nx。
        // 现构造新字符串t=2s，即两个s相加，由于s=nx，则t=2nx。
        // 去掉t的开头与结尾两位，则这两处的子串被破坏掉，此时t中包含2n-2个子串。
        // 由于t中包含2n-2个子串，s中包含n个子串，若t中包含s，则有2n-2>=n，可得n>=2，
        // 由此我们可知字符串s可由一个子串x重复至少2次构成，判定为true；
        // 反之，若t中不包含s，则有2n-2<n，可得n<2，n只能为1，
        // 由此我们可知字符串s=x，假定的子串就为s本身，判定为false。
        return (s+s).substring(1,(s+s).length()-1).contains(s);
    }

    public static void main(String[] args){
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabcabcd"));
    }
}
