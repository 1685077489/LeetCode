package com.wt.Q13;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
	public static int romanToInt(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int re = 0, num = 0;
		int[] value = { 1000, 500, 100, 50, 10, 5, 1 };
		String[] strs = { "M", "D", "C", "L", "X", "V", "I" };
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < value.length; i++) {
			map.put(strs[i], value[i]);
		}

		for (int i = 0; i < s.length() - 1; i++) {
			if (map.get(s.charAt(i) + "") < map.get(s.charAt(i + 1) + "")) {
				num += map.get(s.charAt(i) + "");
			}
		}
		for (int i = 0; i < s.length(); i++) {

			re += map.get(s.charAt(i) + "");

		}
		return re - 2 * num;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
}
