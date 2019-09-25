package com.wt.Q49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
 * 
 * ʾ��:
 * 
 * ����: ["eat", "tea", "tan", "ate", "nat", "bat"], ���: [ ["ate","eat","tea"],
 * ["nat","tan"], ["bat"] ] ˵����
 * 
 * ���������ΪСд��ĸ�� �����Ǵ������˳��
 * 
 * @author Wutong
 *
 */
/*�Ƚ�ÿ���ַ����е���������֮����hashmapͳ��*/
public class Solution {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> resList = new ArrayList<List<String>>();
		List<String> newstr = new ArrayList<String>();
		HashMap<String, ArrayList<String>> demo=new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			newstr.add(strs[i]);
		} 
		for (int i = 0; i < newstr.size(); i++) {
			char[] arrayCh=newstr.get(i).toCharArray();
	        Arrays.sort(arrayCh);
	        newstr.set(i, new String(arrayCh));
		}
		for (int i = 0; i < newstr.size(); i++) {
			if (demo.containsKey(newstr.get(i))) {
				demo.get(newstr.get(i)).add(strs[i]);
			}else {
				demo.put(newstr.get(i), new ArrayList<String>());
				demo.get(newstr.get(i)).add(strs[i]);
			}
		}
		for (ArrayList<String> string : demo.values()) {
			resList.add(string);
		}
        return resList;
    }
	public static void main(String[] args) {
		String[]  a= {"eat","tea","tan","ate","nat","bat","bat"};
		groupAnagrams(a);
	}
}
