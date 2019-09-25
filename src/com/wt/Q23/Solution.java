package com.wt.Q23;




import com.wt.Q23.ListNode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入: [   1->4->5,   1->3->4,   2->6 ] 输出: 1->1->2->3->4->4->5->6
 * 
 * @author Wutong
 *
 */
public class Solution {
	public static ListNode mergeKLists(ListNode[] lists) {
		int i;
		if (lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		for (i = 1; i < lists.length; i++) {
			lists[i] = mergeTwoLists(lists[i], lists[i - 1]);
		}

		return lists[i-1];

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode tListNode = new ListNode(0);
		ListNode temp = tListNode;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				tListNode.next = l1;
				tListNode = tListNode.next;
				l1 = l1.next;
			} else {
				tListNode.next = l2;
				tListNode = tListNode.next;
				l2 = l2.next;
			}
		}
		if (l1 == null) {
			tListNode.next = l2;
		}
		if (l2 == null) {
			tListNode.next = l1;
		}
		return temp.next;

	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode[] list = {l1,l2};
		mergeKLists(list);
	}
}
