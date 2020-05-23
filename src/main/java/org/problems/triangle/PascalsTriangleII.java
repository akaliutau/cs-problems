package org.problems.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 */
public class PascalsTriangleII {

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> prev = new ArrayList<>();
		prev.add(1);
		if (rowIndex == 0) {
			return prev;
		}
		for (int i = 0; i < rowIndex; i++) {
			List<Integer> line = new ArrayList<>();
			line.add(1);
			for (int j = 1; j < prev.size(); j++) {
				line.add(prev.get(j - 1) + prev.get(j));
			}
			line.add(1);
			prev = line;
		}

		return prev;
	}

	public static void main(String[] arg) {

		System.out.println(getRow(1));
		System.out.println(getRow(3));
		System.out.println(getRow(12));

	}
}
