/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * @author WuTong
 * @create 2019-08-28 14:58
 */
public class Solution {
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i =0;i<heights.length;i++){
            int leftnum =0;
            int rightnum =0;
            for (int left = i;left>=0;left--){
                if (heights[left]<heights[i]){
                    break;
                }
                leftnum ++;
            }
            for (int right = i;right<heights.length;right++){
                if (heights[right]<heights[i]){
                    break;
                }
                rightnum ++;
            }
            res = Math.max(res,heights[i]*(leftnum+rightnum-1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(a));
    }
}
