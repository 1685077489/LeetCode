package com.wt.Q25;

import java.util.Stack;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 你的算法只能使用常数的额外空间。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * @author Wutong
 *
 */
/**
 * 利用栈来实现交换
 * @author Wutong
 *
 */
public class Solution {
	public static ListNode reverseKGroup(ListNode head, int k) {
		int i = k, j = 0;
		ListNode temp = head;
		ListNode temp2 = new ListNode(1);
		ListNode re = temp2;
		while (head != null) {
			head = head.next;
			j++;
			if (j > k) {
				break;
			}

		}
		if (j < k || k < 2) {
			return temp;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		while (i > 0) {
			stack.add(temp);
			temp = temp.next;
			i--;

		}
		while (!stack.isEmpty()) {
			temp2.next = stack.pop();
			temp2 = temp2.next;
		}
		temp2.next = reverseKGroup(temp, k);

		return re.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		ListNode temp = reverseKGroup(head.next.next, 3);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;

		}
	}
}
