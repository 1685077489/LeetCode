package com.wt.Q60;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * @author WuTong
 * @create 2019-08-16 10:44
 */
/*算出所有的排列取第k个，计算量过大，不用*/
public class Solution {
    public static String getPermutation(int n, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        int count = 0;
        List<String> listString = new ArrayList<String>();
        total(n, stringBuffer, listString);
        return listString.get(k-1);
    }

    public static void total(int n, StringBuffer stringBuffer, List<String> listString) {
        if (stringBuffer.length() == n) {
            listString.add(stringBuffer.toString());
            return ;
        }
        for (int i = 1; i <= n; i++) {
            if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) == i + '0') {
                continue;
            }
            stringBuffer.append(i+"");
            total(n, stringBuffer, listString);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));
//        Arrays.sort();
    }
}
