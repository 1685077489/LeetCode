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
//二分法，将第一个字符串用二分拆分，若左边的字符串与每个字符串的前边相符，就考虑右边的，继续二分。
public class Solution2 {
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
	        return "";
	    int minLen = Integer.MAX_VALUE;
	    for (String str : strs)
	        minLen = Math.min(minLen, str.length());
	    int low = 1;
	    int high = minLen;
	    while (low <= high) {
	        int middle = (low + high) / 2;
	        if (isCommonPrefix(strs, middle))
	            low = middle + 1;
	        else
	            high = middle - 1;
	    }
	    return strs[0].substring(0, (low + high) / 2);


	}
	private static boolean isCommonPrefix(String[] strs, int len){
	    String str1 = strs[0].substring(0,len);
	    for (int i = 1; i < strs.length; i++)
	        if (!strs[i].startsWith(str1))
	            return false;
	    return true;
	}

	public static void main(String[] args) {
		String[] strings = {"aca","aba"};
		System.out.println(longestCommonPrefix(strings));
	}
}
