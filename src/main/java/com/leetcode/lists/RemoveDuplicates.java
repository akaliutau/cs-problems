package com.leetcode.lists;

import com.leetcode.model.ListNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * Input: 1->1->2 Output: 
 * 1->2 
 * 
 * Example 2:
 * 
 * Input: 1->1->2->3->3 
 * Output: 1->2->3
 * 
 * 
 * 
 */
public class RemoveDuplicates {

	   public static ListNode deleteDuplicates(ListNode head) {
	        ListNode headCopy = head;
	        if (head == null){
	            return head;
	        }
	        ListNode lastElem = head;
	        int lastVal = lastElem.val;
	        while (head != null){
	            ListNode next = head.next;
	            if (next!= null && next.val != lastVal){
	                lastElem.next = next;
	                lastVal = next.val;
	                lastElem = next;
	            }
	            head = next;
	        }
	        if (lastElem.next != null && lastElem.next.val == lastElem.val) {
	        	lastElem.next = null;
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
