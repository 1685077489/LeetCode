import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ����һ����������������Ƿ��Ǿ���ԳƵġ�
 * ���磬������?[1,2,2,3,4,4,3] �ǶԳƵġ�
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * �����������?[1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:
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
