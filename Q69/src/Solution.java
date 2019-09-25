/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * @author WuTong
 * @create 2019-08-21 14:57
 * 二分法
 */
public class Solution {
    public static int mySqrt(int x) {
        int left = 1;
        int right = x;
        while ((left+1) < right) {
            int mid = (left + right) / 2;
            int num = mid * mid;
            if (num > x) {
                right = mid ;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

}
