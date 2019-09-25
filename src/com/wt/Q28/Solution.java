package com.wt.Q28;

/**
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll" 输出: 2 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 * 
 * 
 * 
 * @author Wutong
 *双指针
 */

public class Solution {
	public static int strStr(String haystack, String needle) {
		int j=0;
		if (needle.length()==0) {
			return 0;
		}
		for (int i = 0; i < haystack.length(); i++) {
			j = i+needle.length();
			if (haystack.charAt(i)==needle.charAt(0)) {
				if (j>haystack.length()) {
					return -1;
				}else if (haystack.substring(i, j).equals(needle)) {
					return i;
				}
				
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		String haystack = "azx";
		String needle = "xcv";
		System.out.println(strStr(haystack, needle));

	}
}
