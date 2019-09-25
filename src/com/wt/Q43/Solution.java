package com.wt.Q43;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3" 输出: "6" 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456" 输出: "56088" 说明：
 * 
 * num1 和 num2 的长度小于110。 num1 和 num2 只包含数字 0-9。 num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 
 * @author Wutong
 *
 */
/**
 * 按正儿八经的竖乘
 * @author Wutong
 *
 */
public class Solution {
	public static String multiply(String num1, String num2) {
		if (num1.length() == 0 || num2.length() == 0 || num1.equals("0") || num2.equals("")) {
			return "0";
		}
		if (num1.equals("1")) {
			return num2;
		}
		if (num2.equals("1")) {
			return num1;
		}
		int[] res = new int[num1.length()+num2.length()];
		for (int i = num1.length()-1; i >=0; i--) {
			for (int j = num2.length()-1; j >=0; j--) {
				int number1= num1.charAt(i)-'0';
				int number2= num2.charAt(j)-'0';
				res[i+j]+=(number1*number2);
				if (res[i + j] >= 10 && (i + j) != 0) {
					res[i + j - 1] += res[i + j] / 10;
					res[i + j] = res[i + j] % 10;
				}

			}
		}
		StringBuilder re = new StringBuilder();
		for (int i = 0; i <= num1.length() + num2.length() - 2; i++) {
			re.append(res[i]);
		}

		return re.toString();
	}
	public static void main(String[] args) {
		System.out.println(multiply("12", "14"));
	}
}
