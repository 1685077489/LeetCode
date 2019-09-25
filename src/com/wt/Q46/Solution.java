package com.wt.Q46;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3] 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * @author Wutong
 *
 */
/*回溯算法*/
public class Solution {
	public static List<List<Integer>> permute(int[] nums) {
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
		if (newlist.size()==i) {
			resList.add(newlist);
		}
		
		for (int j = 0; j < demo.size(); j++) {
			int num = demo.get(0);
			newlist.add(num);
			demo.remove(0);
			total(newlist, i, resList, demo);
			newlist.remove(newlist.size()-1);
			demo.add(num);
		}

	}
	public static void main(String[] args) {
		int a[] = {1,2,3};
		List<List<Integer>> permute = permute(a);
		for (List<Integer> list : permute) {
			System.out.println(list);
			
		}
	}
}
