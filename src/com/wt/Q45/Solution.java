package com.wt.Q45;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4] 输出: 2 解释: 跳到最后一个位置的最小跳跃数是 2。   从下标为 0 跳到下标为 1
 * 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 * @author Wutong
 *
 */
/*贪心算法*/
public class Solution {
	public static int jump(int[] nums) {
		if (nums.length==1) {
			return 0;
		}
		if (nums[0]>=nums.length-1) {
			return 1;
		}
		int size = 0,next = 0,count=0;
		while (size<nums.length-1) {
			next = next(nums,size);
			size+=next;
			count++;
		}
		return count;

	}
	private static int next(int[] nums, int i) {
		if (nums[i]>=nums.length-1-i) {
			return nums[i];
		}
		if (nums[i]==0) {
			return 1;
		}
		int sum=0;
		int re=0;
		for (int j = 1; j <= nums[i]; j++) {
			if (j+nums[i+j]>sum) {
				re = j;
				sum = j+nums[i+j];
				if (sum>=nums.length-1-i) {
					return j;
				}
			}
		}
		return  re;
	}
	public static void main(String[] args) {
		int a[] = {2,3,1,1,4};
		System.out.println(jump(a));
	}
}
