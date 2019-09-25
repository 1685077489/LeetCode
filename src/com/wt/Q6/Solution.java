package com.wt.Q6;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L C I R E T O E S I I G E D H N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 
 * @author Wutong
 *
 */
//将字符串变为二元数组，横着读取二元数组
public class Solution {
	public static String convert(String s, int numRows) {
		if (numRows <= 1) {
			return s;
		}
		int num = (s.length() / ((numRows - 1) * 2)) * (numRows - 1) + s.length() % ((numRows - 1) * 2);
		Character a[][] = new Character[num][numRows];
		for (int i = 0, m = 0; i < s.length(); i++) {
			if (i % ((numRows - 1) * 2) < numRows) {
				m = (i / ((numRows - 1) * 2)) * (numRows - 1);
				a[m][i % ((numRows - 1) * 2)] = s.charAt(i);

			} else {

				a[++m][(numRows - 1) * 2 - i % (2 * (numRows - 1))] = s.charAt(i);
			}
		}
		String string = "";
		for (int j1 = 0; j1 < numRows; j1++) {
			for (int k = 0; k < num; k++) {
				try {
					if (!a[k][j1].equals(null)) 
						string += a[k][j1];
					
				} catch (Exception e) {
				}

			}
		}
		return string;

	}

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 2));
	}
}
