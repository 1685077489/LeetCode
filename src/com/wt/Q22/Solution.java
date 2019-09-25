package com.wt.Q22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static List<String> list = new ArrayList<String>();

	public static List<String> generateParenthesis(int n) {
		String string = "";

		
		total(string, 0, 0,n);
		return list;
	}

	private static void total(String string, int left, int right, int n) {
		 if (string.length() == n * 2) {
	            list.add(string);
	            return;
	        }

	        if (left < n)
	            total(string+"(", left+1, right, n);
	        if (right < left)
	            total(string+")", left, right+1, n);


	}

	public static boolean generate(String s) {
		Stack<Character> stack = new Stack<Character>();
		boolean re = true;
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty() && s.charAt(i) == ')') {
				return false;
			}
			if (s.charAt(i) == '(') {
				stack.add(s.charAt(i));
			} else if (s.charAt(i) == ')' && stack.pop() == '(') {
				continue;
			}

		}

		return re;

	}

	public static void main(String[] args) {
		 List<String> list = generateParenthesis(1);
		 for (String string : list) {
			System.out.println(string);
		}
	}
}
