package com.wt.Q57;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5] 输出: [[1,5],[6,9]] 示例 2:
 * 
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] 输出:
 * [[1,2],[3,10],[12,16]] 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> resList = new ArrayList<int[]>();
		if (intervals.length == 0) {
			resList.add(newInterval);
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < intervals.length; i++) {
			if (caninclude(intervals[i], newInterval)) {
				list.add(i);
			}
		}

		if (list.size() == 0) {
			int d = 0;
			for (int i = 0; i < intervals.length; i++) {
				if (intervals[i][0] > newInterval[1]) {
					d = i;
					break;
				}
				d = intervals.length;
			}
			for (int i = 0; i < intervals.length; i++) {
				if (i == d) {
					resList.add(newInterval);
					i--;
					d=-1;
					continue;
				}
				resList.add(intervals[i]);
			}
			if (d == intervals.length && d != 0) {
				resList.add(newInterval);
			}
		} else if (list.size() == 1) {
			intervals[list.get(0)] = new int[] { Math.min(intervals[list.get(0)][0], newInterval[0]),
					Math.max(intervals[list.get(0)][1], newInterval[1]) };
			return intervals;
		} else {
			int min = newInterval[0], max = newInterval[1];
			for (int i = 0; i < list.size(); i++) {
				min = Math.min(intervals[list.get(i)][0], min);
				max = Math.max(intervals[list.get(i)][1], max);
			}
			for (int i = 0; i < intervals.length; i++) {
				if (i == list.get(0)) {
					resList.add(new int[] { min, max });
					i += list.size() - 1;
					continue;
				}
				resList.add(intervals[i]);
			}
		}
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
		int a[][] = { { 1, 5 } };
		int[][] merge = insert(a, new int[] { 0, 0 });
		for (int[] is : merge) {
			for (int is2 : is) {
				System.err.println(is2);
			}
		}
	}
}
