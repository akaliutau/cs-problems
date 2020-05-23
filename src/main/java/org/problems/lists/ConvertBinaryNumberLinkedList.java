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
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,0,1] Output: 5 
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 * 
 * Input: head = [0] Output: 0 
 * Example 3:
 * 
 * Input: head = [1] Output: 1 
 * Example 4:
 * 
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0] Output: 18880 
 * Example 5:
 * 
 * Input: head = [0,0] Output: 0
 * 
 * 
 * Constraints:
 * 
 * The Linked List is not empty. Number of nodes will not exceed 30. Each node's
 * value is either 0 or 1
 * 
 */
public class ConvertBinaryNumberLinkedList {

	public static int getDecimalValue(ListNode head) {
		int num = 0;
		while (head != null) {
			num = num << 1;
			num += head.val;
			head = head.next;
		}
		
		return num;

	}

	public static void main(String[] arg) {
		
		int[] lst = {1,0,1};
		ListNode root = Utils.loadList(lst);
		System.out.println(getDecimalValue(root));

		int[] lst1 = {1};
		ListNode root1 = Utils.loadList(lst1);
		System.out.println(getDecimalValue(root1));

		int[] lst2 = {0,0};
		ListNode root2 = Utils.loadList(lst2);
		System.out.println(getDecimalValue(root2));

		int[] lst3 = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
		ListNode root3 = Utils.loadList(lst3);
		System.out.println(getDecimalValue(root3));

	}

}
