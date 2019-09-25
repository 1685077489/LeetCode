import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树?[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @author WuTong
 * @create 2019-09-06 10:42
 * 按层插入,以层数判断是顺序插入还是倒序插入
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
