package com.wt.Q59;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author WuTong
 * @create 2019-08-16 9:50
 */
public class Solution {
    public static int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int t = 0, b = n - 1, l = 0, r = n - 1;
        int num = n * n;
        int temp = 1;
        while (num >= temp) {
            for (int i = l; i <= r; i++) {
                a[t][i] = temp;
                temp++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                a[i][r] = temp;
                temp++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                a[b][i] = temp;
                temp++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                a[i][l] = temp;
                temp++;
            }
            l++;
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(0);
        for (int[] a : ints) {
            for (Integer n : a) {
                System.out.println(n);
            }
            System.out.println("---------------------");
        }
    }
}
