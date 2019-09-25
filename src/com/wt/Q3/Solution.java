package com.wt.Q3;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 */
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		String string = "zxcvb";
		String demo = string.substring(4, 5);
		System.out.println(demo);
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length(), result = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);// 将i设置为重复的那个value（value为+1）
			}
			result = Math.max(result, j - i + 1);
			map.put(s.charAt(j), j + 1);// 重复的key会被替换成新的
		}
		return result;

	}

}
