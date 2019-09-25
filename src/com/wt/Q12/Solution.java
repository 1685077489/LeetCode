package com.wt.Q12;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 
 * 字符 数值 I 1 V 5 X 10 L 50 C 100 D 500 M 1000 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12
 * 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
 * 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * 
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40和 90。  
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到
 * 3999 的范围内。
 * 
 * @author Wutong
 *
 */
public class Solution {
	//一位一位处理
	public static String intToRoman(int num) {
		String string = "";
		string = addstring(string,"M",num/1000);
		num = num%1000;
		if (num/100 == 9) {
			string = addstring(string,"CM",1);
		}else if (num/100>=5) {
			string = addstring(string,"D",num/500);
			string = addstring(string,"C",num/100-5);
		}else {
			string = addstring(string, "CD", num/400);
			string = addstring(string, "C", num%400/100);
		}
		num = num%100;
		if (num/10 == 9) {
			string = addstring(string,"XC",1);
		}else if (num/10>=5) {
			string = addstring(string,"L",num/50);
			string = addstring(string,"X",num/10-5);
		}else {
			string = addstring(string, "XL", num/40);
			string = addstring(string, "X", num%40/10);
		}
		num = num%10;
		if (num == 9) {
			string = addstring(string,"IX",1);
		}else if (num>=5) {
			string = addstring(string,"V",num/5);
			string = addstring(string,"I",num-5);
		}else {
			string = addstring(string, "IV", num/4);
			string = addstring(string, "I", num%4);
		}
		return string;
	}
	public static String addstring(String string, String string2, int i) {
		for (int j = 0; j < i; j++) {
			string+=string2;
		}
		return string;
		
	}
	public static void main(String[] args) {
		System.out.println(intToRoman(1857));
	}
}
