import java.util.ArrayList;
import java.util.List;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 * @author WuTong
 * @create 2019-08-16 16:54
 */
/*动态规划*/
    /*这个动态规划的时间复杂度过高*/
public class Solution {
    public static int uniquePaths(int m, int n) {
        List<Integer> list = new ArrayList<>();
        int [][] a = new int[n][m];
        move(0,0,m,n,list);
        return list.size();
    }
    public static void move(int i,int j,int m,int n,List<Integer> list){
        if (i==n-1&&j==m-1){
            list.add(1);
            return;
        }

        if (j<m-1){
            j++;
            move(i,j,m,n,list);
            j--;
        }
        if (i<n-1){
            i++;
            move(i,j,m,n,list);
        }
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(23,12));
    }
}
