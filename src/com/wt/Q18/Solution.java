package com.wt.Q18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 * 
 * @author Wutong
 *
 */
public class Solution {
public static List<List<Integer>> fourSum(int[] nums, int target) {
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
	Arrays.sort(nums); // 排序
	int len = nums.length;
	if (nums == null || len < 4)
		return ans;
	for (int i = 0; i < len-3; i++) {
//		if (nums[i] > target)
//			break; // 如果当前数字大于target，则三数之和一定大于target，所以结束循环
//		if (i<len-4&&nums[i] == nums[i + 1])
//			continue; // 去重
		for (int j = i+1; j < len-2; j++) {
//			if (j <len-3&&nums[j] == nums[j + 1])
//				continue; // 去重
			int L = j + 1;
			int R = len - 1;
			while (L < R) {
				int sum = nums[i] + nums[j] +nums[L] + nums[R];
				if (sum == target) {
					ans.add(Arrays.asList(nums[i], nums[j],nums[L], nums[R]));
					while (L < R && nums[L] == nums[L + 1])
						L++; // 去重
					while (L < R && nums[R] == nums[R - 1])
						R--; // 去重
					L++;
					R--;
				} else if (sum < target)
					L++;
				else if (sum > target)
					R--;
			}
		}
		
	}
	List<Integer> a = new ArrayList<Integer>();

	for (int i = 0; i < ans.size() - 1; i++) {
		for (int j = i + 1; j < ans.size(); j++) {
			if (equals(ans.get(i), ans.get(j)) && equals(ans.get(j), ans.get(i))) {
				a.add(i);
				j = ans.size();
			}
		}

	}
	List<List<Integer>> ans2 = new ArrayList<List<Integer>>();
	for (int i = 0; i < ans.size(); i++) {
		if (!a.contains(i)) {
			ans2.add(ans.get(i));
		}
	}
	return ans2;
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

	int[] nums = {1,-2,-5,-4,-3,3,3,5};
	List<List<Integer>> ans = fourSum(nums, -11);
	for (List<Integer> list : ans) {
		System.out.println(list.toString());
	}
//	System.out.println(equals(ary, ary1)&&equals(ary1, ary));
    }
}
