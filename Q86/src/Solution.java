/**
 * ����һ�������һ���ض�ֵ x����������зָ���ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ��
 * ��Ӧ����������������ÿ���ڵ�ĳ�ʼ���λ�á�
 * ʾ��:
 * ����: head = 1->4->3->2->5->2, x = 3
 * ���: 1->2->2->4->3->5
 *
 * @author WuTong
 * @create 2019-08-29 10:04
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode l = left;
        ListNode r = right;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }
        r.next = head;
        l.next = right.next;
        return left.next;

    }

    public static void main(String[] args) {
//        int[] a = {1, 4, 3, 2, 5, 2};
//        ListNode head = new ListNode(a[0]);
//        ListNode temp = head;
//        for (int i = 1; i < a.length; i++) {
//            temp.next = new ListNode(a[i]);
//            temp = temp.next;
//        }
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
        float n ;
        n =(float) 4/2;
        System.out.println(n);
        System.out.print(n);
        System.out.print(n);
        System.out.print(n);

    }
}
