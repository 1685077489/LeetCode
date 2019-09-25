package com.wt.Q17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 输入："23" 输出：["ad", "ae", "af", "bd", "be",
 * "bf", "cd", "ce", "cf"].
 * 
 * @author Wutong
 *
 */
//LeetCode平台测试用例有问题，没提交
//递归
public class Solution {
	
	static Map<Integer, String> map = mk();
	static ArrayList<String> list= new ArrayList<String>();
	public static List<String> letterCombinations(String digits) {
		String s1 = "";
		total(s1, digits);
		return list;
	}
	public static void total(String string,String string2) {
		if (string2.length() > 0) {
			int number = Integer.parseInt(string2.charAt(0)+"") ;
			String value = map.get(number);
			for (int i = 0; i < value.length(); i++) {
				total(string+value.charAt(i), string2.substring(1));
			}
		}else if (string.length()>0) {
			list.add(string);
		} 
	}
	public static Map<Integer, String> mk() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		int a[] = {2,3,4,5,6,7,8,9};
		String b[] = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		for (int i = 0; i < b.length; i++) {
			map.put(a[i],b[i]);
		}
		return map;
	}
	public static void main(String[] args) {
		List<String> list =letterCombinations("23");
		for (String string : list) {
			System.out.println(string);
		}

	}
}
