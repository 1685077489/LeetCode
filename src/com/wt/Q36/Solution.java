package com.wt.Q36;

import java.util.HashMap;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 
 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * @author Wutong
 *
 */
/*
 * 遍历判断
 */
public class Solution {
	public static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!map.containsKey(board[i][j])) {
						map.put(board[i][j], j);
					} else {
						return false;
					}
				}
			}
		}
		for (int j = 0; j < 9; j++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (!map.containsKey(board[i][j])) {
						map.put(board[i][j], j);
					} else {
						return false;
					}
				}
			}
		}
		int num = 0, l = 0, r = 0;
		while (num < 81) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = r; i < r + 3; i++) {
				for (int j = l; j < l + 3; j++) {
					if (board[i][j] != '.') {
						if (!map.containsKey(board[i][j])) {
							map.put(board[i][j], j);
						} else {
							return false;
						}
					}
					num++;
				}
			}
			r += 3;
			if (r >6) {
				r = 0;
				l += 3;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = { { '.', '.', '.', '.', '.', '.', '5', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '9', '3', '.', '.', '2', '.', '4', '.', '.' }, { '.', '.', '7', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '3', '4', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '3', '.', '.', '.' }, { '.', '.', '.', '.', '.', '5', '2', '.', '.' } };

		System.out.println(isValidSudoku(board));
	}
}
