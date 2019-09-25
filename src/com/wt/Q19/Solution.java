package com.wt.Q19;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

 * @author Wutong
 *
 */

public class Solution {
public static ListNode removeNthFromEnd(ListNode head, int n) {
	int num = 1,num2=0;
	ListNode t = head;
	ListNode t3 = new ListNode(0);
	t3.next = head;
	ListNode t2 = t3;
	while (t.next!=null) {
		num++;
		t = t.next;
	}
	num2 = num-n;
	System.out.println(num);
	while (num2>=0) {
		if (num2 !=0) {
			t2 = t2.next;
			num2--;
			
		}else {
			t2.next = t2.next.next;
			break;
		}
		
		
	}
	return t3.next;
        
    }
public static void main(String[] args) {
	ListNode t2 = new ListNode(3);
	t2.next  = new ListNode(2);
	t2.next.next = new ListNode(1);
	removeNthFromEnd(t2, 1);
}
}
