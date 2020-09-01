package org.problems.favourite;

import java.util.ArrayList;
import java.util.List;

import org.problems.model.ListNode;

/**
 * Merge Two Sorted Lists
 */
public class MergeSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		List<ListNode> lst = new ArrayList<>();
		ListNode l = l1;
		ListNode r = l2;
		while (l != null && r != null) {
			if (l.val > r.val) {
				lst.add(r);
				r = r.next;
			} else {
				lst.add(l);
				l = l.next;
			}
		}
		for (int i = 0; i < lst.size() - 1; i++) {
			lst.get(i).next = lst.get(i + 1);
		}
		if (l != null) {
			lst.add(l);
			if (lst.size() > 1) {
				lst.get(lst.size() - 2).next = l;
			}
		}
		if (r != null) {
			lst.add(r);
			if (lst.size() > 1) {
				lst.get(lst.size() - 2).next = r;
			}
		}
		if (lst.isEmpty()) {
			return null;
		}
		return lst.isEmpty() ? null : lst.get(0);

	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
