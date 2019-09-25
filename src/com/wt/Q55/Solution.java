package com.wt.Q55;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4] 输出: true 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。 示例 2:
 * 
 * 输入: [3,2,1,0,4] 输出: false 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ，
 * 所以你永远不可能到达最后一个位置。
 * 
 * @author Wutong
 *
 */
/*和45差不多*/
public class Solution {
	public static boolean canJump(int[] nums) {
		if (nums.length == 1 || nums[0] >= nums.length - 1) {
			return true;
		}
		int size = 0, next = 0;
		while (size < nums.length - 1) {
			if (nums[size] == 0 && size != nums.length - 1) {
				return false;
			}
			next = next(nums, size);
			size += next;
		}
		return true;

	}

	private static int next(int[] nums, int i) {
		if (nums[i] >= nums.length - 1 - i) {
			return nums[i];
		}
		if (nums[i] == 0) {
			return 0;
		}
		int sum = 0;
		int re = 0;
		for (int j = 1; j <= nums[i]; j++) {
			if (j + nums[i + j] > sum) {
				re = j;
				sum = j + nums[i + j];
				if (sum >= nums.length - 1 - i) {
					return j;
				}
			}
		}
		return re;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(canJump(nums));
	}
}
