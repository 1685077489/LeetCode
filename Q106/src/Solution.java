import java.util.ArrayList;
import java.util.List;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder =?[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @author WuTong
 * @create 2019-09-06 15:20
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> post = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        for (int i =0;i<postorder.length;i++)
            post.add(postorder[i]);
        for (int i =0;i<inorder.length;i++)
            in.add(inorder[i]);
        return listbuildtree(post,in);
    }

    private TreeNode listbuildtree(List<Integer> post, List<Integer> in) {
        if (post.size()==0)
            return null;
        if (post.size()==1)
            return new TreeNode(post.get(0));
        TreeNode root = new TreeNode(post.get(post.size()-1));
        List<Integer> insubList = in.subList(0, in.indexOf(post.get(post.size()-1)));
        List<Integer> postsubList = post.subList(0, insubList.size());
        List<Integer> insubList2 = in.subList(in.indexOf(post.get(post.size()-1))+1, in.size());
        List<Integer> postsubList2 = post.subList(insubList.size(), post.size()-1);
        root.left=listbuildtree(postsubList,insubList);
        root.right=listbuildtree(postsubList2,insubList2);
        return root;
    }
}
