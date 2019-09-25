package com.wt.Q56;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和
 * [2,6] 重叠, 将它们合并为 [1,6]. 示例 2:
 * 
 * 输入: [[1,4],[4,5]] 输出: [[1,5]] 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static int[][] merge(int[][] intervals) {
		if (intervals.length==0) {
			return intervals;
		}
		List<int[]> resList = new ArrayList<int[]>();
		for (int i = 0; i < intervals.length - 1; i++) {
			boolean ti = true;
			for (int j = i+1; j < intervals.length; j++) {
				if (caninclude(intervals[i], intervals[j])) {
					ti=false;
					intervals[j] = new int[] { Math.min(intervals[i][0], intervals[j][0]),
							Math.max(intervals[i][1], intervals[j][1]) };
					continue;
				}
			}
			if (ti) {
				resList.add(intervals[i]);
			}
			
		}
		resList.add(intervals[intervals.length - 1]);
		int[][] res = new int[resList.size()][];
		for (int i = 0; i < resList.size(); i++) {
			res[i] = resList.get(i);
		}
		return res;

	}

	private static boolean caninclude(int[] is, int[] is2) {
		if (is[0] >= is2[0] && is[0] <= is2[1]) {
			return true;
		} else if (is2[0] >= is[0] && is2[0] <= is[1]) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) {
		int a[][] = { { 2, 3 }, { 5, 5 }, { 2, 2 }, { 3, 4 }, { 3, 4 } };
		int[][] merge = merge(a);
		for (int[] is : merge) {
			for (int is2 : is) {
				System.err.println(is2);
			}
		}
	}
}
