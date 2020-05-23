package org.problems.lists;

import org.problems.model.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Runtime: 258 ms, faster than 8.52% of Java online submissions for Merge k
 * Sorted Lists. Memory Usage: 41.1 MB, less than 44.27% of Java online
 * submissions for Merge k Sorted Lists
 */
public class MergekSortedLists2 {

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode prevNode = null;
		ListNode firstNode = null;

		boolean found = true;
		int index = 0;

		while (found) {
			index = 0;
			found = false;
			ListNode curMinNode = null;
			for (int i = 0; i < lists.length; i++) {
				ListNode node = lists[i];
				if (node != null) {
					if (curMinNode == null) {
						curMinNode = node;
						index = i;
					} else {
						if (curMinNode.val >= node.val) {
							curMinNode = node;
							index = i;
						}
					}
					found = true;// smth has been found
				}
			}
			if (found) {
				lists[index] = curMinNode.next;
				curMinNode.next = null;
				if (prevNode != null) {
					prevNode.next = curMinNode;
				} else {
					firstNode = curMinNode;
				}
				prevNode = curMinNode;
				curMinNode = null;
			}
		}
		return firstNode;

	}

	public static void main(String[] arg) {
		ListNode n01 = new ListNode(1);
		ListNode n02 = new ListNode(4);
		ListNode n03 = new ListNode(5);
		n01.next = n02;
		n02.next = n03;

		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(3);
		ListNode n13 = new ListNode(4);
		n11.next = n12;
		n12.next = n13;

		ListNode n21 = new ListNode(2);
		ListNode n22 = new ListNode(6);
		n21.next = n22;

		ListNode[] lists = new ListNode[3];
		lists[0] = n01;
		lists[1] = n11;
		lists[2] = n21;

		ListNode res = mergeKLists(lists);
		while (res != null) {
			System.out.println(res);
			res = res.next;
		}

	}
}
