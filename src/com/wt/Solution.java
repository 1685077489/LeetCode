package com.wt;
/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 * @author Wutong
 *
 */
public class Solution {
	public static int[] twoSum(int[] nums, int target) {
		int[] s = new int[2] ;
		int i,j,num;
		for (i = 0; i < nums.length; i++) {
			num = target-nums[i];
			for (j = i+1; j < nums.length; j++) {
				if (nums[j] == num) {
					s[0] = i;
					s[1] = j;
				}
			}
		}
		return s;
	}
	public static void main(String[] args) {
		int[] a = {2,7,11,15};
		int[] b = twoSum(a, 18);
		for (int i : b) {
			System.out.println(i);
		}
	}
}
