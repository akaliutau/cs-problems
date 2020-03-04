package com.leetcode.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Runtime: 2 ms, faster than 77.62% of Java online submissions for Add Two
 * Numbers. Memory Usage: 40.6 MB, less than 98.43% of Java online submissions
 * for Add Two Numbers
 */
public class AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "" + val;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		ListNode mainThread = l1;
		ListNode secondThread = l2;
		List<ListNode> list = new ArrayList<>();

		int excess = 0;
		boolean next = true;
		boolean isFirst = true;
		while (next) {
			next = false;
			int curNum = excess;
			if (mainThread != null) {
				curNum += mainThread.val;
				mainThread = mainThread.next;
				next = true;
			}
			if (secondThread != null) {
				curNum += secondThread.val;
				secondThread = secondThread.next;
				next = true;
			}
			excess = curNum >= 10 ? 1 : 0;
			if (next || curNum > 0) {
				if (!isFirst) {
					res.next = new ListNode(0);
					res = res.next;
				} else {
					isFirst = false;
				}
				res.val = curNum % 10;
				list.add(res);
			}
		}

		return list.get(0);

	}

	public static void main(String[] arg) {

		ListNode n01 = new ListNode(2);
		ListNode n02 = new ListNode(4);
		ListNode n03 = new ListNode(3);
		n01.next = n02;
		n02.next = n03;

		ListNode n11 = new ListNode(5);
		ListNode n12 = new ListNode(6);
		ListNode n13 = new ListNode(4);
		n11.next = n12;
		n12.next = n13;

		ListNode res = addTwoNumbers(n01, n11);
		while (res != null) {
			System.out.println(res);
			res = res.next;
		}

	}
}
