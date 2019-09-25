import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
 * @create 2019-09-03 8:51
 * 迭代:栈
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
