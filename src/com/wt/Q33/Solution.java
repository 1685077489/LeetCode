package com.wt.Q33;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 * 
 * @author Wutong
 *
 */
/*
 * 二分搜索
 */
public class Solution {
	public static int search(int[] nums, int target) {
		if (nums.length==0) {
			return -1;
		}
		if (nums.length == 1) {
			if (nums[0] == target) {
				return 0;
			} else {
				return -1;
			}
		}
		if (nums.length == 2) {
			if (nums[0] == target) {
				return 0;
			} else if (nums[1] == target) {
				return 1;
			} else {
				return -1;
			}
		}
		int num = (nums.length - 1) / 2, re = 0;
		if (nums[nums.length - 1] <= nums[0]) {
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					num = i;
					if (target >= nums[0]) {

						int r = search(Arrays.copyOfRange(nums, 0, i + 1), target);
						if (r == -1) {
							re = -1;
						} else {
							re = r;
						}
					} else {
						int r = search(Arrays.copyOfRange(nums, i+1, nums.length), target);
						if (r == -1) {
							re = -1;
						} else {
							re = i + 1 + r;
						}
					}
					break;
				}
			}
		} else {
			if (target > nums[num]) {
				int r = search(Arrays.copyOfRange(nums, num + 1, nums.length), target);
				if (r == -1) {
					re = -1;
				} else {
					re = num + 1 + r;
				}

			} else {
				int r = search(Arrays.copyOfRange(nums, 0, num + 1), target);
				if (r == -1) {
					re = -1;
				} else {
					re = r;
				}
			}
		}

		return re;
	}

	public static void main(String[] args) {
		int[] data = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(data, 0));
	}
}
