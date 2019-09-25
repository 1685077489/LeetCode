
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @author WuTong
 * @create 2019-08-22 14:57
 * 动态规划时间复杂度爆炸，如abababababababababc与abc
 * 时间复杂度有点高
 */
public class Solution {
    public static String minWindow(String s, String t) {
        if (t.equals(s))
            return t;
        if (t.length() > s.length() || t.length() == 0)
            return "";
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<Integer> slist = new ArrayList<>();//提取s中的在t中的字符的下标
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char n = s.charAt(i);
            if (map.containsKey(n)) {
                slist.add(i);
            }
        }
        boolean val = true;
        HashMap<Character, Integer> map1 = new HashMap<>(map);
        for (int i = 0; i < slist.size(); i++) {
            map1.put( s.charAt(slist.get(i)), map1.get(s.charAt(slist.get(i))) - 1);
            if (!list.isEmpty() && s.charAt(slist.get(i)) == s.charAt(list.get(0)) && map1.get(s.charAt(slist.get(i))) < 0) {//新数据和第一个相等，更换开头
                list.remove(0);
            }
            list.add(slist.get(i));
            for (Integer value : map1.values()) {
                if (value >= 1) {
                    val = false;
                    break;
                }
            }
            if (val) {
                if (res.size() != 0) {
                    res = new ArrayList<>(((res.get(res.size() - 1) - res.get(0)) >
                            (list.get(list.size() - 1) - list.get(0)) ? list : res));  //判断长度
                } else {
                    res = new ArrayList<>(list);
                }
                if (list.size() > 1) {
                    i = slist.indexOf(list.get(1)) - 1;
                }
                list.removeAll(list);
                map1 = new HashMap<>(map);

            }
            val = true;
        }
        if (res.isEmpty())
            return "";
        return s.substring(res.get(0), res.get(res.size() - 1) + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("aaxxxxabxcaa",
                "aabc"));
    }
}
