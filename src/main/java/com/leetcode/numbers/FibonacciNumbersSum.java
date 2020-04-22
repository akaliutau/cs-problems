package com.leetcode.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 * 
 * Given the number k, return the minimum number of Fibonacci numbers whose sum
 * is equal to k, whether a Fibonacci number could be used multiple times.
 * 
 * The Fibonacci numbers are defined as:
 * 
 * F1 = 1 F2 = 1 Fn = Fn-1 + Fn-2 , for n > 2. It is guaranteed that for the
 * given constraints we can always find such fibonacci numbers that sum k
 * 
 * 
 * 
 */
public class FibonacciNumbersSum {

	public static void fibonacci(List<Integer> lst, int k) {
		int i = 3;
		int next = 0;

		lst.add(0);
		lst.add(1);
		lst.add(1);

		while (true) {
			next = lst.get(i - 1) + lst.get(i - 2);
			if (next > k) {
				return;
			}
			lst.add(next);
			i++;
		}
	}

	public static int findMinFibonacciNumbers(int k) {

		List<Integer> lst = new ArrayList<Integer>();
		fibonacci(lst, k);

		int count = 0;
		int j = lst.size() - 1;

		while (k > 0) {
			count += (k / lst.get(j));
			k %= lst.get(j);
			j--;
		}
		return count;

	}

	public static void main(String[] arg) {

		System.out.println(findMinFibonacciNumbers(19));

	}

}
