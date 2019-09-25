

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 * @author WuTong
 * @create 2019-08-17 9:36
 */
/*动态规划:算到这一个点的前面两个点有几种解法，再相加*/
public class Solution2 {
    public static int uniquePaths(int m, int n) {
        int[][] a = new int[m][n];
        for (int i =0 ;i<m;i++) a[i][0]=1;
        for (int i =0;i<n;i++) a[0][i] =1;
        for (int i =1;i< m;i++)
            for (int j =1;j<n;j++)
                a[i][j] = a[i-1][j]+a[i][j-1];
        return a[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(23,12));
    }
}
