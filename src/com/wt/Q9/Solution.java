package com.wt.Q9;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121 输出: true 示例 2:
 * 
 * 输入: -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * @author Wutong
 *
 */
public class Solution {
	public boolean isPalindrome(int x) {
		String string = x + "";
		String string2 = new StringBuffer(string.subSequence(0, string.length() / 2)).reverse().toString();
		if (string.length() % 2 == 0) {
			return string2.equals(string.subSequence(string.length() / 2, string.length()));
		} else {
			return string2.equals(string.subSequence(string.length() / 2 + 1, string.length()));
		}

	}
}
