package org.problems.geometry;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/construct-the-rectangle/
 * 
 * For a web developer, it is very important to know how to design a web page's
 * size. So, given a specific rectangular web page’s area, your job by now is to
 * design a rectangular web page, whose length L and width W satisfy the
 * following requirements:
 * 
 * 1. The area of the rectangular web page you designed must equal to the given
 * target area.
 * 
 * 2. The width W should not be larger than the length L, which means L >= W.
 * 
 * 3. The difference between length L and width W should be as small as
 * possible. You need to output the length L and the width W of the web page you
 * designed in sequence.
 * 
 * Example: Input: 4 Output: [2, 2] Explanation: The target area is 4, and all
 * the possible ways to construct it are [1,4], [2,2], [4,1]. But according to
 * requirement 2, [1,4] is illegal; according to requirement 3, [4,1] is not
 * optimal compared to [2,2]. So the length L is 2, and the width W is 2.
 * 
 * Note: The given area won't exceed 10,000,000 and is a positive integer The
 * web page's width and length you designed must be positive integers.
 * 
 * 
 */
public class ConstructRectangle {

	public static int[] constructRectangle(int area) {
		int[] res = new int[2];
		if (area == 0) {
			return res;
		}
		if (area == 1) {
			return new int[] { 1, 1 };
		}
		int w = (int) Math.sqrt(area);
		int diff = Integer.MAX_VALUE;
		int l = 0;
		for (int i = 1; i <= w + w / 2; i++) {
			if (area % i == 0) {
				l = area / i;
				if (Math.abs(i - l) < diff) {
					diff = Math.abs(i - l);
					res[0] = l;
					res[1] = i;
				}
			}
		}
		return res;
	}

	public static void main(String[] arg) {

		Utils.print(constructRectangle(1));
		Utils.print(constructRectangle(4));
		Utils.print(constructRectangle(6));
		Utils.print(constructRectangle(9));
		Utils.print(constructRectangle(300));

	}

}
