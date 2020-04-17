package com.leetcode.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/
 *
 * Write a program that outputs the string representation of numbers from 1 to
 * n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 */
public class FizzBuzz {

	public static List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				res.add("FizzBuzz");
			}else if (i % 3 == 0) {
				res.add("Fizz");
			}else if (i % 5 == 0) {
				res.add("Buzz");
			}else {
				res.add(""+i);
			}
		}
		return res;
	}

	public static void main(String[] arg) {

		System.out.println(fizzBuzz(15));

	}
}
