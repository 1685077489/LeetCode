/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * @author WuTong
 * @create 2019-08-22 9:57
 */
public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 ||matrix[0].length==0)
            return false;
        int i = 0;
        if (target > matrix[matrix.length - 1][matrix[0].length - 1] || target < matrix[0][0])
            return false;
        /*二分搜索行*/
        int left = 0, right = matrix.length - 1;
        while (right > left) {
            if (matrix[left][matrix[0].length - 1] == target || matrix[right][matrix[0].length - 1] == target)
                return true;
            int mid = (left + right) / 2;
            if (matrix[mid][matrix[0].length - 1] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
            i = right;
        }
        /*二分搜索列*/
        left = 0;
        right = matrix[0].length - 1;
        if (matrix[i][left] == target || matrix[i][right] == target)
            return true;
        while (right > left) {
            if (matrix[i][left] == target || matrix[i][right] == target)
                return true;
            int mid = (left + right) / 2;
            if (matrix[i][mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[][] = {{1}};
        System.out.println(searchMatrix(a,1));
    }
}
