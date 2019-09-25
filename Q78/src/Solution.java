import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author WuTong
 * @create 2019-08-23 16:21
 */
public class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<int[]> list = new ArrayList<>();
        int[] t = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            t[i] = 1;
            total(t.clone(), list);
        }
        list.add(new int[nums.length]);
        return result(list, nums);
    }

    private static List<List<Integer>> result(List<int[]> list, int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] ints : list) {
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 0)
                    list1.add(nums[i]);
            }
            res.add(list1);
        }
        return res;
    }

    private static void total(int[] t, List<int[]> list) {
        int[] clone = t.clone();
        list.add(clone);
        for (int i = t.length - 1; i > 0; i--) {
            if (t[i] > t[i - 1]) {
                int temp = t[i];
                t[i] = t[i - 1];
                t[i - 1] = temp;
                Arrays.sort(t, i, t.length);
                clone = t.clone();
                list.add(clone);
                i = t.length ;
                continue;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            String s ="";
            for (Integer integer : subset) {
                s+=integer;
            }
            System.out.println(s);

        }

    }
}
