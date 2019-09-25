
import java.util.ArrayList;
import java.util.List;

/**
 * ����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
 * * ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
 * * ʾ��:
 * * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * * ���� word = "ABCCED", ���� true.
 * ���� word = "SEE", ���� true.
 * ���� word = "ABCB", ���� false.
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
