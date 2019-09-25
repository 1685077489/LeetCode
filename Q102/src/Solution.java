import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树:?[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author WuTong
 * @create 2019-09-06 9:24
 * 时间复杂度有点高
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
