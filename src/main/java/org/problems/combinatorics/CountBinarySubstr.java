package org.problems.combinatorics;

/**
 * https://leetcode.com/problems/count-binary-substrings/
 * 
 * Give a string s, count the number of non-empty (contiguous) substrings that
 * have the same number of 0's and 1's, and all the 0's and all the 1's in these
 * substrings are grouped consecutively.
 * 
 * Substrings that occur multiple times are counted the number of times they
 * occur.
 * 
 * Example 1: Input: "00110011" Output: 6 
 * Explanation: There are 6 substrings
 * that have equal number of consecutive 1's and 0's: "0011", "01", "1100",
 * "10", "0011", and "01".
 * 
 * Notice that some of these substrings repeat and are counted the number of
 * times they occur.
 * 
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are
 * not grouped together. 
 * 
 * Example 2: Input: "10101" Output: 4 
 * Explanation: There
 * are 4 substrings: "10", "01", "10", "01" that have equal number of
 * consecutive 1's and 0's. 
 * 
 * Note:
 * 
 * s.length will be between 1 and 50,000. 
 * s will only consist of "0" or "1" characters.
 * 
 */
public class CountBinarySubstr {
	
	public static int countBinarySubstrings(String s) {
		int n = s.length();
		if (n < 2) {
			return 0;
		}
		char c = s.charAt(0);
		int len = 1;
		for (int i = 1; i < n; i++) {
			if (c != s.charAt(i)) {
				len ++;
			}
			c = s.charAt(i);
		}
		// build histogramm
		int[][] stat = new int[len][2];
		int idx = 0;
		c = s.charAt(0);
		stat[idx][0] = c;
		stat[idx][1] = 1;
		for (int i = 1; i < n; i++) {
			if (c != s.charAt(i)) {
				idx ++;
				stat[idx][0] = s.charAt(i);
				stat[idx][1] = 0;
			}
			stat[idx][1] ++;
			c = s.charAt(i);
		}
		int counter = 0;
		for (int i = 0; i < len - 1; i++) {
			int blocks = Math.min(stat[i][1], stat[i+1][1]);
			counter += blocks;
		}

		
		return counter;
        
    }

	public static void main(String[] arg) {

		System.out.println(countBinarySubstrings("00110011"));
		System.out.println(countBinarySubstrings("10101"));

	}

}
