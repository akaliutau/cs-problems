package org.problems.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/min-stack/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. 
 * pop() -- Removes the element on top of the stack. 
 * top() -- Get the top element. 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack(); 
 * minStack.push(-2); 
 * minStack.push(0);
 * minStack.push(-3); 
 * minStack.getMin(); --> Returns -3. 
 * minStack.pop();
 * minStack.top(); --> Returns 0. 
 * minStack.getMin(); --> Returns -2.
 * 
 * 
 */
public class MinStackImpl {
	
	static class MinStack {
		
		private List<Integer> stack = new ArrayList<>(); 
		private Integer minElem = Integer.MAX_VALUE;

	    /** initialize your data structure here. */
	    public MinStack() {
	        
	    }
	    
	    public void push(int x) {
	    	stack.add(x);
	    	if (x < minElem) {
	    		minElem = x;
	    	}
	    }
	    
	    public void pop() {
	    	int elem = top();
	    	stack.remove(stack.size()-1);
	    	if (elem == minElem) {
		    	updateMin();
	    	}
	    }
	    
	    public int top() {
	    	return stack.get(stack.size()-1);
	    }
	    
	    public int getMin() {
	        return minElem;
	    }
	    
	    private void updateMin() {
	    	 minElem = Integer.MAX_VALUE;
	    	 for (int i = 0; i < stack.size(); i++) {
	    		 minElem = minElem > stack.get(i) ? stack.get(i) : minElem;
	    	 }
	    }
	}


	public static void main(String[] arg) {
		
		MinStack minStack = new MinStack(); 
		minStack.push(-2); 
		minStack.push(0);
		minStack.push(-3); 
		System.out.println(minStack.getMin());// Returns -3. 
		minStack.pop();
		System.out.println(minStack.top());// Returns 0. 
		System.out.println(minStack.getMin());// Returns -2.

	}
}
