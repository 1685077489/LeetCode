/**
 * 给定一个整数数组 nums?，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释:?连续子数组?[4,-1,2,1] 的和最大，为?6。
 * @author WuTong
 * @create 2019-09-12 8:09
 * 计算前一个能达到的最大值,再判断是否要下一个能达到的最大值
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        int[] nums2 = new int[nums.length];
        int res = nums[0];
        nums2[0]=nums[0];
        for (int i = 1;i<nums.length;i++){
            nums2[i] = Math.max(nums2[i-1]+nums[i],nums[i]);
            res = Math.max(res,nums2[i]);
        }
        return res;
    }
}
