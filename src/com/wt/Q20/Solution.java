package com.wt.Q20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()" 输出: true 示例 2:
 * 
 * 输入: "()[]{}" 输出: true 示例 3:
 * 
 * 输入: "(]" 输出: false 示例 4:
 * 
 * 输入: "([)]" 输出: false 示例 5:
 * 
 * 输入: "{[]}" 输出: true
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static boolean isValid(String s) {
		if (s.length()==0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put(')', '(');
		map.put('{', '}');
		map.put('}', '{');
		map.put('[', ']');
		map.put(']', '[');
		for (int i = s.length()-1; i>=0; i--) {
			if (stack.isEmpty()) {
				stack.add(s.charAt(i));
			}else {
				Character character = stack.pop();
				if (s.charAt(i)!=map.get(character)) {
					stack.add(character);
					stack.add(s.charAt(i));
				}
			}
			
		}
		return stack.isEmpty();
		

	}
	public static void main(String[] args) {
		System.out.println(isValid("([)]"));
	}
}
