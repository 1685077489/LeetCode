import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����ܰ����ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
 * ˵�����⼯���ܰ����ظ����Ӽ���
 * ʾ��:
 * ����: [1,2,2]
 * ���:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * @author WuTong
 * @create 2019-09-01 10:59
 */
public class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length==0)
            return res;
        Arrays.sort(nums);
        total(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void total(int[] nums, int i, List<Integer> integers, List<List<Integer>> res) {
        List<Integer> demo = new ArrayList<>(integers);
        res.add(demo);
        for (int n = i; n < nums.length; n++) {
            if (n > i && nums[n] == nums[n - 1]) {
                continue;
            }
            demo.add(nums[n]);
            total(nums, n + 1, demo, res);
            demo.remove(demo.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(4 < Math.pow(2, 2));
        int[] a1 = {1, 3, 2, 2};
        List<List<Integer>> lists = subsetsWithDup(a1);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

    }
}
