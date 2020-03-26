package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/relative-sort-array/
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all
 * elements in arr2 are also in arr1.
 * 
 * Sort the elements of arr1 such that the relative ordering of items in arr1
 * are the same as in arr2. Elements that don't appear in arr2 should be placed
 * at the end of arr1 in ascending order.
 * 
 * 
 * Example 1:
 * 
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6] 
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * 
 * 
 * Constraints:
 * 
 * arr1.length, arr2.length <= 1000 
 * 0 <= arr1[i], arr2[i] <= 1000 
 * Each arr2[i] is distinct. Each arr2[i] is in arr1.
 * 
 * 
 */
public class RelativeSortArray {
	
	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
	    int n = arr1.length;
	    int k = arr2.length;
	    int[] res = new int[n+k];

	    boolean[] map2 = new boolean[1001];
	    for (int i = 0; i < k; i++) {
	    	map2[arr2[i]] = true;
	    }

	    List<Integer> notPresent = new ArrayList<>();
	    int[] map1 = new int[1001];
	    for (int i = 0; i < n; i++) {
	    	if (!map2[arr1[i]]) {
	    		notPresent.add(arr1[i]);
	    	}else {
	    		map1[arr1[i]] ++;
	    	}
	    }
	    int idx = 0;
	    for (int i = 0; i < k; i++) {
	    	int num = arr2[i];
		    for (int j = 0; j < map1[num]; j++) {
		    	res[idx++] = num;
		    }	    	
	    }
	    Collections.sort(notPresent);
	    for (Integer num : notPresent) {
	    	res[idx++] = num;
	    }
	    
		return Arrays.copyOf(res, idx);
	}

	public static void main(String[] arg) {
		
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {2,1,4,3,9,6};
		Utils.print(relativeSortArray(arr1, arr2));

		int[] arr1a = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2a = {};
		Utils.print(relativeSortArray(arr1a, arr2a));

		int[] arr1b = {19};
		int[] arr2b = {1,2};
		Utils.print(relativeSortArray(arr1b, arr2b));

	}
}
