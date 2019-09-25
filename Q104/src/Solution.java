/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明:?叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度?3 。
 *
 * @author WuTong
 * @create 2019-09-06 10:55
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(total(root.left, 1), total(root.right, 1));

    }

    private int total(TreeNode treeNode, int i) {
        if (treeNode==null)
            return i+0;
        return Math.max(total(treeNode.left, i+1), total(treeNode.right, i+1));
    }
}
