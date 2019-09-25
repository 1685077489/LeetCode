import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;

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
 * ��ջ�����ж�
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        TreeNode t = root;
        list.add(root);
        while (!list.isEmpty()) {
            t = list.get(0);
            if (t != null) {
                list.add(t.left);
                list.add(t.right);
            }
            if (stack.size()<2) {
                if (t != null)
                    stack.add(t.val);
                else
                    stack.add(null);
            } else {
                Integer num = stack.pop();
                if (t!=null){
                    if (num!=t.val){
                        stack.add(num);
                        stack.add(t.val);
                    }
                }else {
                    if (num!=null){
                        stack.add(num);
                        stack.add(t.val);
                    }
                }
            }
            list.remove(0);
        }
        if (stack.size() == 1)
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
