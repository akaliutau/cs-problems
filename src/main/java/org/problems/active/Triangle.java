package org.problems.active;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/triangle/
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [ [2], [3,4], [6,5,7], [4,1,8,3] ] The minimum path sum from top to bottom is
 * 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 * 
 */
public class Triangle {
	
	public int minimumTotal(List<List<Integer>> triangle) {
		
		
		return 0;
    }


	public static void main(String[] arg) {

		int[] arr = {};

		List<Integer> lst1 = Arrays.asList(1, 3, 2);
		List<Integer> lst2 = Arrays.asList(1, 2, 3);
		List<Integer> lst3 = Arrays.asList(1, 2);

		Set<Integer> set1 = new HashSet<>(lst1);
		Set<Integer> set2 = new HashSet<>(lst2);
		Set<Integer> set3 = new HashSet<>(lst3);

		System.out.println(set1.equals(set2));
		System.out.println(set1.equals(set3));
	}

}
