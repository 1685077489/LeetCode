/**
 * ����һ���������� nums?���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 *
 * ʾ��:
 *
 * ����: [-2,1,-3,4,-1,2,1,-5,4],
 * ���: 6
 * ����:?����������?[4,-1,2,1] �ĺ����Ϊ?6��
 * @author WuTong
 * @create 2019-09-12 8:09
 * ����ǰһ���ܴﵽ�����ֵ,���ж��Ƿ�Ҫ��һ���ܴﵽ�����ֵ
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
