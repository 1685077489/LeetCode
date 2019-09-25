
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ�����������Σ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * ʾ��?1:
 * ���� nums = [1,1,1,2,2,3],
 * ����Ӧ�����³��� length = 5, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 1, 1, 2, 2, 3 ��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ʾ��?2:
 * ���� nums = [0,0,1,1,1,1,2,3,3],
 * ����Ӧ�����³��� length = 7, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ?0, 0, 1, 1, 2, 3, 3 ��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 *
 * @author WuTong
 * @create 2019-08-24 10:52
 */
public class Solution {
    public static int removeDuplicates(int[] nums) {
        int i = 0, j, size = nums.length - 2, temp, num1, num2;
        for (; i < size; i++) {
            j = i + 2;
            if (nums[i] == nums[j]) {
                for (; j < nums.length - 1; j++) {
                    if (nums[j] == nums[j + 1]) {
                        continue;
                    }
                    break;
                }
                if (j==nums.length-1)
                    return i+2;
                num1 = i;
                num2 = j;
                for (; num2 < nums.length-1; num2++) {
                    temp = nums[num1 + 2];
                    nums[num1 + 2] = nums[num2+1];
                    nums[num2+1] = temp;
                    num1++;
                }
                size -= (j - i - 1);
            }
        }
        return size + 2;
    }

    public static void main(String[] args) {
        int[] a = {0,0,0,0,1,2,2,2};
        System.out.println(removeDuplicates(a));

    }
}
