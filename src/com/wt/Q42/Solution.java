package com.wt.Q42;
/**
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 * 
 * @author Wutong
 *
 */
/**
 * ��ÿһ�����������������Ϊһ�ģ������Ϊ���ģ�һֱ�㵽���ģ�ʱ�临�ӶȱȽϸ�
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
