package org.problems.active;

/**
 * https://leetcode.com/problems/uncrossed-lines/
 * 
 * We write the integers of A and B (in the order they are given) on two
 * separate horizontal lines.
 * 
 * Now, we may draw connecting lines: a straight line connecting two numbers
 * A[i] and B[j] such that:
 * 
 * A[i] == B[j]; The line we draw does not intersect any other connecting
 * (non-horizontal) line. Note that a connecting lines cannot intersect even at
 * the endpoints: each number can only belong to one connecting line.
 * 
 * Return the maximum number of connecting lines we can draw in this way.
 * 
 * Example 1 
 * Input: A = [1,4,2], B = [1,2,4] Output: 2 
 * Explanation: We can draw
 * 2 uncrossed lines as in the diagram. We cannot draw 3 uncrossed lines,
 * because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to
 * B[1]=2. 
 * 
 * Example 2:
 * 
 * Input: A = [2,5,1,2,5], 
 *        B = [10,5,2,1,5,2] Output: 3 
 * 
 * Example 3:
 * 
 * Input: A = [1,3,7,1,7,5], 
 *        B = [1,9,2,5,1]    Output: 2
 * 
 *   2---------2
 *       5-5
 *       5----------5
 */
public class sol118 {
	
	/**
	 * 	always choose center in the same half
	 */
	static class Interval {
		public int edgeA;
		public int edgeB;
		
		public Interval(int edgeA, int edgeB) {
			this.edgeA = edgeA;
			this.edgeB = edgeB;
		}
		
	}

	public boolean canIWin(int[] a, int[] b) {
		
		

		return false;
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
