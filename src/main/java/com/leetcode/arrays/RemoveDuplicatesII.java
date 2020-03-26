package com.leetcode.arrays;

import com.leetcode.model.ListNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Return the linked list sorted as well.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->3->4->4->5 Output: 1->2->5
 * 
 * Example 2:
 * 
 * Input: 1->1->1->2->3 Output: 2->3
 * 
 * 
 */
public class RemoveDuplicatesII {

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode headCopy = head;
		if (head == null) {
			return head;
		}

		ListNode next = null;
		ListNode curElem = head;
		
		while (head != null) {
			next = head.next;
			if (next != null && curElem.val != next.val) {
					curElem.next = next;
					curElem = next;
			} 
			head = next;
		}
		if (curElem.next != null && curElem.next.val == curElem.val) {
			curElem.next = null;
		}
		return headCopy;
	}

	public static void main(String[] arg) {

		ListNode n01 = new ListNode(1);
		ListNode n02 = new ListNode(1);
		ListNode n03 = new ListNode(2);
		n01.next = n02;
		n02.next = n03;

		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(1);
		ListNode n13 = new ListNode(2);
		ListNode n14 = new ListNode(3);
		ListNode n15 = new ListNode(3);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;

		ListNode n21 = new ListNode(1);
		ListNode n22 = new ListNode(2);
		n21.next = n22;

		ListNode n31 = new ListNode(1);
		ListNode n32 = new ListNode(1);
		ListNode n33 = new ListNode(1);
		n31.next = n32;
		n32.next = n33;

		Utils.print(deleteDuplicates(n01));

		Utils.print(deleteDuplicates(n11));

		Utils.print(deleteDuplicates(n21));

		Utils.print(deleteDuplicates(n31));

	}
}
