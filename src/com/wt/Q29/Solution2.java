package com.wt.Q29;

/**
 * ¶þ·Ö·¨
 * 
 * @author Wutong
 *
 */
public class Solution2 {
	public static int divide(int dividend, int divisor) {
		long l = dividend;
		long r = divisor;
		long l1 = Math.abs(l);
		long r1 = Math.abs(r);
		long i = 1, j = r1, re = 0;
		if (r == 1) {
			return dividend;
		}
		if (r==-1) {
			if (dividend>=0) {
				return 0- dividend;
			}else if (l1>Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			return (int) (0-l);
		}
		
		while (l1 >= r1) {
			if (l1<j+j) {
				re += i;
				break;
			}
			j += j;
			i += i;
			if (l1 - j < j) {

				l1 = l1 - j;
				j = r1;
				re += i;
				i = 1;
			}
			
		}
		if (dividend>0&&divisor<0 || dividend<0&&divisor>0) {
			return (int) (0-re);
		}
		return (int) re;

	}

	public static void main(String[] args) {
		System.out.println(divide(Integer.MAX_VALUE, 1));

	}
}
