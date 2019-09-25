package com.wt.Q47;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2] 输出: [ [1,1,2], [1,2,1], [2,1,1] ]
 * 
 * @author Wutong
 *
 */
/*回溯算法*/
public class Solution {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<Integer> demo = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			demo.add(nums[i]);
		}
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		total(list, nums.length, resList, demo);
		return resList;

	}

	private static void total(List<Integer> list, int i, List<List<Integer>> resList, List<Integer> demo) {
		List<Integer> newlist =new ArrayList<>(list);
		List<Integer> newnum =new ArrayList<>();
		if (newlist.size()==i) {
			resList.add(newlist);
			return;
		}
		for (int j = 0; j < demo.size(); j++) {
			if (newnum.contains(demo.get(0))) {//去重
				int num = demo.get(0);
				demo.remove(0);
				demo.add(num);
				continue;
			}
			int num = demo.get(0);
			newlist.add(num);
			demo.remove(0);
			total(newlist, i, resList, demo);
			newlist.remove(newlist.size()-1);
			demo.add(num);
			newnum.add(num);
		}

	}
	public static void main(String[] args) {
		int a[] = {1,2,3};
		List<List<Integer>> permute = permuteUnique(a);
		for (List<Integer> list : permute) {
			System.out.println(list);
			
		}

	}
}
