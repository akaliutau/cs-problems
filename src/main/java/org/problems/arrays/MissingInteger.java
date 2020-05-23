package org.problems.arrays;

import java.util.Arrays;

/**
 * Given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * 
 */
public class MissingInteger {

	public int solution(int[] a) {
		Arrays.sort(a);
		int idx = -1;

		int smallest = 0;
		int prev = 0;
		while (++idx < a.length) {
			if (a[idx] > 0) {
				int delta = a[idx] - prev;
				if (delta > 1) {// prev+1 omitted
					smallest = prev + 1;
					break;
				}
				prev = a[idx];
			}
		}
		if (smallest == 0) {
			smallest = a[a.length - 1] <= 0 ? 1 : a[a.length - 1] + 1;
		}
		return smallest;
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
