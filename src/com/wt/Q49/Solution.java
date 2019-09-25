package com.wt.Q49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"], 输出: [ ["ate","eat","tea"],
 * ["nat","tan"], ["bat"] ] 说明：
 * 
 * 所有输入均为小写字母。 不考虑答案输出的顺序。
 * 
 * @author Wutong
 *
 */
/*先将每个字符串中的内容排序，之后用hashmap统计*/
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
