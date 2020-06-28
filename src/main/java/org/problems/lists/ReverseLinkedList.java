package org.problems.lists;

import java.util.Stack;

import org.problems.model.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		Stack<ListNode> stack = new Stack<>();
		while (head != null) {
			stack.add(head);
			head = head.next;
		}
		ListNode res = stack.pop();
		head = res;
		while (!stack.isEmpty()) {
			head.next = stack.pop();
			head = head.next;
		}
		head.next = null;
		return res;
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
