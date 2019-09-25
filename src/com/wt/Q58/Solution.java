package com.wt.Q58;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 
 * 示例:
 * 
 * 输入: "Hello World" 输出: 5
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static int lengthOfLastWord(String s) {
		s = s.trim();
		if (s.length() == 0) {
			return 0;
		}
		int i = s.length() - 1;
		char re;
		int res = 0;
		while (i >= 0) {
			re = ' ';
			if (s.charAt(i) == re) {
				break;
			}
			res++;
			i--;
		}
		return res;

	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" a a  "));
	}
}
