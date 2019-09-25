import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
 * ����һ��������������������������
 * �ڵ��������ֻ����С�ڵ�ǰ�ڵ������
 * �ڵ��������ֻ�������ڵ�ǰ�ڵ������
 * �������������������������Ҳ�Ƕ�����������
 * ʾ��?1:
 * ����:
 * 2
 * / \
 * 1   3
 * ���: true
 * ʾ��?2:
 * <p>
 * ����:
 * 5
 * / \
 * 1   4
 * ?    / \
 * ?   3   6
 * ���: false
 * ����: ����Ϊ: [5,1,4,null,null,3,6]��
 * ?    ���ڵ��ֵΪ 5 �����������ӽڵ�ֵΪ 4 ��
 *
 * @author WuTong
 * @create 2019-09-04 17:03
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (!list.isEmpty()&&temp.val<=list.get(list.size()-1))
                return false;
            list.add(temp.val);
            temp = temp.right;
        }
        return true;
    }

}
