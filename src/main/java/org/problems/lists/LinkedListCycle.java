package org.problems.lists;

import org.problems.model.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Given a linked list, determine if it has a cycle in it.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list.
 * 
 * Example 1:
 * 
 * Input: head = [3,2,0,-4], pos = 1 Output: true
 * 
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 * 
 * Must be solved in O(1) (i.e. constant) memory
 * 
 */
public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode second = head;
		ListNode first = head.next;
		while (first != second) {
			if (first == null || first.next == null) {
				return false;
			}
			second = second.next;
			first = first.next.next;
		}
		return true;
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}
}
