package org.problems.combinatorics;

/**
 * https://leetcode.com/problems/largest-time-for-given-digits/
 * 
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * 
 * The smallest 24 hour time is 00:00, and the largest is 23:59. Starting from
 * 00:00, a time is larger if more time has elapsed since midnight.
 * 
 * Return the answer as a string of length 5. If no valid time can be made,
 * return an empty string.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4] Output: "23:41" 
 * 
 * Example 2:
 * 
 * Input: [5,5,5,5] Output: ""
 * 
 * 
 * Note:
 * 
 * A.length == 4 
 * 0 <= A[i] <= 9
 * 
 * Runtime: 8 ms, faster than 78.44% of Java online submissions for Largest Time for Given Digits.
 * Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Largest Time for Given Digits.
 * 
 */
public class LargestTime {
	
	static int pickNumber(int[] a, int digit) {
		while (digit >= 0) {
			for (int i = 0; i < 4; i++) {
				if (a[i] == digit) {
					a[i] = -1;
					return digit;
				}
			}
			digit --;
		}
		return 0;
	}
	
	static boolean isValid(int[] a, int i, int j, int k, int l) {
		boolean valid = true;
		if (a[i] > 2) {
			return false;
		}
		if (a[i] == 2) {
			valid = a[j] >= 0 && a[j] <= 3;
		}else {
			valid = a[j] >= 0 && a[j] <= 9;
		}
		valid = valid && (a[k] >= 0 && a[k] <= 5 &&  a[l] >= 0 && a[l] <= 9);
		return valid;
	}

	public static String largestTimeFromDigits(int[] orig) {
		String temp = "%d%d:%d%d";
		int[] res = new int[4];
		int[] a = new int[4];
		for (int i = 0; i < 4; i++) {
			a[i] = orig[i];
		}		
		res[0] = pickNumber(a,2);
		if (res[0] == 2) {
			res[1] = pickNumber(a,3);
		}else {
			res[1] = pickNumber(a,9);
		}
		res[2] = pickNumber(a,5);
		res[3] = pickNumber(a,9);
		
		boolean notFound = false;
		for (int i = 0; i < 4; i++) {
			if (a[i] != -1) {
				notFound = true;
				break;
			}
		}
		
		if (!notFound) {
			return String.format(temp,res[0],res[1],res[2],res[3]);
		}
		// try brute force
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == j) {
					continue;
				}
				for (int k = 0; k < 4; k++) {
					if (j == k || k == i) {
						continue;
					}
					for (int l = 0; l < 4; l++) {
						if (k == l || l == i || l == j) {
							continue;
						}
//						System.out.println("che "+String.format(temp,orig[i],orig[j],orig[k],orig[l]));
						if (isValid(orig, i, j, k, l)) {
							return String.format(temp,orig[i],orig[j],orig[k],orig[l]);
						}
					}		
					
				}		
				
			}		
			
		}		
		
		return "";
	}

	public static void main(String[] arg) {

		int[] a = {1,2,3,4};
		System.out.println(largestTimeFromDigits(a));

		int[] a1 = {5,5,5,5};
		System.out.println(largestTimeFromDigits(a1));

		int[] a2 = {2,0,6,6};
		System.out.println(largestTimeFromDigits(a2));

	}

}
