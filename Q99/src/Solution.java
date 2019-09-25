import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Stack;

/**
 * �����������е������ڵ㱻����ؽ�����
 * ���ڲ��ı���ṹ������£��ָ��������
 * ʾ��?1:
 * ����: [1,3,null,null,2]
 * ?  1
 * ? /
 * ?3
 * ? \
 * ?  2
 * ���: [3,1,null,null,2]
 * ?  3
 * ? /
 * ?1
 * ? \
 * ?  2
 * ʾ��?2:
 * ����: [3,1,4,null,null,2]
 *   3
 *  / \
 * 1   4
 * ?  /
 * ? 2
 * ���: [2,1,4,null,null,3]
 *   2
 *  / \
 * 1   4
 * ?  /
 *  ?3
 * @author WuTong
 * @create 2019-09-05 16:36
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            list.add(temp);
            temp = temp.right;
        }
        int count =0;
        TreeNode treeNode1 = root;
        TreeNode treeNode2 = root;
        for (int i=0;i<list.size()-1;i++){
            if(list.get(i).val>list.get(i+1).val&&count==0){
                treeNode1 = list.get(i);
                count++;
            }
            if (list.get(i).val>list.get(i+1).val&&count==1){
                treeNode2 = list.get(i+1);
            }
        }
        int te = treeNode1.val;
        treeNode1.val = treeNode2.val;
        treeNode2.val =te;
    }
}
