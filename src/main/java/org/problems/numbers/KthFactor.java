package org.problems.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/the-kth-factor-of-n/
 * 
 * Given two positive integers n and k.
 * 
 * A factor of an integer n is defined as an integer i where n % i == 0.
 * 
 * Consider a list of all factors of n sorted in ascending order, return the kth
 * factor in this list or return -1 if n has less than k factors.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 12, k = 3 Output: 3 
 * Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
 * 
 * 
 * 
 */
public class KthFactor {

	public int kthFactor(int n, int k) {
		List<Integer> fact = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				fact.add(i);
			}
		}
		Collections.sort(fact);
		return k - 1 < fact.size() ? fact.get(k - 1) : -1;

	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
