package com.leetcode.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * Example:
 * 
 * Input: 5 Output: [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 */
public class PascalsTriangleI {

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lst = new ArrayList<>();
		if (numRows == 0) {
			return lst;
		}
		lst.add(Arrays.asList(1));
		if (numRows == 1) {
			return lst;
		}
		for (int i = 1; i < numRows; i++) {
			List<Integer> prev = lst.get(i - 1);
			List<Integer> line = new ArrayList<>();
			line.add(1);
			for (int j = 1; j < prev.size(); j++) {
				line.add(prev.get(j - 1) + prev.get(j));
			}
			line.add(1);
			lst.add(line);
		}

		return lst;

	}

	public static void main(String[] arg) {

		System.out.println(generate(1));
		System.out.println(generate(2));
		System.out.println(generate(4));
		System.out.println(generate(5));

	}
}
