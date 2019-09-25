package com.wt.Q54;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 输出: [1,2,3,6,9,8,7,4,5] 示例 2:
 * 
 * 输入: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] 输出:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * @author Wutong
 *
 */
/*一圈一圈的插入*/
public class Solution {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length/2+matrix.length%2; i++) {
			add(i, i, matrix, res);
		}
		return res;

	}

	public static void add(int xbegin, int ybegin, int[][] matrix, List<Integer> res) {
		int height = matrix.length;
		int length = matrix[0].length;
		int j = ybegin, i = xbegin;
//		while (res.size() < height * length) {
			for (; j < length - ybegin; j++) {
				res.add(matrix[i][j]);
			}
			if (res.size() == height * length) {
				return;
			}
			j--;
			for (i++; i < height - xbegin; i++) {
				res.add(matrix[i][j]);
			}
			if (res.size() == height * length) {
				return;
			}
			i--;
			for (j--; j >= ybegin; j--) {
				res.add(matrix[i][j]);
			}
			if (res.size() == height * length) {
				return;
			}
			j++;
			for (i--; i > xbegin; i--) {
				res.add(matrix[i][j]);
			}
		

	}
	public static void main(String[] args) {
		int [][] a = {{1,2,3,4}};
		List<Integer> spiralOrder = spiralOrder(a);
		System.out.println(spiralOrder.toString());
	}
}
