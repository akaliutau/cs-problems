package org.problems.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/ones-and-zeroes/
 * 
 * Given an array, strs, with strings consisting of only 0s and 1s. Also two
 * integers m and n.
 * 
 * Now your task is to find the maximum number of strings that you can form with
 * given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * 
 * Example 1:
 * 
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3 Output: 4
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s
 * and 3 1s, which are "10","0001","1","0". 
 * 
 * Example 2:
 * 
 * Input: strs = ["10","0","1"], m = 1, n = 1 Output: 2 
 * Explanation: You could
 * form "10", but then you'd have nothing left. Better form "0" and "1".
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 600 
 * 1 <= strs[i].length <= 100 
 * strs[i] consists only of digits '0' and '1'. 
 * 1 <= m, n <= 100
 * 
 * Runtime: 12 ms, faster than 99.41% of Java online submissions for Ones and Zeroes.
 * Memory Usage: 39 MB, less than 68.77% of Java online submissions for Ones and Zeroes.
 */
public class OnesAndZeroesI {
	
	static class Str {
		public int zeros = 0;
		public int ones = 0;
		public int len = 0;
		public boolean taken = false;
		
		public Str(String s) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					zeros ++;
				}else {
					ones ++;
				}
			}
			len = ones + zeros;
		}

		@Override
		public String toString() {
			return "Str [zeros=" + zeros + ", ones=" + ones + ", taken=" + taken + "]";
		}
		
	}
	
	public static int findMaxForm1(String[] strs, int m, int n) {
		
		int len = strs.length;
		Str[] strings = new Str[len];
		for (int i = 0; i < len; i++) {
			strings[i] = new Str(strs[i]);
		}
		Str[] ones = strings.clone();
		Str[] zeros = strings.clone();
		int oneIdx = 0;
		int zeroIdx = 0;
		Comparator<Str> byOne = (o,p) -> Integer.compare(o.ones, p.ones);
		Comparator<Str> byZero = (o,p) -> Integer.compare(o.zeros, p.zeros);
		Arrays.parallelSort(ones, byOne);
		Arrays.parallelSort(zeros, byZero);

		int counter = 0;
		while (m >= 0 && n >= 0) {
			boolean found = false;
			if (m > n) {// find string with min number of 1
				oneIdx = 0;
				while (oneIdx < len) {
					Str s = ones[oneIdx];
					oneIdx ++;
					if (s.taken) {
						continue;
					}
					if (s.ones <= n && s.zeros <= m) {
						s.taken = true;
						n -= s.ones;
						m -= s.zeros;
						counter ++;
						found = true;
						break;
					}
				}
			}else {
				zeroIdx = 0;
				while (zeroIdx < len) {
					Str s = zeros[zeroIdx];
					zeroIdx ++;
					if (s.taken) {
						continue;
					}
					if (s.ones <= n && s.zeros <= m) {
						s.taken = true;
						n -= s.ones;
						m -= s.zeros;
						found = true;
						counter ++;
						break;
					}
				}
			}
			if (!found) {
				break;
			}
		}
		
		return counter;

	}


	public static int findMaxForm2(String[] strs, int m, int n) {
		
		int len = strs.length;
		Str[] strings = new Str[len];
		for (int i = 0; i < len; i++) {
			strings[i] = new Str(strs[i]);
		}
		Str[] ones = strings.clone();
		Str[] zeros = strings.clone();
		int oneIdx = 0;
		int zeroIdx = 0;
		Comparator<Str> byLen = (o,p) -> Integer.compare(o.len, p.len);
		Comparator<Str> byOne = (o,p) -> Integer.compare(o.ones, p.ones);
		Comparator<Str> byZero = (o,p) -> Integer.compare(o.zeros, p.zeros);
		Arrays.parallelSort(ones, byLen.thenComparing(byOne));
		Arrays.parallelSort(zeros, byLen.thenComparing(byZero));
		int counter = 0;
		while (m >= 0 && n >= 0) {
			boolean found = false;
			if (m > n) {// find string with min number of 1
				oneIdx = 0;
				while (oneIdx < len) {
					Str s = ones[oneIdx];
					oneIdx ++;
					if (s.taken) {
						continue;
					}
					if (s.ones <= n && s.zeros <= m) {
						s.taken = true;
						n -= s.ones;
						m -= s.zeros;
						counter ++;
						found = true;
						break;
					}
				}
			}else {
				zeroIdx = 0;
				while (zeroIdx < len) {
					Str s = zeros[zeroIdx];
					zeroIdx ++;
					if (s.taken) {
						continue;
					}
					if (s.ones <= n && s.zeros <= m) {
						s.taken = true;
						n -= s.ones;
						m -= s.zeros;
						found = true;
						counter ++;
						break;
					}
				}
			}
			if (!found) {
				break;
			}
		}
		
		return counter;

	}
	
	public static int findMaxForm3(String[] strs, int m, int n) {
		
		int len = strs.length;
		Str[] strings = new Str[len];
		for (int i = 0; i < len; i++) {
			strings[i] = new Str(strs[i]);
		}
		Str[] ones = strings.clone();
		Str[] zeros = strings.clone();
		int oneIdx = 0;
		int zeroIdx = 0;
		Comparator<Str> byOne = (p,o) -> Integer.compare(o.ones, p.ones);
		Comparator<Str> byZero = (p,o) -> Integer.compare(o.zeros, p.zeros);
		Arrays.parallelSort(ones, byOne);
		Arrays.parallelSort(zeros, byZero);

		int counter = 0;
		while (m >= 0 && n >= 0) {
			boolean found = false;
			if (m > n) {// find string with min number of 1
				oneIdx = 0;
				while (oneIdx < len) {
					Str s = ones[oneIdx];
					oneIdx ++;
					if (s.taken) {
						continue;
					}
					if (s.ones <= n && s.zeros <= m) {
						s.taken = true;
						n -= s.ones;
						m -= s.zeros;
						counter ++;
						found = true;
						break;
					}
				}
			}else {
				zeroIdx = 0;
				while (zeroIdx < len) {
					Str s = zeros[zeroIdx];
					zeroIdx ++;
					if (s.taken) {
						continue;
					}
					if (s.ones <= n && s.zeros <= m) {
						s.taken = true;
						n -= s.ones;
						m -= s.zeros;
						found = true;
						counter ++;
						break;
					}
				}
			}
			if (!found) {
				break;
			}
		}
		
		return counter;

	}

	
	public static int findMaxForm(String[] strs, int m, int n) {
		return Math.max(
				findMaxForm1(strs, m, n),
				Math.max(
						findMaxForm2(strs, m, n),
						findMaxForm3(strs, m, n)
						)
				);
	}

	public static void main(String[] arg) {
		
		String[] strs = {"10","0001","111001","1","0"};
		System.out.println(findMaxForm(strs, 5, 3));

		String[] strs1 = {"10","0","1"};
		System.out.println(findMaxForm(strs1, 1, 1));

		String[] strs2 = {"10","0"};
		System.out.println(findMaxForm(strs2, 1, 2));

		String[] strs3 = {"111","1000","1000","1000"};
		System.out.println(findMaxForm(strs3, 9, 3));


	}

}
