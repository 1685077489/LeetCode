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
 * @create 2019-09-06 10:29
 * �������
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null)
            return res;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        res.add(list);
        total(root.left,2,res);
        total(root.right,2,res);
        return res;
    }

    private void total(TreeNode left, int i, List<List<Integer>> res) {
        if (left!=null){
            if (res.size()<i){
                res.add(new ArrayList<>());
            }
            res.get(i-1).add(left.val);
            total(left.left,i+1,res);
            total(left.right,i+1,res);
        }
    }
}
