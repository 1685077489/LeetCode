package com.wt.Q34;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8 输出: [3,4] 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6 输出: [-1,-1]
 * 
 * @author Wutong
 *
 */
/**
 * 二分搜索
 * @author Wutong
 *
 */
public class Solution {
	public static int[] searchRange(int[] nums, int target) {

		int left = 0, right = 0;
		int re[] = { -1, -1 };
		if (nums.length == 0) {
			return re ;
		}
		left = searchleft(nums, target);
		right = searchright(nums, target);
		re=new int[] { left, right };
		return re;

	}

	private static int searchright(int[] nums, int target) {
		if (nums.length == 1) {
			if (nums[0] == target) {
				return 0;
			} else {
				return -1;
			}
		}

		int mid = (nums.length) / 2, re = 0;
		if (target >= nums[mid]) {
			int r = 0;
			r = searchright(Arrays.copyOfRange(nums, mid, nums.length), target);
			if (r == -1) {
				re = -1;
			} else {
				re = mid + r;
			}

		} else {
			re = searchright(Arrays.copyOfRange(nums, 0, mid), target);

		}
		return re;
	}

	private static int searchleft(int[] nums, int target) {
		if (nums.length == 1) {
			if (nums[0] == target) {
				return 0;
			} else {
				return -1;
			}
		}
		int mid = (nums.length - 1) / 2, re = 0;
		if (target <= nums[mid]) {
			re = searchleft(Arrays.copyOfRange(nums, 0, mid + 1), target);
		} else {
			int r = 0;
			r = searchleft(Arrays.copyOfRange(nums, mid + 1, nums.length), target);
			if (r == -1) {
				re = -1;
			} else {
				re = mid + 1 + r;
			}

		}
		return re;
	}

	public static void main(String[] args) {
		int[] data = {8};
		int[] copyOfRange = searchRange(data, 8);
		for (int i : copyOfRange) {
			System.out.println(i);
		}
	}
}
