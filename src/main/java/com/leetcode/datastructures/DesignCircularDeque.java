package com.leetcode.datastructures;

/**
 * https://leetcode.com/problems/design-circular-deque/
 * 
 * Design your implementation of the circular double-ended queue (deque).
 * 
 * Your implementation should support following operations:
 * 
 * MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * 
 * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful. 
 * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful. 
 * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful. 
 * getFront(): Gets the front item from the Deque. If the deque is empty, return -1. 
 * getRear(): Gets the last item from Deque. If the deque is empty, return -1. 
 * isEmpty(): Checks whether Deque is empty or not. 
 * isFull(): Checks whether Deque is full or not.
 * 
 * Note:
 * All values will be in the range of [0, 1000]. The number of operations will
 * be in the range of [1, 1000].
 */
public class DesignCircularDeque {
	
	static class MyCircularDeque {
		
		private int[] array;
		private int lastIdx = 0;
		private int size = 0;

	    /** Initialize your data structure here. Set the size of the deque to be k. */
	    public MyCircularDeque(int k) {
	        array = new int[k]; 
	        size = k;
	    }
	    
	    /** Adds an item at the front of Deque. Return true if the operation is successful. */
	    public boolean insertFront(int value) {
	    	if (lastIdx < size) {
	    		for (int i = lastIdx; i > 0; i--) {
	    			array[i] = array[i-1];
	    		}
	    		array[0] = value;
	    		lastIdx ++;
	    		return true;
	    	}
			return false;
	    }
	    
	    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
	    public boolean insertLast(int value) {
	    	if (lastIdx < size) {
	    		array[lastIdx++] = value;
	    		return true;
	    	}
			return false;
	    }
	    
	    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
	    public boolean deleteFront() {
	    	if (lastIdx > 0) {
	    		for (int i = 0; i < lastIdx-1; i++) {
	    			array[i] = array[i+1];
	    		}
	    		lastIdx --;
	    		return true;
	    	}
			return false;
	    }
	    
	    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	    public boolean deleteLast() {
	    	if (lastIdx > 0) {
	    		lastIdx --;
	    		return true;
	    	}
			return false;
	    }
	    
	    /** Get the front item from the deque. */
	    public int getFront() {
            if (lastIdx > 0){
			    return array[0];
            }
	        return -1;
	    }
	    
	    /** Get the last item from the deque. */
	    public int getRear() {
            if (lastIdx > 0){
			    return array[lastIdx-1];
            }
            return -1;
	    }
	    
	    /** Checks whether the circular deque is empty or not. */
	    public boolean isEmpty() {
			return lastIdx == 0;
	    }
	    
	    /** Checks whether the circular deque is full or not. */
	    public boolean isFull() {
			return lastIdx == size;
	    }
	}

	public static void main(String[] arg) {
		
		MyCircularDeque circularDeque = new MyCircularDeque(3);//set the size to be 3 
		System.out.println(circularDeque.insertLast(1)); // return true 
		System.out.println(circularDeque.insertLast(2)); // return true 
		System.out.println(circularDeque.insertFront(3)); // return true
		System.out.println(circularDeque.insertFront(4)); // return false, the queue is full
		System.out.println(circularDeque.getRear()); // return 2 
		System.out.println(circularDeque.isFull()); // return true
		System.out.println(circularDeque.deleteLast()); // return true 
		System.out.println(circularDeque.insertFront(4)); // return true 
		System.out.println(circularDeque.getFront()); // return 4		

	}

}
