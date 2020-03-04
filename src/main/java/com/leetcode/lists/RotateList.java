package com.leetcode.lists;

/**
 * https://leetcode.com/problems/rotate-list/
 * 
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL, k = 2 Output: 4->5->1->2->3->NULL
 * 
 * 1) set Node(len-k) -> NULL 2) set Node(last) -> oldHead 3) return
 * Node(len-k-1) as a newHead
 * 
 * Explanation: rotate 1 steps to the right: 5->1->2->3->4->NULL rotate 2 steps
 * to the right: 4->5->1->2->3->NULL
 * 
 */
public class RotateList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {
		ListNode oldHead = head;
		ListNode newHead = null;

		int len = 1;
		if (oldHead == null) {
			return head;
		}
		while (oldHead.next != null) {
			oldHead = oldHead.next;
			len++;
		}
		ListNode tail = oldHead;

		int offset = Math.floorMod(k, len);
		if (len == 1 || offset == 0) {
			return head;
		}
		int part2 = len - offset - 1;
		oldHead = head;
		while (part2-- > 0) {
			oldHead = oldHead.next;
		}
		newHead = oldHead.next;
		oldHead.next = null;
		tail.next = head;

		return newHead;

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

		System.out.println(rotateRight(n1, 2).val);

	}
}
