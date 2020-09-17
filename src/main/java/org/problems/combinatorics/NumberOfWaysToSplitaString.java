package org.problems.combinatorics;

/**
 * https://leetcode.com/problems/number-of-ways-to-split-a-string/
 * 
 * Given a binary string s (a string consisting only of '0's and '1's), we can
 * split s into 3 non-empty strings s1, s2, s3 (s1+ s2+ s3 = s).
 * 
 * Return the number of ways s can be split such that the number of characters
 * '1' is the same in s1, s2, and s3.
 * 
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "10101" Output: 4 Explanation: There are four ways to split s in 3
 * parts where each part contain the same number of letters '1'. "1|010|1"
 * "1|01|01" "10|10|1" "10|1|01"
 * 
 */
public class NumberOfWaysToSplitaString {

	public int numWays(String s) {
		int n = s.length();
		int count = 0;
		char[] chs = s.toCharArray();
		for (int i = 0; i < n; i++) {
			count += (chs[i] - '0');
		}
		if (count % 3 != 0) {
			return 0;
		}
		long l1 = 1;
		long l2 = 1;
		if (count == 0) {
			l1 = n - 2;
			l2 = n - 2;
		} else {
			int c = 0;
			int l = 0;
			while (c < count / 3) {
				c += (chs[l++] - '0');
			}
			while (chs[l++] == '0') {
				l1++;
			}
			c = 0;
			int r = n - 1;
			while (c < count / 3) {
				c += (chs[r--] - '0');
			}
			while (chs[r--] == '0') {
				l2++;
			}
		}

		long res = l1 * l2;
		return (int) (res % 1000000007);

	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
