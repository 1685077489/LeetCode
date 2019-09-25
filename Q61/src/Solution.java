

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @author WuTong
 * @create 2019-08-16 16:27
 */
/*将链表连起来，再确定新的头结点*/
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k==0 || head==null)
            return head;
        ListNode temp = head;
        ListNode res = head;
        int count=1;
        while (temp.next!=null){
            count++;
            temp = temp.next;
        }
        temp.next=head;
        for (int i =0;i<count-(k%count);i++){
            res=res.next;
            temp = temp.next;
        }
        temp.next=null;
        return res;
    }
}
