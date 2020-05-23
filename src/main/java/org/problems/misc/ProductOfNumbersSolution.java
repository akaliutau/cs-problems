package org.problems.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 *
 * mplement the class ProductOfNumbers that supports two methods:
 * 
 * 1. add(int n)
 * 
 * Adds the number n to the back of the current list of numbers. 2.
 * getProduct(int k)
 * 
 * Returns the product of the last k numbers in the current list. You can assume
 * that always the current list has at least k numbers. At any time, the product
 * of any contiguous sequence of numbers will fit into a single 32-bit integer
 * without overflowing.
 * 
 * 
 * Runtime: 23 ms, faster than 25.00% of Java online submissions for Product of
 * the Last K Numbers. Memory Usage: 75 MB, less than 100.00% of Java online
 * submissions for Product of the Last K Numbers
 */
public class ProductOfNumbersSolution {

	static class ProductOfNumbers {
		List<Integer> list;
		List<Integer> dup;
		int last = 1;
		int lastCounter = 1;
		int lastZero = -1;
		int pos = 0;

		public ProductOfNumbers() {
			list = new ArrayList<>();
			dup = new ArrayList<>();
		}

		public void add(int num) {
			if (last == num) {
				lastCounter++;
			} else {
				list.add(last);
				dup.add(lastCounter);
				last = num;
				lastCounter = 1;
			}
			if (num == 0) {
				lastZero = pos;
			}
			pos++;
		}

		public int getProduct(int k) {
			int p = 1;
			int i = 1;
			int size = list.size();

			if (k == 0 || pos - lastZero <= k) {
				return 0;
			}
			if (k <= lastCounter) {
				return last == 1 ? 1 : (int) Math.pow(last, k);
			}
			p = (int) Math.pow(last, lastCounter);
			k -= lastCounter;
			while (k > 0) {
				int num = list.get(size - i);
				int rep = dup.get(size - i);
				if (k <= rep) {
					return p * (num == 1 ? 1 : (int) Math.pow(num, k));
				}
				p *= (int) Math.pow(num, rep);
				k -= rep;
				i++;
			}
			return p;
		}
	}

	public static void main(String[] arg) {

		ProductOfNumbers productOfNumbers = new ProductOfNumbers();
		productOfNumbers.add(3); // [3]
		productOfNumbers.add(0); // [3,0]
		productOfNumbers.add(2); // [3,0,2]
		productOfNumbers.add(5); // [3,0,2,5]
		productOfNumbers.add(4); // [3,0,2,5,4]
		int res1 = productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
		int res2 = productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
		int res3 = productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
		productOfNumbers.add(8); // [3,0,2,5,4,8]
		int res4 = productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
		System.out.println(res4);
	}

}
