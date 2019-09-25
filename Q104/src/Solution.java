/**
 * ����һ�����������ҳ��������ȡ�
 * �����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * ʾ����
 * ���������� [3,9,20,null,null,15,7]��
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * ��������������?3 ��
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
