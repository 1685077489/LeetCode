import java.util.ArrayList;
import java.util.List;

/**
 * ����һ����������������ڵ�ֵ�ľ���β�α����������ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У���
 * ���磺
 * ����������?[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ���ؾ���β�α������£�
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @author WuTong
 * @create 2019-09-06 10:42
 * �������,�Բ����ж���˳����뻹�ǵ������
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (i%2==0)
                res.get(i-1).add(0,left.val);
            else
                res.get(i-1).add(left.val);
            total(left.left,i+1,res);
            total(left.right,i+1,res);
        }
    }
}
