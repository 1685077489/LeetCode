import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ǰ�������������������������
 * ע��:
 * ����Լ�������û���ظ���Ԫ�ء�
 * ���磬����
 * ǰ����� preorder =?[3,9,20,15,7]
 * ������� inorder = [9,3,15,20,7]
 * �������µĶ�������
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @author WuTong
 * @create 2019-09-06 11:04
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        for (int i =0;i<preorder.length;i++)
            pre.add(preorder[i]);
        for (int i =0;i<inorder.length;i++)
            in.add(inorder[i]);
        return listbuildtree(pre,in);
    }

    private TreeNode listbuildtree(List<Integer> pre, List<Integer> in) {
        if (pre.size()==0)
            return null;
        if (pre.size()==1)
            return new TreeNode(pre.get(0));
        TreeNode root = new TreeNode(pre.get(0));
        List<Integer> insubList = in.subList(0, in.indexOf(pre.get(0)));
        List<Integer> presubList = pre.subList(1, 1+insubList.size());
        List<Integer> insubList2 = in.subList(in.indexOf(pre.get(0))+1, in.size());
        List<Integer> presubList2 = pre.subList(1+insubList.size(), pre.size());
        root.left=listbuildtree(presubList,insubList);
        root.right=listbuildtree(presubList2,insubList2);
        return root;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i =0;i<4;i++)
            list.add(i+1);
        System.out.println(list.indexOf(3));
    }
}
