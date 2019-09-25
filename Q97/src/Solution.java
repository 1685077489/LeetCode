
/**
 * ���������ַ���?s1, s2, s3, ��֤?s3?�Ƿ�����?s1?��?s2 ������ɵġ�
 * ʾ�� 1:
 * ����: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * ���: true
 * ʾ��?2:
 * ����: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * ���: false
 *
 * @author WuTong
 * @create 2019-09-03 14:34
 * �򵥵Ķ�̬�滮:����������ʱ�临�Ӷȹ���,���ϲ�ͨ��
 */
public class Solution {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        int num1 = 0, num2 = 0;
        return cando(num1, num2, s1, s2, s3);

    }

    private static boolean cando(int num1, int num2, String s1, String s2, String s3) {
        if (num1+num2==s3.length())
            return true;
        if (num1==s1.length())
            return s2.substring(num2).equals(s3.substring(num1+num2));
        if (num2==s2.length())
            return s1.substring(num1).equals(s3.substring(num1+num2));
        char c = s3.charAt(num1+num2);
        char c1 = s1.charAt(num1);
        char c2 = s2.charAt(num2);
        boolean res = false;
        if (c1 == c) {
            res = res || cando(num1 + 1, num2, s1, s2, s3);
            if (res)
                return res;
        }
        if (c2 == c) {
            res = res || cando(num1, num2 + 1, s1, s2, s3);
        }
        return res;
    }

    public static void main(String[] args) {
        boolean interleave = isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab");
        System.out.println(interleave);


    }
}
