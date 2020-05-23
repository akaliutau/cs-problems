package org.problems.datastructures;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. 
 * pop()   -- Removes the element from in front of queue. 
 * peek()  -- Get the front element. 
 * empty() -- Return whether the queue is empty. 
 * 
 * Example:
 * 
 * MyQueue queue = new MyQueue();
 * 
 * queue.push(1); 
 * queue.push(2); 
 * queue.peek();  // returns 1 
 * queue.pop();   // returns 1 
 * queue.empty(); // returns false
 * 
 */
public class ImplementQueueUsingStacks {
	
	static class MyQueue {
		
		private Stack<Integer> stack;

	    /** Initialize your data structure here. */
	    public MyQueue() {
	    	stack = new Stack<>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
    		stack.add(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	    	int n = stack.size();
	    	int last = stack.pop();
	    	Stack<Integer> backUpStack = new Stack<>();
	    	while (!stack.isEmpty()) {
	    		backUpStack.add(last);
	    		last = stack.pop();
	    	}
	    	while (!backUpStack.isEmpty()) {
	    		stack.add(backUpStack.pop());
	    	}
	    	return last;
	    	
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	int n = stack.size();
	    	int last = stack.pop();
	    	Stack<Integer> backUpStack = new Stack<>();
	    	while (!stack.isEmpty()) {
	    		backUpStack.add(last);
	    		last = stack.pop();
	    	}
	    	stack.add(last);
	    	while (!backUpStack.isEmpty()) {
	    		stack.add(backUpStack.pop());
	    	}
	    	return last;
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return stack.isEmpty();
	    }
	}


	public static void main(String[] arg) {

		MyQueue queue = new MyQueue();
		 
		queue.push(1); 
		queue.push(2); 
		queue.push(3); 
		System.out.println(queue.peek());  // returns 1 
		System.out.println(queue.pop());   // returns 1 
		System.out.println(queue.empty()); // returns false
		System.out.println(queue.peek());  // returns 1 
		System.out.println(queue.pop());   // returns 1 
		System.out.println(queue.empty()); // returns false
	}
}
