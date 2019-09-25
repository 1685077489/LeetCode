import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序?遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,3,2]
 * 进阶:?递归算法很简单，你可以通过迭代算法完成吗？
 * @author WuTong
 * @create 2019-09-03 8:30
 * 递归:左中右
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root==null)
            return list;
        total(root,list);
        return list;
    }

    private void total(TreeNode root, List<Integer> list) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if (root.left!=null){
            total(root.left,left);
        }
        if (root.right!=null){
            total(root.right,right);
        }
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.addAll(list2);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println(list.size());


    }
}
