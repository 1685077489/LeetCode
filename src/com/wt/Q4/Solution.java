package com.wt.Q4;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

 */
import java.util.ArrayList;
//和希尔排序最后一步的比较相似，左右互相比较就行了，只用获取一半的值
public class Solution {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int num = nums1.length + nums2.length;
		int to = num / 2 + num % 2, m = 0, n = 0;
		double re;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while (arrayList.size() <= to) {
			if (m < nums1.length && n < nums2.length) {
				if (nums1[m] <= nums2[n]) {
					arrayList.add(nums1[m]);
					m++;
				} else {
					arrayList.add(nums2[n]);
					n++;
				}
			} else if (m == nums1.length && n < nums2.length) {
				arrayList.add(nums2[n]);
				n++;
			} else if (n == nums2.length && m < nums1.length) {
				arrayList.add(nums1[m]);
				m++;
			} else if (to == 1) {
				break;
			}
		}
		if (num % 2 == 0) {
			re = (double) (arrayList.get((num / 2) - 1) + arrayList.get(num / 2)) / 2;
		} else {
			re = (double) (arrayList.get(num / 2));
		}

		return re;
	}

	public static void main(String[] args) {
		int[] a = { 1 };
		int[] b = {};
		System.out.println(findMedianSortedArrays(a, b));
	}
}
