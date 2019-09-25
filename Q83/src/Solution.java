/**
 * ����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
 * ʾ��?1:
 * ����: 1->1->2
 * ���: 1->2
 * ʾ��?2:
 * ����: 1->1->2->3->3
 * ���: 1->2->3
 *
 * @author WuTong
 * @create 2019-08-28 14:35
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode last = res;
        ListNode temp = head;
        while (temp != null) {
            last.next = temp;
            last = last.next;
            ListNode node = temp.next;
            if (node == null || temp.val != node.val) {
                temp = node;
                continue;
            }
            if (temp.val == node.val) {
                while (node != null && node.val == temp.val)
                    node = node.next;
                temp = node;
            }
        }
        last.next = temp;
        return res.next;
    }
}
