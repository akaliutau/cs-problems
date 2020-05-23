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
public class MaximumNumber {
	
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
		public boolean added;
		
		public Digit(int pos, int num) {
			this.pos = pos;
			this.num = num;
		}

		@Override
		public String toString() {
			return "[pos=" + pos + ", n=" + num + ", prev=" + (prev != null ? prev.num: -1) + ", next=" + (next != null ? next.num: -1) + "]";
		}
		
	}
	
	static class Number {
		
		static Comparator<Digit> byNum = (o,p) -> Integer.compare(p.num, o.num);// desc

		public int n;
		public Digit[] num;
		public int idx = 0;
		public int lastPos = -1;
		
		public Number (int[] nums) {
			n = nums.length;
			num = new Digit[n];
			// create wrappers
			for (int i = 0; i < n; i++) {
				num[i] = new Digit(i,nums[i]);
			}
			// link all digits
			for (int i = 0; i < n; i++) {
				if (i > 0) {
					num[i].prev = num[i-1];
				}
				if (i < n-1) {
					num[i].next = num[i+1];
				}
			}
		}
		
		public void sort() {
			Arrays.sort(num,byNum);
		}
		
		public boolean hasNext() {
			if (idx == 0) {
				return n > 0;
			}
			if (idx > n-1) {
				return false;
			}
			while (idx < n) {
//				System.out.println("lastPos="+lastPos+", n.pos"+n[idx].pos);
				if (num[idx].pos > lastPos) {
					return true;
				}
				idx++;
			}
			return false;
		}
		
		public Digit next() {
//			System.out.println("lastPos="+lastPos+", n.pos"+n[idx].pos);
			lastPos = num[idx].pos;
			num[idx].added = true;
			return num[idx++];
		}
		
		public List<Digit> getRest(){
			List<Digit> arr = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (!num[i].added) {
					arr.add(num[i]);
				}
			}
			return arr;
		}

		@Override
		public String toString() {
			return print(num);
		}
		
	}
	
	static class Candidate implements Comparable<Candidate>{
		public Digit[] num;
		public Digit digit;
		
		public Candidate(Digit[] digits, Digit digit, int size) {
//			System.out.println(" insert" + digit);
			num = compose(digits, digit, size);
			this.digit = digit;
		}

		public Candidate(Digit[] digits, Digit digit, int size, boolean add) {
//			System.out.println(" insert" + digit);
			num = compose(digits, digit, size);
			this.digit = digit;
		}

		private Digit[] compose(Digit[] maxDigit, Digit d, int len) {
			Digit[] res = new Digit[len];
			int idx = 0;
			int n = maxDigit.length;
			boolean inserted = false;
			for (int i = 0; i < n; i++) {
				Digit digit = maxDigit[i];
				if (digit == null) {
					return inserted ? res : null;
				}
				if (digit == d.prev && !inserted) {
					res[idx++] = digit;
					res[idx++] = d;
					inserted = true;
				}else if (digit == d.next && !inserted) {
					res[idx++] = d;
					res[idx++] = digit;
					inserted = true;
				}else {
					res[idx++] = digit;
				}
			}
			return inserted ? res : null;
		}

		@Override
		public String toString() {
			return "Candidate [n=" + (num == null ? "" : Arrays.toString(num)) + "]";
		}

		@Override
		public int compareTo(Candidate other) {
			for (int i = 0; i < num.length; i++) {
				if (num[i].num < other.num[i].num) {
					return 1;
				} else if (num[i].num > other.num[i].num) {
					return -1;
				}
			}
			return 0;
		}
		
	}
	
	static int[] render(Digit[] num, int k) {
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = num[i].num;
		}
		return res;
	}
	
	// if d1 == d2, add all variants
	static void process(List<Digit[]> lst, Digit d1, Digit d2 ) {
		
	}
	
	static Digit[] clone(Digit[] arr) {
		return arr;
		
	}

	public static int[] maxDigit(int[] nums1, int[] nums2, int k) {
		int n = nums1.length;
		int m = nums2.length;
		
		Number n1 = new Number(nums1);
		Number n2 = new Number(nums2);
		n1.sort();
		n2.sort();

		Digit[] maxDigit = new Digit[n+m];
		int idx = 0;
		Digit d1 = null, d2 = null;
		while (true) {
			if (d1 == null && n1.hasNext()) {
				d1 = n1.next();
			}
			if (d2 == null && n2.hasNext()) {
				d2 = n2.next();
			}
			if (d1 != null && d2 != null) {
				if (d1.num >= d2.num) {// TODO save all variants with equals digits
					maxDigit[idx++] = d1;
					d1 = null;
				}else {
					maxDigit[idx++] = d2;
					d2 = null;
				}
			}else if (d1 != null){
				maxDigit[idx++] = d1;
				d1 = null;
			}else if (d2 != null){
				maxDigit[idx++] = d2;
				d2 = null;
			}else {
				break;
			}
		}
		System.out.println("n1="+n1);
		System.out.println("n2="+n2);
		System.out.println(print(maxDigit));
		
		// process left elems
		int right = 0;
		while (maxDigit[right] != null) {
			right++;
		}
		// if collected digits <= k return result
		if (right >= k) {
			return render(maxDigit,k);
		}
		// [0,right) contains max number
		// also create a set
		Set<Digit> left = new HashSet<>();
		left.addAll(n1.getRest());
		left.addAll(n2.getRest());
		while (right < k) {
			System.out.println(" ======= left =========");
			System.out.println(left);
//			System.out.println(" ======= " + right + " =========");
			List<Candidate> cands = new ArrayList<>();
			for (Digit d : left) {
				Candidate c = new Candidate(maxDigit, d, right+1);
				if (c.num != null)
					cands.add(c);
			}
			System.out.println("Candidates:"+cands);
			Collections.sort(cands);
//			System.out.println("biggest is "+cands.get(0));
			right ++;
			maxDigit = cands.get(0).num;
			left.remove(cands.get(0).digit);
		}
		return render(maxDigit,k);
        
    }

	public static void main(String[] arg) {
		
		int[] nums1 = {3, 4, 6, 5};
		int[] nums2 = {9, 1, 2, 5, 8, 3};
		Utils.print(maxDigit(nums1, nums2, 5));

		int[] nums1a = {6, 7};
		int[] nums2a = {6, 0, 4};
		Utils.print(maxDigit(nums1a, nums2a, 5));

		int[] nums1b = {3, 9};
		int[] nums2b = {8, 9};
		Utils.print(maxDigit(nums1b, nums2b, 3));

	}

}
