import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * @author WuTong
 * @create 2019-09-02 16:06
 */
public class Solution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length()>=4&&s.length()<=12)
            total(s, list);
        return list;
    }

    private static void total(String s, List<String> list) {
        String[] split = s.split("\\.");
        if (split.length==4){
            String s1 = split[3];
            if ((s1.charAt(0)=='0'&&s1.length()>1)|| Integer.valueOf(s1)>255)
                return;
            list.add(s);
        }
        String temp = "";
        for (int i = 0; i < split.length - 1; i++) {
            temp += (split[i] + ".");
        }
        if (split.length < 4) {
            String demo = split[split.length - 1];
            for (int i = 1; i <= Math.min(3,demo.length()); i++) {
                String s1 = demo.substring(0, i);
                if ((demo.length() - s1.length() <= 3 * (4 - split.length)) && (demo.length() - s1.length() >= (4 - split.length))) {
                    if ((s1.charAt(0) == '0' && s1.length() == 1) || (s1.charAt(0) != '0' && Integer.valueOf(s1) <= 255)) {
                        total(temp + s1 + "." + demo.substring(i),list);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        for (String restoreIpAddress : restoreIpAddresses("255255255255")) {
            System.out.println(restoreIpAddress);
        }
    }
}
