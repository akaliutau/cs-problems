package com.leetcode.lists;

import com.leetcode.model.ListNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/sort-list/
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * Input: 4->2->1->3 Output: 1->2->3->4
 * 
 * Example 2:
 * 
 * Input: -1->5->3->4->0 Output: -1->0->3->4->5
 * 
 * 
 */
public class SortList {

	static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		if (l1 != null) {
			curr.next = l1;
			l1 = l1.next;
		}

		if (l2 != null) {
			curr.next = l2;
			l2 = l2.next;
		}
		return dummy.next;
	}

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode first = head;
		ListNode second = head;
		int n = 0;
		while (first != null) {
			first = first.next;
			n++;
		}
		n = n / 2;
		while (n-- > 0) {
			second = second.next;
		}
		first = head;
		while (first.next != second) {
			first = first.next;
		}
		first.next = null;
		
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(second);

		return merge(l1, l2);

	}

	public static void main(String[] arg) {

		int[] lst = { 4, 2, 1, 3 };
		ListNode list = Utils.loadList(lst);

		System.out.println(sortList(list));

	}

}
