package com.wt.Q5;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。
 * 
 * @author Wutong
 *
 */
/**
 * 由外到内，先判断两端是否相同，再判断内部，空间时间复杂度爆炸
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static String longestPalindrome(String s) {
		String re = "";
		int num = s.length(), i = 0;

		for (int j = i; j < num; j++) {										// 寻找两端相同的字符串
			if (s.charAt(i) == s.charAt(j)) {
				String substring = s.substring(i, j + 1);
				if (HW(substring) && re.length() <= substring.length()) {
					re = substring;
				}
			}
		}
		i++;

		return re;

	}

	//判断是否为回文
	public static boolean HW(String s) {
		boolean re = true;
		for (int i = 0; i < s.length() / 2; i++) {
			if (!(s.charAt(i) == s.charAt(s.length() - i - 1))) {
				re = false;
			}
		}
		return re;

	}

	public static void main(String[] args) {
		String string = "";
		String string2 = longestPalindrome(string);
		System.out.println(string2);

	}
}
