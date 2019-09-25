package com.wt.Q39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 所有数字（包括 target）都是正整数。 解集不能包含重复的组合。  示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7, 所求解集为: [ [7], [2,2,3] ] 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8, 所求解集为: [   [2,2,2,2],   [2,3,3],  
 * [3,5] ]
 * 
 * @author Wutong
 *
 */
/**
 * 输入
[3,6,12]
24
输出
[[12,12],[6,6,6,6],[3,3,3,3,3,3,3,3]]
预期结果
[[3,3,3,3,3,3,3,3],[3,3,3,3,3,3,6],[3,3,3,3,6,6],[3,3,3,3,12],[3,3,6,6,6],[3,3,6,12],[6,6,6,6],[6,6,12],[12,12]]
直接跳过了其他可能
 * @author Wutong
 *
 */
public class Solution {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		int number = target;
		for (int i = candidates.length - 1; i >= 0; i--) {
			if (number >= candidates[i]) {
				number -= candidates[i];
				if (number < candidates[0] && number != 0) {
					number += candidates[i];
					continue;
				}
				list.add(i);
				i++;
			}
			if (number == 0) {
				i = list.get(0);
				if (i < 0) {
					break;
				}
				for (int j = 0; j < list.size(); j++) {
					list.set(j, candidates[list.get(j)]);
				}
				re.add(list);
				number = target;
				list= new ArrayList<Integer>();
			}
		}
		return re;
	}

	public static void main(String[] args) {
		int a[] = { 3,6,12 };
		System.out.println(combinationSum(a, 24));
	}
}
