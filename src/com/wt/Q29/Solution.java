package com.wt.Q29;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3 输出: 3 示例 2:
 * 
 * 输入: dividend = 7, divisor = -3 输出: -2 说明:
 * 
 * 被除数和除数均为 32 位有符号整数。 除数不为 0。 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 −
 * 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * 
 * 
 * 
 * 
 * @author Wutong
 * 
 */
/**
 * 暴力法
 * @author Wutong
 *
 */
public class Solution {
	public static int divide(int dividend, int divisor) {
		int dividend1 = Math.abs(dividend);
		int count = 0;
		if (dividend1 == dividend && dividend < 0) {
			if (divisor == 1) {
				return Integer.MIN_VALUE;
			}
			if (divisor == -1) {
				return Integer.MAX_VALUE;
			}
			dividend1 = Math.abs(dividend + 1);
			count++;

		}
		int divisor1 = Math.abs(divisor);
		if (divisor1 == divisor && divisor < 0) {
			if (dividend == Integer.MIN_VALUE) {
				return 1;
			} else {
				return 0;
			}

		}
		int i = -1;
		if (divisor1 == 1) {
			i = dividend1;
		} else {
			while (dividend1 >= 0) {
				dividend1 -= divisor1;
				dividend1 += count;
				count = 0;
				i++;
			}
		}

		if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
			return 0 - i;
		}
		return i;

	}

	public static void main(String[] args) {
		System.out.println(divide(Integer.MAX_VALUE, 1));

	}
}
