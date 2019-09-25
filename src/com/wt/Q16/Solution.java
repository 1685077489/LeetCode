package com.wt.Q16;

import java.util.Arrays;


/**
 * 给定一个包括 n 个整数的数组 nums 和
 * 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums); // 排序
		int len = nums.length, re =nums[0]+nums[1]+nums[2], result = re;
		if (nums == null || len < 3)
			return 0;
		for (int i = 0; i < len-2; i++) {
			for (int L = i + 1; L<len-1; L++) {
				for (int R = len - 1; L<R; R--) {
					int sum = nums[i] + nums[L] + nums[R];
					if (Math.abs((target)-sum)<Math.abs((target)-re)) {
						re = sum;
						result = sum;
					}
				}
				
			}
			
		}
		return result;

	}

	public static void main(String[] args) {
		int a[] = {0,0,0,0,0,0,0,0};
		System.out.println(threeSumClosest(a, 0));
	}
}
