package com.wt.Q35;

import java.util.Arrays;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5 输出: 2 示例 2:
 * 
 * 输入: [1,3,5,6], 2 输出: 1 示例 3:
 * 
 * 输入: [1,3,5,6], 7 输出: 4 示例 4:
 * 
 * 输入: [1,3,5,6], 0 输出: 0
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
	public static int searchInsert(int[] nums, int target) {
		if (nums.length == 0) {
			return 0;
		}
		if (target <= nums[0]) {
			return 0;
		} else if (target > nums[nums.length - 1]) {
			return nums.length;
		}
		int mid = (nums.length - 1) / 2, re = 0;
		if (target <= nums[mid]) {
			re = searchInsert(Arrays.copyOfRange(nums, 0, mid + 1), target);
		} else {
			int r = 0;
			r = searchInsert(Arrays.copyOfRange(nums, mid + 1, nums.length), target);
			if (r == -1) {
				re = -1;
			} else {
				re = mid + 1 + r;
			}
		}
		return re;
	}

	public static void main(String[] args) {
		int a[] = {5,5,5,5,5};
		System.out.println(searchInsert(a, 5));
	}
}
