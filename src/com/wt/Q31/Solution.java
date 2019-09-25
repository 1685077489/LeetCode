package com.wt.Q31;

/**
 * ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С� �������5�����ֵ�����
 * 12354��12345������12345��ǰ������12354�ں󡣰��������Ĺ涨��5�����ֵ����е���������ǰ�����12345���������� 54321��
 * <p>
 * �����������һ����������У��������������г���С�����У����������У���
 * <p>
 * ����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
 * <p>
 * ������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С� 1,2,3 �� 1,3,2 3,2,1 �� 1,2,3 1,1,5 �� 1,5,1
 *
 * @author Wutong
 */
/*
 * �ж�Ҫ������λ�ã���λ�ú������������
 */
class Solution {
    public static void nextPermutation(int[] nums) {
        if (nums.length > 1) {

            if (downsort(nums)) {// ����ǽ������У���˵��û�б����������ֵ������½����ų��������У�����С�ֵ���
                int temp;
                for (int i = 0; i < nums.length / 2; i++) {
                    temp = nums[i];
                    nums[i] = nums[nums.length - 1 - i];
                    nums[nums.length - 1 - i] = temp;
                }
            } else if (upsort(nums)) {
                int temp;
                temp = nums[nums.length - 1];
                nums[nums.length - 1] = nums[nums.length - 2];
                nums[nums.length - 2] = temp;
            } else {
                for (int i = nums.length - 1; i > 0; i--) {
                    if (nums[i] > nums[i - 1]) {
                        for (int j = i; j < nums.length; j++) {
                            if (nums[i - 1] >= nums[j]) {
                                int temp;
                                temp = nums[j - 1];
                                nums[j - 1] = nums[i - 1];
                                nums[i - 1] = temp;
                                break;
                            } else if (j == nums.length - 1) {
                                int temp;
                                temp = nums[j];
                                nums[j] = nums[i - 1];
                                nums[i - 1] = temp;
                                break;
                            }
                        }
                        quickSort(nums, i, nums.length - 1);
                        break;
                    }
                }
            }
        }

    }

    private static boolean upsort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        // temp���ǻ�׼λ
        temp = arr[low];

        while (i < j) {
            // �ȿ��ұߣ���������ݼ�
            while (temp <= arr[j] && i < j) {
                j--;
            }
            // �ٿ���ߣ��������ҵ���
            while (temp >= arr[i] && i < j) {
                i++;
            }
            // ������������򽻻�
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        // ��󽫻�׼Ϊ��i��j���λ�õ����ֽ���
        arr[low] = arr[i];
        arr[i] = temp;
        // �ݹ�����������
        quickSort(arr, low, j - 1);
        // �ݹ�����Ұ�����
        quickSort(arr, j + 1, high);
    }

    public static boolean downsort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 3};
//	        quickSort(arr, 2, arr.length-1);
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

    }
}