package com.wt.Q14;


/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 * 
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length<1) {
			return "";
		}
		String re ="";
		int num = strs[0].length() ;
		for (String string : strs) {
			num = Math.min(num, string.length());
		}
		if (num<1) {
			return "";
		}
		for (int i = 0; i < num; i++) {
			if (cop(strs,i)) {
				re+=strs[0].charAt(i);
			}else {
				break;
			}
			
		}
		return re;

	}
	private static boolean cop(String[] strs, int i) {
		boolean re = true;
		Character character = strs[0].charAt(i);
		for (String string : strs) {
			re = re&&(string.charAt(i)==character);
		}
		return re;
		
	}
	public static void main(String[] args) {
		String[] strings = {"aca","cba"};
		System.out.println(longestCommonPrefix(strings));
	}
}
