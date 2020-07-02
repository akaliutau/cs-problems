package org.problems.numbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 * 
 * The power of an integer x is defined as the number of steps needed to
 * transform x into 1 using the following steps:
 * 
 * if x is even then x = x / 2 if x is odd then x = 3 * x + 1 For example, the
 * power of x = 3 is 7 because 3 needs 7 steps to become 1 (3 --> 10 --> 5 -->
 * 16 --> 8 --> 4 --> 2 --> 1).
 * 
 * Given three integers lo, hi and k. The task is to sort all integers in the
 * interval [lo, hi] by the power value in ascending order, if two or more
 * integers have the same power value sort them by ascending order.
 * 
 * Return the k-th integer in the range [lo, hi] sorted by the power value.
 * 
 * Notice that for any integer x (lo <= x <= hi) it is guaranteed that x will
 * transform into 1 using these steps and that the power of x is will fit in 32
 * bit signed integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: lo = 12, hi = 15, k = 2 Output: 13 Explanation: The power of 12 is 9
 * (12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1) The power of 13
 * is 9 The power of 14 is 17 The power of 15 is 17
 * 
 * 
 * 
 */
public class SortIntegersbyPower {

	static class Sorted {
		public int val;
		public int power = 0;

		public Sorted(int val) {
			this.val = val;
		}

		public void calcPower() {
			int i = val;
			while (i > 1) {
				power++;
				if (i % 2 == 0) {
					i = i / 2;
				} else {
					i = 3 * i + 1;
				}
			}

		}

		@Override
		public String toString() {
			return "Sorted [val=" + val + ", power=" + power + "]";
		}
	}

	public static int getKth(int lo, int hi, int k) {
		int total = hi - lo + 1;
		List<Sorted> arr = new ArrayList<>();
		for (int i = lo; i <= hi; i++) {
			Sorted elem = new Sorted(i);
			elem.calcPower();
			arr.add(elem);
		}
		Comparator<Sorted> sortByPower = (o, p) -> Integer.compare(o.power, p.power);// asc
		Comparator<Sorted> sortByVal = (o, p) -> Integer.compare(o.val, p.val);// asc
		arr.sort(sortByPower.thenComparing(sortByVal));
		System.out.println(arr);
		return arr.get(k - 1).val;

	}

	public static void main(String[] arg) {

		System.out.println(getKth(7, 11, 4));

	}

}
