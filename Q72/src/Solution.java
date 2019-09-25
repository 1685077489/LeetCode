/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * @author WuTong
 * @create 2019-08-22 8:56
 * 动态规划，和求路径相似，求前面的，来推导出后面的
 */
public class Solution {
    public static int minDistance(String word1, String word2) {
        int a[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            a[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            a[0][i] = i;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    a[i][j] = 1 + Math.min(Math.min(a[i - 1][j], a[i][j - 1]), a[i - 1][j - 1] - 1);
                }else {
                    a[i][j] = 1 + Math.min(Math.min(a[i - 1][j], a[i][j - 1]), a[i - 1][j - 1]);
                }
            }
        }
        return a[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("","1"));
    }
}
