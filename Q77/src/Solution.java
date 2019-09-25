import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author WuTong
 * @create 2019-08-23 15:34
 * 动态规划
 * 也可按照字典顺序来计算以4,2 为例
 *      4   3   2   1               4   3   2   1
 *      0   0   1   1               0   1   0   1
 */
public class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        List<Integer> result = new ArrayList<>();
        change(list, result, res, k, 0);
        return res;
    }

    private static void change(List<Integer> list, List<Integer> result, List<List<Integer>> res, int k, int n) {
        List<Integer> demo2 = new ArrayList<>(result);
        if (demo2.size() == k) {
            res.add(demo2);
            return;
        }
        for (int i = n; i < list.size(); i++) {
            int temp = list.get(i);
            demo2.add(temp);
            change(list, demo2, res, k, i+1);
            demo2.remove(demo2.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(3, 2);
        for (List<Integer> list : combine) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
            System.out.println("-----------");
        }

    }
}
