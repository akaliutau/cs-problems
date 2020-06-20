package org.problems.lists;

import org.problems.model.ListNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 * 
 * 
 * 
 */
public class RemoveListElements {

	public static ListNode removeElements(ListNode head, int val) {
		ListNode dummyHead = new ListNode(val + 1);
		ListNode first = head;
		while (first != null) {
			if (first.val != val) {
				dummyHead.next = first;
				break;
			}
			first = first.next;
		}

		ListNode ref = dummyHead;
		while (ref != null && ref.next != null) {
			if (ref.next.val == val) {
				ref.next = ref.next.next;
			}else {
			    ref = ref.next;
			}
		}
		return dummyHead.next;
	}

	public static void main(String[] arg) {

		int[] lst = { 1, 2, 6, 3, 4, 5, 6 };
		ListNode head = Utils.loadList(lst);

		Utils.print(removeElements(head, 6));

		
		int[] lst1 = { 1, 2, 2, 1 };
		ListNode head1 = Utils.loadList(lst1);

		Utils.print(removeElements(head1, 2));

	}

}
