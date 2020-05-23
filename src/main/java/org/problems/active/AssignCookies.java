package org.problems.active;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/assign-cookies/
 *
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie. Each child i has a greed
 * factor gi, which is the minimum size of a cookie that the child will be
 * content with; and each cookie j has a size sj. If sj >= gi, we can assign the
 * cookie j to the child i, and the child i will be content. Your goal is to
 * maximize the number of your content children and output the maximum number.
 * 
 * Note: You may assume the greed factor is always positive. You cannot assign
 * more than one cookie to one child.
 * 
 * Example 1: Input: [1,2,3], [1,1]
 * 
 * Output: 1
 * 
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3
 * children are 1, 2, 3. And even though you have 2 cookies, since their size is
 * both 1, you could only make the child whose greed factor is 1 content. You
 * need to output 1.
 * 
 * 
 */
public class AssignCookies {

	public int findContentChildren(int[] g, int[] s) {

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
