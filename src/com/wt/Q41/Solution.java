package com.wt.Q41;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0] 输出: 3 示例 2:
 * 
 * 输入: [3,4,-1,1] 输出: 2 示例 3:
 * 
 * 输入: [7,8,9,11,12] 输出: 1 说明:
 * 
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static int firstMissingPositive(int[] nums) {
		if (nums.length==0) {
			return 1;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]>0) {
				nums = Arrays.copyOfRange(nums, i, nums.length);
				break;
			}
		}
		
		if (nums[0]>1 || nums[nums.length-1]<=0) {
			return 1;
		}
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i]+1<nums[i+1]) {
				return nums[i]+1;
			}
		}
		return nums[nums.length-1]+1;
	}
	public static void main(String[] args) {
		int a[] = {-1,-3,-4,-4};
		System.out.println(firstMissingPositive(a));
	}
}
