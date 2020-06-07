package org.problems.minmax;

import java.util.Arrays;

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

	public static int findContentChildren(int[] g, int[] s) {
		int n = g.length;
		int m = s.length;
		Arrays.sort(g);
		Arrays.sort(s);
		int content = 0;
		int idxS = 0;
		int idxG = 0;
		while (idxS < m && idxG < n) {
			if (s[idxS] >= g[idxG]) {
				content ++;
				idxS ++;
				idxG ++;
			}else {
				idxS ++;
			}
		}
		
		return content;

	}

	public static void main(String[] arg) {

		int[] g = {1,2,3};
		int[] s = {1,5};

		System.out.println(findContentChildren(g,s));

		int[] g1 = {10,9,8,7};
		int[] s1 = {5,6,7,8};

		System.out.println(findContentChildren(g1,s1));

	}

}
