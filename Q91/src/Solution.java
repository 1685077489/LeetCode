import java.util.ArrayList;
import java.util.List;

/**
 * 一条包含字母?A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释:?它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例?2:
 * 输入: "226"
 * 输出: 3
 * 解释:?它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * @author WuTong
 * @create 2019-09-02 8:42
 */
public class Solution {
    public static int numDecodings(String s) {
        if (s.equals("0"))
            return 0;
        if (s.substring(0,1).equals("-"))
            s=s.substring(1,s.length());
        List<Integer> list = new ArrayList<>();
        total(s, 0, list);
        return list.size();
    }

    private static void total(String s, int i, List<Integer> list) {
        if (i >= s.length()) {
            list.add(1);
            return;
        }
        int n = i;
        if ( Integer.valueOf(s.substring(i,i+1))!=0)
            total(s, n + 1, list);
        if (i!=s.length()-1){
            String s1 = s.substring(i,i+2);
            Integer integer = Integer.valueOf(s1);
            if (integer<=26&&integer>=10)
                total(s,n+2,list);
        }

    }

    public static void main(String[] args) {
        int i = numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253");
        System.out.println(i);
    }

}
