import java.util.ArrayList;
import java.util.List;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点?的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
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
