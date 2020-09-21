package org.problems.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/sequential-digits/
 * 
 * An integer has sequential digits if and only if each digit in the number is
 * one more than the previous digit.
 * 
 * Return a sorted list of all the integers in the range [low, high] inclusive
 * that have sequential digits.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: low = 100, high = 300 
 * Output: [123,234]
 * 
 */
public class SequentialDigits {
	
	static List<Integer> getSeqNumber(int n) {
		List<Integer> nums = new ArrayList<>();
		int dig = 1;
		for (int i = dig; i < 10 - n + 1; i++) {
			char[] digits = new char[n];
			for (int j = 0; j < n; j++) {
				digits[j] = (char)('0' + i + j);
			}
			nums.add(Integer.valueOf(new String(digits)));
		}
		return nums;
	}
	
	static int length(int i) {
		if (i < 10) {
			return 1;
		}
		return (int)(Math.log10(i) + 1);
	}

	public static List<Integer> sequentialDigits(int low, int high) {
		int lenLow = length(low);
		int lenHigh = length(high);
		List<Integer> res = new ArrayList<>();
		for (int len = lenLow; len <= lenHigh; len++) {
			res.addAll(getSeqNumber(len));
		}
		
		return res.stream().filter(i -> i >= low && i <= high).collect(Collectors.toList());
	}

	public static void main(String[] arg) {
		System.out.println(sequentialDigits(100,300));
	}

}
