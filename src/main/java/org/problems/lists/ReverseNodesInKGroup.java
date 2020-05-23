package org.problems.lists;

import org.problems.model.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 0 1 2 3 4 1->2->3->4->5
 * 
 * 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the
 * list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup {

	public static ListNode getNth(ListNode from, int n) {
		while (from != null && n-- > 0) {
			from = from.next;
		}
		return from;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
  		// 1->2->3->4->5

	// headPointer = 1
	// nextGroup = 4
	// tail = 3

	// 3->2->1 -
	// 1) 1 copyto lastHead (link lastHead to tail -- if exists)
	// 2) 1 updatewith nextGroup, exit

	ListNode lastHead = null;
	ListNode headPointer = head;
	ListNode nextGroup = getNth(headPointer, k);
	ListNode pointer = getNth(headPointer, k - 1);
	ListNode tailCopy = pointer;
	
	head = pointer == null ? head : pointer;
	
	while (headPointer != null && pointer != null) {
		int groupNode1 = k - 1;
		while (groupNode1-- > -1) {
			ListNode next = getNth(headPointer, groupNode1);
			pointer.next = next;
			pointer = next;
		}

		// update inter-group links
		if (lastHead != null) {
			lastHead.next = tailCopy;
		}
		lastHead = headPointer;
		
		// update referencies for the next group
		headPointer = nextGroup;
		nextGroup = getNth(headPointer, k);
        if (getNth(headPointer, k - 1) == null){
            pointer.next = headPointer;
            break;
        }
		pointer = getNth(headPointer, k - 1);
		tailCopy = pointer;
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

		ListNode res1 = reverseKGroup(n1,2);

		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		n11.next = n12;
		int m2 = 1;

		ListNode res2 = reverseKGroup(n11,2);

	}

}
