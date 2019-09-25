package com.wt.Q42;
/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * @author Wutong
 *
 */
/**
 * 按每一行来算容量，先算高为一的，再算高为二的，一直算到最大的，时间复杂度比较高
 * @author Wutong
 *
 */
public class Solution {
	public static int trap(int[] height) {
		int re = 0,num=0;
		for (int i = 0; i < height.length; i++) {
			num = Math.max(num, height[i]);
		}
		for (int i = 1; i <= num; i++) {
			re += select(height,i);
		}
		return re;

	}
	private static int select(int[] height, int i) {
		int min = 0,max = 0,re =0;
		for (int j = 0; j < height.length; j++) {
			if (height[j]>=i) {
				min = j;
				break;
			}
		}
		for (int j = height.length-1; j >=0; j--) {
			if (height[j]>=i) {
				max = j;
				break;
			}
		}
		if (max-min<2) {
			return 0;
		}
		for (int m = min+1; m < max; m++) {
			if (height[m] <i) {
				re++;
			}
		}
		return re;
	}

	public static void main(String[] args) {
		int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(a));

	}
}
