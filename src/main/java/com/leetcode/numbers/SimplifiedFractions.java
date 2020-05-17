package com.leetcode.numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/simplified-fractions/
 * 
 */
public class SimplifiedFractions {

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static List<String> simplifiedFractions(int n) {

		Set<String> res = new HashSet<>();

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				int num = j;
				int denum = i;
				int dev = gcd(num, denum);
				res.add(String.format("%d/%d", num / dev, denum / dev));
			}
		}

		return new ArrayList<>(res);

	}

	public static void main(String[] arg) {

		System.out.println(simplifiedFractions(2));
		System.out.println(simplifiedFractions(3));
		System.out.println(simplifiedFractions(4));
		System.out.println(simplifiedFractions(1));

	}

}
