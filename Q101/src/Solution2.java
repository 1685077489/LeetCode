import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树?[1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个?[1,2,2,null,3,null,3] 则不是镜像对称的:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *
 * @author WuTong
 * @create 2019-09-06 8:37
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        return total(root.left, root.right);
    }

    private boolean total(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val != right.val)
                return false;
            return total(left.left, right.right) && total(left.right, right.left);
        }
        if (left==null&&right==null)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(null);
        stack.add(3);
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        Integer integer = stack.pop();
        Integer integer2 = stack.pop();
        System.out.println(integer == integer2);

    }
}
