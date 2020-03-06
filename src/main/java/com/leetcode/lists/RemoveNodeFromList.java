package com.leetcode.lists;

import com.leetcode.model.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 */
public class RemoveNodeFromList {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int counter = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			counter++;
		}
		System.out.println("counter="+counter);
		counter--;
		counter -= n;
		cur = head;
		System.out.println("counter="+counter);
		if (counter < 0) {
			if (cur != null) {
				return cur.next;
			}
		}
		while (counter-- > 0) {
			cur = cur.next;
		}
		if (cur.next != null) {
			cur.next = cur.next.next;
		}
		return head;
	}

	public static void main(String[] arg) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		int m1 = 2;

		ListNode res1 = removeNthFromEnd(n1, m1);
		
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		n11.next = n12;
		int m2 = 1;

		ListNode res2 = removeNthFromEnd(n11, m2);


	}

}
