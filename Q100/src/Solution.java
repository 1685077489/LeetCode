import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例?1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *         [1,2,3],   [1,2,3]
 * 输出: true
 * 示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *         [1,2],     [1,null,2]
 * 输出: false
 * 示例?3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *         [1,2,1],   [1,1,2]
 * 输出: false
 * @author WuTong
 * @create 2019-09-05 16:57
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        list1.add(p);
        list2.add(q);
        TreeNode temp =p;
        TreeNode temp2 =q;
        while (!list1.isEmpty()&&!list2.isEmpty()){
            temp=list1.get(0);
            temp2=list2.get(0);
            if (temp==null&&temp2==null){
                list1.remove(0);
                list2.remove(0);
            }
            if (temp!=null&&temp2!=null){
                if (temp.val!=temp2.val)
                    return false;
                list1.add(temp.left);
                list1.add(temp.right);
                list2.add(temp.left);
                list2.add(temp.right);
                list1.remove(0);
                list2.remove(0);
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(null);
        list.add(2);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println(list.get(1)==list.get(2));

    }
}
