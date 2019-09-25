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
public class Solution2 {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		choosenumber(candidates,target,0,re,list);
		return re;
	}

	private static void choosenumber(int[] candidates, int target, int i, List<List<Integer>> re, List<Integer> list) {
		if (target==0) {
			re.add(new ArrayList<Integer>(list));
			return;
		}
		if (target<candidates[0]) {
			return;
		}
		
		for (int num = i; num < candidates.length; num++) {
			if (candidates[num]>target) {
				break;
			}
			list.add(candidates[num]);
			choosenumber(candidates, target-candidates[num], num, re, list);
			list.remove(list.size()-1);
		}
		
	}

	public static void main(String[] args) {
		int a[] = { 3,6,12 };
		System.out.println(combinationSum(a, 12));
	}
}
