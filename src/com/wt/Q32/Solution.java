package com.wt.Q32;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()" 输出: 2 解释: 最长有效括号子串为 "()" 示例 2:
 * 
 * 输入: ")()())" 输出: 4 解释: 最长有效括号子串为 "()()"
 * 
 * @author Wutong
 *
 */
/**
 * 通过栈来判断括号的正确性，将正确的弹出栈，通过错误的来判断有效子串的长度
 * @author Wutong
 *
 */
public class Solution {
	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.add(i);
			}
			if (s.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					int m = stack.pop();
					if (s.charAt(m) == ')') {
						stack.add(m);
						stack.add(i);
					}
				} else {
					stack.add(i);
				}
			}
		}
		for (Integer integer : stack) {
			System.out.println(integer);
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(s.length());
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		list.add(0);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		int re = 0;
		for (int i = 0; i <list.size() - 1; i++) {
			re = Math.max(re, ((list.get(i) - list.get(i + 1)) / 2) * 2);
		}
		return re;

	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()((())()"));
	}
}
