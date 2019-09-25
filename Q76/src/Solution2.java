
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
 * 滑动窗口法
 */
public class Solution2 {
    public static String minWindow(String s, String t) {
        if (t.equals(s))
            return t;
        if (t.length() > s.length() || t.length() == 0)
            return "";
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<Integer> slist = new ArrayList<>();//t中的字符的下标
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {          //提取s中在t中的下标
            char n = s.charAt(i);
            if (map.containsKey(n)) {
                slist.add(i);
            }
        }
        int count = 0;
//        Map<Character, Integer> windowCounts = new HashMap<>();
        for (int i = 0; i < slist.size(); i++) {
            char temp = s.charAt(slist.get(i));
            map.put(temp, map.get(temp) - 1);//将字符对应的value-1
//            int num = windowCounts.getOrDefault(temp, 0);
//            windowCounts.put(temp, num + 1);
            if (map.get(temp)==0)
                count++;
            list.add(slist.get(i));
            while (count == map.size()) {
                if (res.size() != 0) {
                    res = new ArrayList<>(((res.get(res.size() - 1) - res.get(0)) >
                            (list.get(list.size() - 1) - list.get(0)) ? list : res));  //判断长度
                } else {
                    res = new ArrayList<>(list);
                }
                map.put(s.charAt(list.get(0)), map.get(s.charAt(list.get(0))) + 1);
                if (map.get(s.charAt(list.get(0)))>0)
                    count--;
                list.remove(0);
            }
        }
        return res.isEmpty() ? "" : s.substring(res.get(0), res.get(res.size() - 1) + 1);

    }

    public static void main(String[] args) {
        System.out.println(minWindow("aaaaaabbaa",
                "aabb"));
    }
}
