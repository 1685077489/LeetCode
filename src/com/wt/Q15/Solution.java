package com.wt.Q15;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int j2 = j + 1; j2 < nums.length; j2++) {
					if (nums[i] + nums[j] + nums[j2] == 0) {
						List<Integer> integers = new ArrayList<Integer>();
						integers.add(nums[i]);
						integers.add(nums[j]);
						integers.add(nums[j2]);
						lists.add(integers);
					}
				}
			}
		}
		List<Integer> a = new ArrayList<Integer>();

		for (int i = 0; i < lists.size() - 1; i++) {
			for (int j = i + 1; j < lists.size(); j++) {
				if (equals(lists.get(i), lists.get(j)) && equals(lists.get(j), lists.get(i))) {
					a.add(i);
					j = lists.size();
				}
			}

		}
		List<List<Integer>> lists2 = new ArrayList<List<Integer>>();
		for (int i = 0; i < lists.size(); i++) {
			if (!a.contains(i)) {
				lists2.add(lists.get(i));
			}
		}

		return lists2;

	}

	public static boolean equals(List<Integer> list, List<Integer> list2) {
		boolean re1 = true;
		for (int i : list) {
			boolean re = false;
			for (int j : list2) {
				re = re || (i == j);
			}
			re1 = re1 && re;
		}
		return re1;

	}

	public static void main(String[] args) {

		int[] nums = {-9,14,-7,-8,9,1,-10,-8,13,12,6,9,3,-3,-15,-15,1,8,-7,-4,-6,8,2,-10,8,11,-15,3,0,-11,-1,-1,10,0,6,5,-14,3,12,-15,-7,-5,9,11,-1,1,3,-15,-5,11,-12,-4,-4,-2,-6,-10,-6,-6,0,2,-9,14,-14,-14,-9,-1,-2,-7,-12,-13,-15,-4,-3,1,14,3,-12,3,3,-10,-9,-1,-7,3,12,-6,0,13,4,-15,0,2,6,1,3,13,8,-13,13,11,11,13,14,-6};
		List<List<Integer>> lists = threeSum(nums);
		for (List<Integer> list : lists) {
			System.out.println(list.toString());
		}
//		System.out.println(equals(ary, ary1)&&equals(ary1, ary));
	}
}
