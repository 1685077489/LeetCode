/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例?1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例?2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
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
