package com.leetcode.datastructures;

/**
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/
 * 
 * Design a stack which supports the following operations.
 * 
 * Implement the CustomStack class:
 * 
 * CustomStack(int maxSize) Initializes the object with maxSize which is the
 * maximum number of elements in the stack or do nothing if the stack reached
 * the maxSize. 
 * 
 * void push(int x) Adds x to the top of the stack if the stack
 * hasn't reached the maxSize. 
 * 
 * int pop() Pops and returns the top of stack or -1
 * if the stack is empty. 
 * 
 * void inc(int k, int val) Increments the bottom k
 * elements of the stack by val. 
 * 
 * If there are less than k elements in the stack,
 * just increment all the elements in the stack.
 * 
 * 
 */
public class DesignStack {

	static class CustomStack {

		int[] stack;
		int idx = -1;

		public CustomStack(int maxSize) {
			stack = new int[maxSize];

		}

		public void push(int x) {
			if (idx < stack.length - 1) {
				stack[++idx] = x;
			}
		}

		public int pop() {
			if (idx > -1) {
				return stack[idx--];
			}
			return -1;
		}

		public void increment(int k, int val) {
			for (int i = 0; i <= idx && i < k; i++) {
				stack[i] += val;
			}
		}
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
