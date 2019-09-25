import java.util.ArrayList;
import java.util.List;

/**
 * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������
 * �����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ�?���������������ĸ߶Ȳ�ľ���ֵ������ 1��
 * ʾ��:
 * ������������: [-10,-3,0,5,9],
 * һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @author WuTong
 * @create 2019-09-06 15:48
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i =0;i<nums.length;i++)
            list.add(nums[i]);

        return total(list);
    }

    private TreeNode total(List<Integer> list) {
        if (list.size()==0)
            return null;
        if (list.size()==1)
            return new TreeNode(list.get(0));
        int n = list.size()/2;
        TreeNode root = new TreeNode(list.get(n));
        root.left = total(list.subList(0,n));
        root.right = total(list.subList(n+1,list.size()));
        return root;
    }
}
