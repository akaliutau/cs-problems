package org.problems.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-prefix-divisible-by-5/
 * 
 * Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to
 * A[i] interpreted as a binary number (from most-significant-bit to
 * least-significant-bit.)
 * 
 * Return a list of booleans answer, where answer[i] is true if and only if N_i
 * is divisible by 5.
 * 
 * Example 1:
 * 
 * Input: [0,1,1] Output: [true,false,false] 
 * Explanation: The input numbers in
 * binary are 0, 01, 011; which are 0, 1, and 3 in base-10. Only the first
 * number is divisible by 5, so answer[0] is true. 
 * 
 * Example 2:
 * 
 * Input: [1,1,1] Output: [false,false,false] 
 * 
 * Example 3:
 * 
 * Input: [0,1,1,1,1,1] Output: [true,false,false,false,true,false] 
 * 
 * Example 4:
 * 
 * Input: [1,1,1,0,1] Output: [false,false,false,false,false]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 30000 
 * A[i] is 0 or 1
 * 
 * 
 * 
 */
public class BinaryPrefix {

	public static List<Boolean> prefixesDivBy5(int[] a) {
		int n = a.length;
		List<Boolean> res = new ArrayList<>();
		int num = 0;
		int idx = 0;
		for (int i = 0; i < n; i++) {
			num = 2 * num + a[i];
			if (num == 0) {
				res.add(true);
			}else {
				res.add(num % 5 == 0);
			}
			if (num >= 5) {
				idx = i;
				break;
			}
		}
		if (idx == 0) {
			return res;
		}
		// num > 5
		idx ++;
		int mod = num % 5;
		while (idx < n) {
			if (a[idx] == 0) {
				mod = (2 * mod) % 5;
			}else {
				mod = (2 * mod + 1) % 5;
			}
			res.add(mod % 5 == 0);
			idx ++;
		}
		
		
		return res;

	}

	public static void main(String[] arg) {

		int[] a = {0,1,1};
		System.out.println(prefixesDivBy5(a));

		int[] a1 = {1,1,1};
		System.out.println(prefixesDivBy5(a1));

		int[] a2 = {0,1,1,1,1,1};
		System.out.println(prefixesDivBy5(a2));

		int[] a3 = {1,1,1,0,1};
		System.out.println(prefixesDivBy5(a3));

		
	}

}
