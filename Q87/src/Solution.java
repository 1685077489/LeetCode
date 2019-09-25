import java.util.Arrays;

/**
 * ����һ���ַ���?s1�����ǿ��԰����ݹ�طָ�������ǿ����ַ������Ӷ������ʾΪ��������
 * ��ͼ���ַ���?s1?=?"great"?��һ�ֿ��ܵı�ʾ��ʽ��
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * ����������ַ����Ĺ����У����ǿ�����ѡ�κ�һ����Ҷ�ڵ㣬Ȼ�󽻻����������ӽڵ㡣
 * ���磬���������ѡ��Ҷ�ڵ�?"gr"?���������������ӽڵ㣬������������ַ���?"rgeat"?��
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * ���ǽ�?"rgeat��?����?"great"?��һ�������ַ�����
 * ͬ���أ�������Ǽ��������ڵ�?"eat"?��?"at"?���ӽڵ㣬���������һ���µ������ַ���?"rgtae"?��
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * ���ǽ�?"rgtae��?����?"great"?��һ�������ַ�����
 * ��������������ȵ��ַ��� s1 ��?s2���ж�?s2?�Ƿ���?s1?�������ַ�����
 * ʾ��?1:
 * ����: s1 = "great", s2 = "rgeat"
 * ���: true
 * ʾ��?2:
 * ����: s1 = "abcde", s2 = "caebd"
 * ���: false
 *
 * @author WuTong
 * @create 2019-09-01 8:58
 */
public class Solution {
    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2))
            return true;
        if (!Similar(s1, s2))
            return false;
        int size = s1.length();
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, size), s2.substring(i, size)) ||
                    isScramble(s1.substring(0, i), s2.substring(size-i, size)) && isScramble(s1.substring(i, size), s2.substring(0, size-i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean Similar(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isScramble("abcde","caebd"));
    }
}
