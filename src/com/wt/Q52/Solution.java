package com.wt.Q52;

/**
 * 判断n皇后有多少个解
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static int totalNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		String string = "";
		for (int i = 0; i < n; i++) {
			string += ".";
		}
		List<int[]> re = new ArrayList<int[]>();
		List<List<int[]>> result = new ArrayList<List<int[]>>();
		queen(re, 0, n, result);
		return result.size();
	}

	private static void queen(List<int[]> re, int i, int n, List<List<int[]>> result) {
		if (i > n) {
			return;
		}
		if (re.size() == n) {
			result.add(re);
			return;
		}
		List<int[]> res = new ArrayList<int[]>(re);
		for (int j = 0; j < n; j++) {
			int[] a = { i, j };
			if (allow(res, a)) {
				res.add(a);
				queen(new ArrayList<int[]>(res), i + 1, n, result);
				res.remove(res.size() - 1);
			}
		}

	}

	private static boolean allow(List<int[]> re, int[] num) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		for (int[] i : re) {
			list.add(i[1] - i[0]);
			list2.add(i[1] + i[0]);
			list3.add(i[1]);
		}
		if (list.contains(num[1] - num[0]) || list2.contains(num[1] + num[0]) || list3.contains(num[1])) {
			return false;
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(totalNQueens(4));
	}
}
