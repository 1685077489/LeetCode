import java.util.ArrayList;
import java.util.List;

/**
 * @author WuTong
 * @create 2019-09-02 9:35
 */
public class Solution2 {
    public static int numDecodings(String s) {
        if (s.substring(0, 1).equals("-"))
            s = s.substring(1, s.length());
        if (s.charAt(0) == '0')
            return 0;
        int[] a = new int[s.length()];
        a[0] = 1;
        if (s.length() == 1)
            return 1;
        if (Integer.valueOf(s.substring(0, 2)) <= 26) {
            if (s.charAt(1) == '0')
                a[1] = 1;
            else
                a[1] = 2;
        } else if (s.charAt(1) == '0')
            return 0;
        else
            a[1] = 1;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) == '0' || Integer.valueOf(s.substring(i - 1, i + 1)) > 26))
                return 0;
            if (s.charAt(i) == '0') {
                a[i] = a[i - 2];
                continue;
            }
            if (s.charAt(i - 1) == '0')
                a[i] = a[i - 1];
            else if (Integer.valueOf(s.substring(i - 1, i + 1)) <= 26)
                a[i] = a[i - 1] + a[i - 2];
            else a[i] = a[i - 1];
        }
        return a[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1024"));
    }
}
