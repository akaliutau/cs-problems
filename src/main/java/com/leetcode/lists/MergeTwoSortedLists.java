package com.leetcode.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * 
 * Runtime: 1 ms, faster than 19.38% of Java online submissions for Merge Two Sorted Lists.
Memory Usage: 38.7 MB, less than 19.53% of Java online submissions for Merge Two Sorted Lists.
 */
public class MergeTwoSortedLists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		List<ListNode> lst = new ArrayList<>();
		ListNode l = l1;
		ListNode r = l2;
		while (l != null && r != null) {
			if (l.val > r.val) {
				lst.add(r);
				r = r.next;
			}else {
				lst.add(l);
				l = l.next;
			}
		}
        for (int i = 0; i < lst.size()-1; i++){
            lst.get(i).next = lst.get(i+1);
        }
        if (l != null) {
        	lst.add(l);
            if (lst.size() > 1){
                lst.get(lst.size()-2).next = l;
            }
        }
        if (r != null) {
        	lst.add(r);
            if (lst.size() > 1){
                lst.get(lst.size()-2).next = r;
            }
        }
		if (lst.isEmpty()){
            return null;
        }
        //lst.get(lst.size()-1).next = null;
		return lst.isEmpty() ? null : lst.get(0);
    }

	public static void main(String[] arg) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		
		ListNode m1 = new ListNode(1);
		ListNode m2 = new ListNode(3);
		ListNode m3 = new ListNode(4);
		m1.next = m2;
		m2.next = m3;
		
		ListNode res = mergeTwoLists(n1,m1);
		
	}

}
