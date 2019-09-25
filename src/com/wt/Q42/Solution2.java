package com.wt.Q42;
/**
 * 计算每一个位置的左右最高的值，该位置的水就是左右最高值之中的最小值
 * @author Wutong
 *
 */
public class Solution2 {
	public static int trap(int[] height) {
		int re = 0,left=0;
		int[] right = new int[height.length];
		for (int i = height.length-2; i>0; i--) {
			right[i] = Math.max(height[i+1], right[i+1]);
		}
		for (int i = 1; i < height.length - 1; i++) {
	        left = Math.max(left, height[i - 1]);
	        int min = Math.min(left, right[i]);
	        if (min > height[i]) {
	            re = re + (min - height[i]);
	        }
	    }

		return re;

	}

	public static void main(String[] args) {
		int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(a));

	}
	
}
