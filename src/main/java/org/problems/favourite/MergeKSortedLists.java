package org.problems.favourite;

import org.problems.model.ListNode;

/**
 * 
 * Merge k Sorted Lists
 * 
 * Given an array of linked-lists lists, each linked list is sorted in ascending
 * order.
 * 
 * Merge all the linked-lists into one sort linked-list and return it.
 * 
 * Example 1:
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] 
 * 
 * Explanation:
 * The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted
 * list: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

	public ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		ListNode prev = new ListNode(0);
		ListNode res = prev;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				prev.next = l2;
				break;
			} else if (l2 == null) {
				prev.next = l1;
				break;
			}

			int val1 = l1.val;
			int val2 = l2.val;

			ListNode temp = null;
			if (val1 < val2) {
				temp = new ListNode(val1);
				l1 = l1.next;
			} else {
				temp = new ListNode(val2);
				l2 = l2.next;
			}

			prev.next = temp;
			prev = prev.next;
		}
		return res.next;
	}

	public ListNode mergeSublist(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		}

		int mid = (end + start) / 2;

		ListNode left = mergeSublist(lists, start, mid);
		ListNode right = mergeSublist(lists, mid + 1, end);

		return merge(left, right);
	}

	public ListNode mergeKLists(ListNode[] lists) {
		int n = lists.length;
		if (n == 0) {
			return null;
		}
		return mergeSublist(lists, 0, n - 1);
	}


	public static void main(String[] arg) {

		System.out.println("D");

	}

}
