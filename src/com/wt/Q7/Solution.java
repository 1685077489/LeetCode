package com.wt.Q7;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123 输出: 321  示例 2:
 * 
 * 输入: -123 输出: -321 示例 3:
 * 
 * 输入: 120 输出: 21
 * 
 * @author Wutong
 *
 */
//用字符串缓冲池StringBuffer的reverse()函数进行反转
public class Solution {
	public static int reverse(int x) {
		String string = x + "";
		int num = string.length();
		int re;
		if ((string.charAt(0) + "").equals("-")) {
			String string2 = string.substring(1, num);
			String string3 = new StringBuffer(string2).reverse().toString();
			try {
				re = Integer.parseInt(string.charAt(0) + string3);
			} catch (Exception e) {
				return 0;
			}

		} else {
			try {
				re = Integer.parseInt(new StringBuffer(string).reverse().toString());
			} catch (Exception e) {
				return 0;
			}

		}

		return re;

	}

	public static void main(String[] args) {
		int i = 1534236469;
		System.out.println(reverse(i));
	}
}
