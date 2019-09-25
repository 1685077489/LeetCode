import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ����һ����������������������?������
 * ʾ��:
 * ����: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * ���: [1,3,2]
 * ����:?�ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
 * @author WuTong
 * @create 2019-09-03 8:51
 * ����:ջ
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp!=null||!stack.isEmpty()){
            while (temp!=null){
                stack.push(temp);
                temp =temp.left;
            }
            temp = stack.pop();
            list.add(temp.val);
            temp=temp.right;
        }
        return list;
    }
}
