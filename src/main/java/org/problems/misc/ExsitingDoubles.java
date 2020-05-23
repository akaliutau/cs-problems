package org.problems.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */
public class ExsitingDoubles {

	public static boolean checkIfExist(int[] arr) {
		Set<Integer> doubles = new HashSet<Integer>();
		Set<Integer> dupl = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0 && doubles.contains(0)) {
				return true;
			}
			doubles.add(arr[i]);
			if (arr[i] != 0 && doubles.contains(2 * arr[i])) {
				return true;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0 && doubles.contains(2 * arr[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] arg) {

		int[] arr = { 10, 2, 5, 3 };
		boolean res = checkIfExist(arr);

		System.out.print(res);

	}

}
