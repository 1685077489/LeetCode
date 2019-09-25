package com.wt.Q31;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 例如对于5个数字的排列
 * 12354和12345，排列12345在前，排列12354在后。按照这样的规定，5个数字的所有的排列中最前面的是12345，最后面的是 54321。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 *
 * @author Wutong
 */
/*
 * 判断要交换的位置，将位置后的所有数排序
 */
class Solution {
    public static void nextPermutation(int[] nums) {
        if (nums.length > 1) {

            if (downsort(nums)) {// 如果是降序排列，这说明没有比这个更大的字典序，重新将其排成升序排列（既最小字典序）
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
        // temp就是基准位
        temp = arr[low];

        while (i < j) {
            // 先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            // 再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            // 如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        // 最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        // 递归调用左半数组
        quickSort(arr, low, j - 1);
        // 递归调用右半数组
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