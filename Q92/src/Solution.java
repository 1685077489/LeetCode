import java.security.Key;

/**
 * ��ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��
 * ˵��:
 * 1 ��?m?��?n?�� �����ȡ�
 * ʾ��:
 * ����: 1->2->3->4->5->NULL, m = 2, n = 4
 * ���: 1->4->3->2->5->NULL
 *
 * @author WuTong
 * @create 2019-09-02 10:13
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode temp = head;
        ListNode key = head;
        ListNode key2 = head;
        ListNode begin = new ListNode(1);
        ListNode end = new ListNode(1);
        begin.next = temp;
        for (int i = 1; i <= n; i++) {
            if (i == m - 1) {
                begin = temp;
            }
            if (i == m) {
                key = temp;
                temp = temp.next;
                key.next = null;
                end = key;
                continue;
            }
            if (i > m) {
                key2 = temp;
                temp = temp.next;
                key2.next = key;
                key = key2;
                continue;
            }
            temp = temp.next;
        }
        begin.next = key;
        end.next = temp;
        return m == 1 ? begin.next : head;
    }
}
