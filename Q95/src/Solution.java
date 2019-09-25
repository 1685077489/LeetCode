import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ...?n 为节点所组成的二叉搜索树。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * ? [1,null,3,2],
 * ? [3,2,null,1],
 * ? [3,1,null,null,2],
 * ? [2,1,3],
 * ? [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @author WuTong
 * @create 2019-09-03 9:06
 */
public class Solution {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n==0)
            return res;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i + 1);
        if (list.size() == 1) {
            res.add(new TreeNode(list.get(0)));
            return res;
        }
        for (int i = 0; i < list.size(); i++) {
            List<TreeNode> left = alltree(list.subList(0, i));
            List<TreeNode> right = alltree(list.subList(i + 1, list.size()));
            if (left.size()==0){
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(list.get(i));
                    root.right = r;
                    res.add(root);
                }
            }
            if (right.size()==0){
                for (TreeNode l : left) {
                    TreeNode root = new TreeNode(list.get(i));
                    root.left = l;
                    res.add(root);
                }
            }
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(list.get(i));
                    root.right = r;
                    root.left = l;
                    res.add(root);
                }
            }
        }
        return res;
    }

    private static List<TreeNode> alltree(List<Integer> list) {
        List<TreeNode> res = new ArrayList<>();
        if (list.size() == 1) {
            res.add(new TreeNode(list.get(0)));
            return res;
        }
        for (int i = 0; i < list.size(); i++) {
            List<TreeNode> left = alltree(list.subList(0, i));
            List<TreeNode> right = alltree(list.subList(i + 1, list.size()));
            if (left.size()==0){
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(list.get(i));
                    root.right = r;
                    res.add(root);
                }
            }
            if (right.size()==0){
                for (TreeNode l : left) {
                    TreeNode root = new TreeNode(list.get(i));
                    root.left = l;
                    res.add(root);
                }
            }
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(list.get(i));
                    root.right = r;
                    root.left = l;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(4);
        System.out.println(treeNodes.size());


    }
}
