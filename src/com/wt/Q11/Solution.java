package com.wt.Q11;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
/**
 * 暴力法，寻找比I大的且离I最远的J，计算其值，遍历所有I
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static int maxArea(int[] height) {

		int re = 0;
		for (int i = 0; i < height.length; i++) {
			int k = 0;
			for (int j = 0; j < height.length; j++) {
				if (height[j] >= height[i]) {
					k = Math.max(k, Math.abs(i - j));
				}
			}
			re = Math.max(re, height[i] * k);

		}

		return re;

	}

	public static void main(String[] args) {
		int a[] = { 1, 8, 6, 2, 5, 4, 8, 3, 8 };
		System.out.println(maxArea(a));
	}

}
