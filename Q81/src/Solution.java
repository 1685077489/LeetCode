import java.util.Arrays;

/**
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * ( ���磬����?[0,0,1,2,2,5,6]?���ܱ�Ϊ?[2,5,6,0,0,1,2]?)��
 * ��дһ���������жϸ�����Ŀ��ֵ�Ƿ�����������С������ڷ���?true�����򷵻�?false��
 * ʾ��?1:
 * ����: nums = [2,5,6,0,0,1,2], target = 0
 * ���: true
 * ʾ��?2:
 * ����: nums = [2,5,6,0,0,1,2], target = 3
 * ���: false
 *
 * @author WuTong
 * @create 2019-08-27 16:49
 */
public class Solution {
    public static boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        if (nums.length == 1)
            return nums[0] == target;
        int num = 0;
        int tem = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                num = i + 1;
                tem = 1;
                break;
            }
        }
        if (tem == 0)
            return searchtotal(nums, target);
        if (target < nums[num] || target > nums[num - 1])
            return false;
        int[] right = Arrays.copyOfRange(nums, num, nums.length);
        int[] left = Arrays.copyOf(nums, num);
        if (target < nums[0])
            return searchtotal(right, target);
        return searchtotal(left, target);
    }

    private static boolean searchtotal(int[] right, int target) {
        if (right.length == 0)
            return false;
        if (right.length == 1)
            return right[0] == target;
        if (target == right[0] || target == right[right.length - 1])
            return true;
        int num = right.length / 2;
        if (right[num] == target)
            return true;
        if (right[num] > target)
            return searchtotal(Arrays.copyOf(right, num), target);
        return searchtotal(Arrays.copyOfRange(right, num, right.length), target);
    }

    public static void main(String[] args) {
        int[] a = {3, 1};
        System.out.println(search(a, 3));
    }
}
