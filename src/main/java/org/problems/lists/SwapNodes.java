package org.problems.lists;

import org.problems.model.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodes {

	public static ListNode swapPairs(ListNode head) {
   		ListNode cur = head;
        if (cur == null){
            return null;
        }
		ListNode newHead = cur.next == null ? cur :  cur.next;
		while (cur != null) {
			ListNode next = cur.next;
			ListNode nextToProcess = next == null ? null : next.next;
			if (next != null) {
				next.next = cur;
			}
			cur.next = nextToProcess == null ? null: nextToProcess.next == null ? nextToProcess : nextToProcess.next;
			cur = nextToProcess;
		}
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

		int m1 = 2;

		ListNode res1 = swapPairs(n1);

		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		n11.next = n12;
		int m2 = 1;

		ListNode res2 = swapPairs(n11);

	}

}
