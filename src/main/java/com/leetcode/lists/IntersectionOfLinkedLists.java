package com.leetcode.lists;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.model.ListNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * For example, the following two linked lists: 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3 
 * Output: Reference of the node with value = 8 
 * 
 * Input Explanation: The intersected node's value is 8
 * (note that this must not be 0 if the two lists intersect). From the head of
 * A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5].
 * There are 2 nodes before the intersected node in A; 
 * There are 3 nodes before the intersected node in B.
 * 
 */
public class IntersectionOfLinkedLists {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> setA = new HashSet<>();
		ListNode refA = headA;
		
		while (refA != null) {
			setA.add(refA);
			refA = refA.next;
		}

		ListNode refB = headB;
		int size = setA.size();
		while (refB != null) {
			setA.add(refB);
			if (setA.size() == size) {// found it
				return refB;
			}
			size = setA.size();
			refB = refB.next;
		}
		return null;
    }

	public static void main(String[] arg) {

		int[] lst1 = {4,1};
		int[] lst2 = {5,0,1};
		int[] common = {8,4,5};
		ListNode headA = Utils.loadList(lst1);
		ListNode headB = Utils.loadList(lst2);
		
		System.out.println(getIntersectionNode(headA, headB));

	}

}
