package org.problems.datastructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack. 
 * pop() -- Removes the element on top of the stack. 
 * top() -- Get the top element. 
 * empty() -- Return whether the stack is empty. 
 * 
 * Example:
 * 
 * MyStack stack = new MyStack();
 * 
 * stack.push(1); 
 * stack.push(2); 
 * stack.top(); // returns 2 
 * stack.pop(); // returns 2 
 * stack.empty(); // returns false
 */
public class ImplementStackUsingQueues {
	
	static class MyStack {
		
		private Queue<Integer> queue;

	    /** Initialize your data structure here. */
	    public MyStack() {
	    	queue = new LinkedList<>();
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	    	queue.add(x);
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	    	int n = queue.size() -1;
	    	int last = queue.poll();
	    	while (n-- > 0) {
	    		int prev = last;
	    		queue.add(prev);
	    		last = queue.poll();
	    	}
	    	return last;
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	int n = queue.size()-1;
	    	int last = queue.poll();
	    	while (n-- > 0) {
	    		int prev = last;
	    		queue.add(prev);
	    		last = queue.poll();
	    	}
	    	queue.add(last);
	    	return last;
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	    	return queue.isEmpty();
	    }
	}

	public static void main(String[] arg) {
		
		MyStack stack = new MyStack();
		 
		stack.push(1); 
		stack.push(2); 
		stack.push(3); 
		System.out.println(stack.top()); // returns 3 
		System.out.println(stack.pop()); // returns 3 
		System.out.println(stack.empty()); // returns false
		System.out.println(stack.pop()); // returns 2 
		System.out.println(stack.empty()); // returns false
	}
}
