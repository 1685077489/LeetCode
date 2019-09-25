package com.wt.Q30;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入： s = "barfoothefoobarman", words = ["foo","bar"] 输出：[0,9] 解释： 从索引 0 和 9
 * 开始的子串分别是 "barfoor" 和 "foobar" 。 输出的顺序不重要, [9,0] 也是有效答案。 示例 2：
 * 
 * 输入： s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();
		List<String> strings = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			strings.add(words[i]);
		}
		if (words.length==0) {
			return list;
		}
		String s1 = "";
		for (int i = 0; i <=s.length()-strings.size()*strings.get(0).length(); i++) {
			s1 = s.substring(i, i+strings.get(0).length());
			if (inclu(strings, s1)) {
				String s2 = s.substring(i, i+strings.size()*strings.get(0).length());
				if (resul(strings, s2)) {
					list.add(i);
				}
				
			}
		}
		return list;

	}
	private static boolean resul(List<String> strings, String s) {
		List<String> strings2 = strings;
		for (int i = 0; i <= s.length()-strings.get(0).length(); i+=strings.get(0).length()) {
			String s1 = s.substring(i, i+strings.get(0).length());
			if (inclu(strings2, s1)) {
				strings2 = remove(strings2, s1);
			}else {
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean inclu(List<String> strings,String s) {
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals(s)) {
				return true;
			}
		}
		return false;
	}
	public static List<String> remove(List<String> strings,String s) {
		List<String> re =new ArrayList<String>();
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals(s)) {
				for (int j = 0; j < strings.size(); j++) {
					if (j==i) {
						continue;
					}
					re.add(strings.get(j));
				}
				break;
			}
		}
		return re;
	}
	public static void main(String[] args) {
		
		String s = "aaaaaaaa";
		String[] words = {"aa","aa","aa"};
		List<Integer> list = findSubstring(s, words);
		for (Integer integer : list) {
			System.out.println(integer);
		}

	}
}
