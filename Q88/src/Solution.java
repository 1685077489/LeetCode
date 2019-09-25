/**
 * ��������������������?nums1 �� nums2���� nums2 �ϲ���?nums1?�У�ʹ��?num1 ��Ϊһ���������顣
 * ˵��:
 * ��ʼ��?nums1 �� nums2 ��Ԫ�������ֱ�Ϊ?m �� n��
 * ����Լ���?nums1?���㹻�Ŀռ䣨�ռ��С���ڻ����?m + n�������� nums2 �е�Ԫ�ء�
 * ʾ��:
 * ����:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * ���:?[1,2,2,3,5,6]
 *
 * @author WuTong
 * @create 2019-09-01 9:34
 */
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                m++;
                for (int x = nums1.length-1;x>i;x--){
                    nums1[x] = nums1[x-1];
                }
                nums1[i] = nums2[j];
                j++;
            }
            i++;
        }
        while (j < n) {
            nums1[m] = nums2[j];
            m++;
            j++;
        }
    }

    public static void main(String[] args) {
        int []a ={1,2,7,0,0,0};
        int []b ={2,5,6};
        merge(a,3,b,3);
        for (int i : a) {
            System.out.println(i);
        }


    }
}
