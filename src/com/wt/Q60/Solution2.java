package com.wt.Q60;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * * <p>
 * * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * * <p>
 * * "123"
 * * "132"
 * * "213"
 * * "231"
 * * "312"
 * * "321"
 * * 给定 n 和 k，返回第 k 个排列。
 * * <p>
 * * 说明：
 * * <p>
 * * 给定 n 的范围是 [1, 9]。
 * * 给定 k 的范围是[1,  n!]。
 * * 示例 1:
 * * <p>
 * * 输入: n = 3, k = 3
 * * 输出: "213"
 * * 示例 2:
 * * <p>
 * * 输入: n = 4, k = 9
 * * 输出: "2314"
 *
 * @author WuTong
 * @create 2019-08-16 15:06
 */
/*采用字典顺序进行计算*/
public class Solution2 {
    public static String getPermutation(int n, int k) {
        List<Integer> listInteger = new ArrayList<>();
        for (int i = 0;i<n;i++){
            listInteger.add(i+1);
        }
        List<String> re = new ArrayList<>();
        return total(k,listInteger,re);

    }
    public static String total(int k,List<Integer> listInteger,List<String> re){
        String res = "";
        if (k<=1){
            for (int i=0;i<listInteger.size();i++)
                re.add(listInteger.get(i)+"");
            for (String s: re) {
                res+=s;
            }
            return res;
        }
        int num = factorial(listInteger.size()-1);
        re.add(listInteger.get((k-1)/num)+"");
        listInteger.remove((k-1)/num);
        res = total(k-((k-1)/num)*num,listInteger,re);
        return res;
    }
    public static int factorial(int i){  //计算阶乘
        int res = 1;
        for(int n = i;n>0;n--){
            res = res*n;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4,7));

    }
}
