package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 *
 * Given an array arr. You can choose a set of integers and remove all the
 * occurrences of these integers in the array.
 * 
 * Return the minimum size of the set so that at least half of the integers of
 * the array are removed.
 * 
 * Example 1:
 * 
 * Input: arr = [3,3,3,3,5,5,5,2,2,7] Output: 2 
 * 
 * Explanation: Choosing {3,7} will
 * make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the
 * size of the old array). Possible sets of size 2 are {3,5},{3,2},{5,2}.
 * Choosing set {2,7} is not possible as it will make the new array
 * [3,3,3,3,5,5,5] which has size greater than half of the size of the old
 * array. 
 * 
 * Example 2:
 * 
 * Input: arr = [7,7,7,7,7,7] Output: 1 
 * 
 * Explanation: The only possible set you
 * can choose is {7}. This will make the new array empty. 
 * 
 * Example 3:
 * 
 * Input: arr = [1,9] Output: 1 
 * 
 * Example 4:
 * 
 * Input: arr = [1000,1000,3,7] Output: 1 
 * 
 * Example 5:
 * 
 * Input: arr = [1,2,3,4,5,6,7,8,9,10] Output: 5
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 10^5 
 * arr.length is even. 
 * 1 <= arr[i] <= 10^5
 * 
 * 
 */
public class ReduceArraySize {
	
	static class Number {
		public final int num;
		public int count = 1;
	
		public Number(int num) {
			this.num = num;
		}

		@Override
		public String toString() {
			return "[num=" + num + ", count=" + count + "]";
		}
	}
	
	
	public static int minSetSize(int[] arr) {
	    Map<Integer,Number> hist = new HashMap<>();
	    for (int i = 0; i < arr.length; i++) {
	    	int numb = arr[i];
	    	if (!hist.containsKey(numb)) {
	    		hist.put(numb, new Number(numb));
	    	}else {
	    		hist.get(numb).count++;
	    	}
	    }
	    List<Number> lst = new ArrayList<>(hist.values());
	    Comparator<Number> byCount = (p,o) -> Integer.compare(o.count, p.count);
	    lst.sort(byCount);

	    int covered = 0;
	    int count = 0;
	    for (Number number : lst) {
	    	covered += number.count;
	    	count ++;
	    	if (covered >= arr.length/2) {
	    		return count;
	    	}
	    }

		return count;
	}

	public static void main(String[] arg) {

		int[] arr = {3,3,3,3,5,5,5,2,2,7};
		System.out.println(minSetSize(arr));

		int[] arr1 = {7,7,7,7,7,7};
		System.out.println(minSetSize(arr1));

		int[] arr2 = {1,9};
		System.out.println(minSetSize(arr2));

		int[] arr3 = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(minSetSize(arr3));

		int[] arr4 = {1000,1000,3,7};
		System.out.println(minSetSize(arr4));

	}
}
