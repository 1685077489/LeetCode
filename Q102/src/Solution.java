import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���������������䰴��α����Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
 * ����:
 * ����������:?[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * �������α��������
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author WuTong
 * @create 2019-09-06 9:24
 * ʱ�临�Ӷ��е��
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null)
            return res;
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> total = new ArrayList<>();
        TreeNode t = root;
        int count = 1;
        list.add(root);
        while (count != 0) {
            t = list.get(0);
            if (t == null) {
                list.add(null);
                list.add(null);
                total.add(t);
                list.remove(0);
                continue;
            }
            if (t.left != null)
                count++;
            if (t.right != null)
                count++;
            list.add(t.left);
            list.add(t.right);
            total.add(t);
            list.remove(0);
            count--;
        }
        int i = 0;
        int i1 = 0;
        while (i < total.size()) {
            List<Integer> de = new ArrayList<>();
            int tem = res.size();
            double pow = Math.pow(2, tem);
            i1 += (new Double(pow)).intValue();
            for (; i < i1; i++) {
                if (i < total.size() && total.get(i) != null)
                    de.add(total.get(i).val);
            }
            res.add(de);
        }
        return res;
    }
}
