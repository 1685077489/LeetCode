package com.wt.Q17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
 * 
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ�� ���룺"23" �����["ad", "ae", "af", "bd", "be",
 * "bf", "cd", "ce", "cf"].
 * 
 * @author Wutong
 *
 */
//LeetCodeƽ̨�������������⣬û�ύ
//�ݹ�
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
