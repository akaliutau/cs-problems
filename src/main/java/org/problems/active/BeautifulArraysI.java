package org.problems.active;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/beautiful-array/
 * 
 * For some fixed N, an array A is beautiful if it is a permutation of the
 * integers 1, 2, ..., N, such that:
 * 
 * For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] +
 * A[j].
 * 
 * Given N, return any beautiful array A. (It is guaranteed that one exists.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 4 Output: [2,1,4,3]
 * 
 * N - [1,1000]
 */
public class BeautifulArraysI {
	

	public int[] beautifulArray(int n) {
		Set<Integer> all = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			all.add(i);
		}
		int left = 2;
		int right = n-1;
		
		
		return null;

	}

	public static void main(String[] arg) {

		int[] arr = {};

		List<Integer> lst1 = Arrays.asList(1, 3, 2);
		List<Integer> lst2 = Arrays.asList(1, 2, 3);
		List<Integer> lst3 = Arrays.asList(1, 2);

		Set<Integer> set1 = new HashSet<>(lst1);
		Set<Integer> set2 = new HashSet<>(lst2);
		Set<Integer> set3 = new HashSet<>(lst3);

		System.out.println(set1.equals(set2));
		System.out.println(set1.equals(set3));
	}

}
