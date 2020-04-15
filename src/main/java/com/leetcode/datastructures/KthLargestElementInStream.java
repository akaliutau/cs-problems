package com.leetcode.datastructures;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * 
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Your KthLargest class will have a constructor which accepts an integer k and
 * an integer array nums, which contains initial elements from the stream. For
 * each call to the method KthLargest.add, return the element representing the
 * kth largest element in the stream.
 * 
 * Note: You may assume that nums' length ≥ k-1 and k ≥ 1.
 */
public class KthLargestElementInStream {

	static class KthLargest {

		private int[] array;
		private int k;

		public KthLargest(int k, int[] nums) {
			this.k = k;
			this.array = nums;
			Arrays.sort(this.array);
		}

		public int add(int val) {
			int n = array.length;
			int[] newArray = new int[n+1];
			for (int i = 0; i < n; i++) {
				if (val < array[i]) {
					newArray = Arrays.copyOf(array,n+1);
					for (int j = n; j > i; j--) {
						newArray[j] = array[j-1];
					}
					newArray[i] = val;
					array = newArray;
					return array[n+1-k];
				}
			}
			newArray = Arrays.copyOf(array,n+1);
			newArray[n] = val; 			
			array = newArray;
			return array[n+1-k];
		}
	}

	public static void main(String[] arg) {

		int[] arr = { 4, 5, 8, 2 };
		KthLargest kthLargest = new KthLargest(3, arr);
		System.out.println(kthLargest.add(3)); // returns 4
		System.out.println(kthLargest.add(5)); // returns 5
		System.out.println(kthLargest.add(10)); // returns 5
		System.out.println(kthLargest.add(9)); // returns 8
		System.out.println(kthLargest.add(4)); // returns 8

		int[] arr1 = {};
		KthLargest kthLargest1 = new KthLargest(1, arr1);
		System.out.println(kthLargest1.add(-3)); // returns -3
		System.out.println(kthLargest1.add(-2)); // returns -2
		System.out.println(kthLargest1.add(-4)); // returns -2
		System.out.println(kthLargest1.add(0)); // returns 0
		System.out.println(kthLargest1.add(4)); // returns 4

		int[] arr2 = {0};
		KthLargest kthLargest2 = new KthLargest(2, arr2);
		System.out.println(kthLargest2.add(-1)); // returns -1
		System.out.println(kthLargest2.add(1)); // returns 0
		System.out.println(kthLargest2.add(-2)); // returns0 
		System.out.println(kthLargest2.add(4)); // returns 1
		System.out.println(kthLargest2.add(5)); // returns 4

	}
}
