
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * * 示例:
 * * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * * @author WuTong
 *
 * @create 2019-08-24 9:21
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length()==0)
            return true;
        char[][] clone = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (total(i, j, 0, word, board, clone))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean total(int i, int j, int i1, String word, char[][] board, char[][] clone) {
        if (i1 == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(i1) || clone[i][j] == '1') {
            return false;
        }
        clone[i][j] = '1';
        if (total(i + 1, j, i1 + 1, word, board, clone) || total(i, j + 1, i1 + 1, word, board, clone) ||
                total(i - 1, j, i1 + 1, word, board, clone) || total(i, j - 1, i1 + 1, word, board, clone)) {
            return true;
        }
        clone[i][j] = '0';
        return false;
    }

    public static void main(String[] args) {
        boolean[][] a = new boolean[2][2];
    }
}
