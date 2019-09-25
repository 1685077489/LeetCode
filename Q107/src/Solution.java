import java.util.ArrayList;
import java.util.List;

/**
 * ����һ����������������ڵ�ֵ�Ե����ϵĲ�α����� ��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
 * ���磺
 * ���������� [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * �������Ե����ϵĲ�α���Ϊ��
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @author WuTong
 * @create 2019-09-06 15:36
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
                res.add(0,new ArrayList<>());
            }
            res.get(res.size()-i).add(left.val);
            total(left.left,i+1,res);
            total(left.right,i+1,res);
        }
    }
}
