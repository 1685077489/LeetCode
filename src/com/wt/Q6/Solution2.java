package com.wt.Q6;
/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L C I R E T O E S I I G E D H N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 
 * @author Wutong
 *
 */
//直接确定每隔几个，就将字符放入某个字符串内
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
	public static String convert(String s, int numRows) {
		if(numRows<=1) {
			return s;
		}
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int j = 0; j < numRows; j++) {
			String string = "";
			map.put(j, string);
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (i%((numRows-1)*2)>(numRows-1)) {
				String string = map.get((numRows-1)*2-i%((numRows-1)*2));
				string+=s.charAt(i);
				map.put((numRows-1)*2-i%((numRows-1)*2), string);
			}else {
				String string = map.get(i%((numRows-1)*2));
				string+=s.charAt(i);
				map.put(i%((numRows-1)*2), string);
			}
				
		}
		String string = "";
		for (String string1 : map.values()) {
			string+=string1;
		}
		return string;

	}
	public static void main(String[] args) {
		String s = "LEETCODEISHIRING";
		System.out.println(convert(s, 4));
	}
}
