package com.leetcode.lists;

import com.leetcode.model.*;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/linked-list-in-binary-tree/ Given a binary tree
 * root and a linked list with head as the first node.
 * 
 * Return True if all the elements in the linked list starting from the head
 * correspond to some downward path connected in the binary tree otherwise
 * return False.
 * 
 * In this context downward path means a path that starts at some node and goes
 * downwards.
 * 
 * 
 * Input: head = [4,2,8], root =
 * [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 
 * Output: true
 * 
 * Input: head = [1,4,2,6], root =
 * [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 
 * Output: true
 * 
 * Example 3:
 * 
 * Input: head = [1,4,2,6,8], root =
 * [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 
 * Output: false
 * 
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Linked List
 * in Binary Tree. Memory Usage: 41.9 MB, less than 100.00% of Java online
 * submissions for Linked List in Binary Tree.
 * 
 * 
 */
public class LinkedListinTree {

	public static boolean check(ListNode node, TreeNode treeNode) {
		if (treeNode == null) {
			return false;
		}
		if (node.val == treeNode.val) {
			if (node.next == null) {// found
				return true;
			}
			// search next node
			boolean res1 = check(node.next, treeNode.left);
			if (!res1) {
				return check(node.next, treeNode.right);
			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean found(ListNode node, TreeNode treeNode) {
		if (treeNode == null) {
			return false;
		}
		if (node.val == treeNode.val) {
			if (check(node, treeNode)) {
				return true;
			}
		}
		// search next node
		if (found(node, treeNode.left)) {
			return true;
		}
		return found(node, treeNode.right);
	}

	public static boolean isSubPath(ListNode head, TreeNode root) {

		return found(head, root);

	}

	public static void main(String[] arg) {

		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(8);
		n1.next = n2;
		n2.next = n3;

		Integer[] tree = new Integer[] { 1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3 };
		TreeNode t1 = Utils.loadTree(tree);
		System.out.println(isSubPath(n1, t1));

		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(4);
		ListNode n13 = new ListNode(2);
		ListNode n14 = new ListNode(6);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;

		Integer[] tree1 = new Integer[] { 1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3 };
		TreeNode t11 = Utils.loadTree(tree1);
		System.out.println(isSubPath(n11, t11));

		ListNode n21 = new ListNode(1);
		ListNode n22 = new ListNode(4);
		ListNode n23 = new ListNode(2);
		ListNode n24 = new ListNode(6);
		ListNode n25 = new ListNode(8);
		n21.next = n22;
		n22.next = n23;
		n23.next = n24;
		n24.next = n25;

		Integer[] tree2 = new Integer[] { 1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3 };
		TreeNode t21 = Utils.loadTree(tree2);
		System.out.println(isSubPath(n21, t21));

	}

}
