package org.problems.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/create-maximum-number/
 * 
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two. The
 * relative order of the digits from the same array must be preserved. Return an
 * array of the k digits.
 * 
 * Note: You should try to optimize your time and space complexity.
 * 
 * Example 1:
 * 
 * Input: nums1 = [3, 4, 6, 5] nums2 = [9, 1, 2, 5, 8, 3] k = 5 
 * Output: [9, 8, 6, 5, 3]
 * 
 * Example 2:
 * 
 * Input: nums1 = [6, 7] nums2 = [6, 0, 4] k = 5 
 * Output: [6, 7, 6, 0, 4]
 * 
 * Example 3:
 * 
 * Input: nums1 = [3, 9] nums2 = [8, 9] k = 3 
 * Output: [9, 8, 9]
 * 
 */
public class MaximumNumber2 {

	static String print(Digit[] num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length; i++) {
			if (num[i] != null)
				sb.append(num[i].toString());
		}
		return sb.toString();
	}

	static class Digit {
		public int pos;
		public int num;
		public Digit prev;
		public Digit next;

		public Digit(int pos, int num) {
			this.pos = pos;
			this.num = num;
		}

		@Override
		public String toString() {
			return "[pos=" + pos + ", n=" + num + ", prev=" + (prev != null ? prev.num : -1) + ", next="
					+ (next != null ? next.num : -1) + "]";
		}

	}

	static class Number {

		static Comparator<Digit> byNum = (o, p) -> Integer.compare(p.num, o.num);// desc

		public int n;
		public Digit[] num;

		public Number(int[] nums) {
			n = nums.length;
			num = new Digit[n];
			// create wrappers
			for (int i = 0; i < n; i++) {
				num[i] = new Digit(i, nums[i]);
			}
			// link all digits
			for (int i = 0; i < n; i++) {
				if (i > 0) {
					num[i].prev = num[i - 1];
				}
				if (i < n - 1) {
					num[i].next = num[i + 1];
				}
			}
		}

		public void sort() {
			Arrays.sort(num, byNum);
		}

		public boolean hasNext() {
			return false;
		}

		public int next(int numb, int pos) {
			int idx = pos;
			if (idx < 0) {
				return n > 0 ? 0 : -1;
			}
			while (++idx < n) {
				if (num[idx].pos > num[idx-1].pos && num[idx].num >= numb) {
					return idx;
				}
			}
			// there are no digits satisfying conditions
			return -1;
		}

		@Override
		public String toString() {
			return print(num);
		}

	}

	static class Candidate implements Comparable<Candidate> {
		public Digit[] digits;

		public Candidate(Digit[] digits) {
			this.digits = digits;
		}

		@Override
		public String toString() {
			return "Candidate [digits=" + (digits == null ? "" : Arrays.toString(digits)) + "]";
		}

		@Override
		public int compareTo(Candidate other) {
			for (int i = 0; i < digits.length; i++) {
				if (digits[i].num < other.digits[i].num) {
					return 1;
				} else if (digits[i].num > other.digits[i].num) {
					return -1;
				}
			}
			return 0;
		}

	}

	/**
	 * Extracts k digits from Digit array
	 * @param n
	 * @param k
	 * @return
	 */
	static int[] render(Digit[] num, int k) {
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = num[i].num;
		}
		return res;
	}

	static Digit[] clone(Digit[] arr) {
		return arr;

	}
	
	static void find(Digit[] holder, Number left, Number right, int posL, int posR, int k, Candidate result) {
		
	}
	

	public static int[] maxDigit(int[] nums1, int[] nums2, int k) {
		int n = nums1.length;
		int m = nums2.length;

		Number n1 = new Number(nums1);
		Number n2 = new Number(nums2);
		n1.sort();
		n2.sort();

		Digit[] maxDigit = new Digit[n + m];
		Candidate candidate = new Candidate(maxDigit);
		find(maxDigit, n1, n2, 0, 0, k, candidate);
		
		System.out.println("n1=" + n1);
		System.out.println("n2=" + n2);
		System.out.println(print(maxDigit));
		return nums2;

	}

	public static void main(String[] arg) {

		int[] numsa = { 9, 0, 4, 3 };
		int[] numsb = { 1, 8, 6 };
		Utils.print(maxDigit(numsa, numsb, 7));

		int[] nums1 = { 3, 4, 6, 5 };
		int[] nums2 = { 9, 1, 2, 5, 8, 3 };
		Utils.print(maxDigit(nums1, nums2, 5));

		int[] nums1a = { 6, 7 };
		int[] nums2a = { 6, 0, 4 };
		Utils.print(maxDigit(nums1a, nums2a, 5));

		int[] nums1b = { 3, 9 };
		int[] nums2b = { 8, 9 };
		Utils.print(maxDigit(nums1b, nums2b, 3));

	}

}
