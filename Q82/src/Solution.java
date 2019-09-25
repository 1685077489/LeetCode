/**
 * ����һ����������ɾ�����к����ظ����ֵĽڵ㣬ֻ����ԭʼ������?û���ظ�����?�����֡�
 * ʾ��?1:
 * ����: 1->2->3->3->4->4->5
 * ���: 1->2->5
 * ʾ��?2:
 * ����: 1->1->1->2->3
 * ���: 2->3
 *
 * @author WuTong
 * @create 2019-08-28 10:07
 */
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode last = res;
        ListNode temp = head;
        while (temp != null) {
            ListNode node = temp.next;
            if (node == null || temp.val != node.val) {
                last.next = temp;
                last = last.next;
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode((2));
        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
