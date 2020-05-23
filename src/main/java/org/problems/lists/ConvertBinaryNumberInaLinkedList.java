package org.problems.lists;

import org.problems.model.ListNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * 
 * Given head which is a reference node to a singly-linked list. The value of
 * each node in the linked list is either 0 or 1. The linked list holds the
 * binary representation of a number.
 * 
 * Return the decimal value of the number in the linked list.
 * 
 * Example 1:
 * 
 * Input: head = [1,0,1] Output: 5 Explanation: (101) in base 2 = (5) in base 10
 * 
 * Example 2:
 * 
 * Input: head = [0] Output: 0 
 * 
 * Example 3:
 * 
 * Input: head = [1] Output: 1 
 * 
 * Example 4:
 * 
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0] Output: 18880 Example 5:
 * 
 * Input: head = [0,0] Output: 0
 * 
 * 
 * Constraints:
 * 
 * The Linked List is not empty. Number of nodes will not exceed 30. Each node's
 * value is either 0 or 1.
 * 
 */
public class ConvertBinaryNumberInaLinkedList {
	
	public static int getDecimalValue(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val+"");
			head = head.next;
		}
		if (sb.length() == 0) {
			return 0;
		}
		return Integer.parseInt(sb.toString(), 2);
        
    }


	public static void main(String[] arg) {
		
		int[] lst = {1,0,1};
		ListNode head = Utils.loadList(lst);
		System.out.println(getDecimalValue(head));

		int[] lst1 = {0};
		ListNode head1 = Utils.loadList(lst1);
		System.out.println(getDecimalValue(head1));

		int[] lst2 = {1};
		ListNode head2 = Utils.loadList(lst2);
		System.out.println(getDecimalValue(head2));

		int[] lst3 = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
		ListNode head3 = Utils.loadList(lst3);
		System.out.println(getDecimalValue(head3));

		int[] lst4 = {0,0};
		ListNode head4 = Utils.loadList(lst4);
		System.out.println(getDecimalValue(head4));

	}

}
