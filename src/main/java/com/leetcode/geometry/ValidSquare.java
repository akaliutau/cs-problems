package com.leetcode.geometry;

/**
 * https://leetcode.com/problems/valid-square/
 * 
 * Given the coordinates of four points in 2D space, return whether the four
 * points could construct a square.
 * 
 * The coordinate (x,y) of a point is represented by an integer array with two
 * integers.
 * 
 * Example:
 * 
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1] Output: True
 * 
 * 
 * Note:
 * 
 * All the input integers are in the range [-10000, 10000]. 
 * A valid square has four equal sides with positive length and 
 * four equal angles (90-degree angles). 
 * Input points have no order.
 * 
 * Runtime: 1 ms, faster than 79.94% of Java online submissions for Valid Square.
 * Memory Usage: 37.6 MB, less than 12.50% of Java online submissions for Valid Square
 */
public class ValidSquare {
	
	static final int X = 0;
	static final int Y = 1;
	
	static int sqr(int n) {
		return n * n;
	}
	
	static int dist(int[] p1, int[] p2) {
		return sqr(p1[X] - p2[X]) + sqr(p1[Y] - p2[Y]);
	}
	
	static int scalar(int[] p1, int[] p2) {
		return p1[X] * p2[X] + p1[Y] * p2[Y];
	}
	
	static int[] diff(int[] p1, int[] p2) {
		int[] res = new int[2];
		res[X] = p1[X] - p2[X];
		res[Y] = p1[Y] - p2[Y];
		return res;
	}

	
	static boolean isSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		// check scalar (p2-p1)(p3-p1)
		int sc = scalar(diff(p2,p1), diff(p3,p1));
		if (sc == 0 ){
			// check p12 == p34, p13=p24
			int dist12 = dist(p1,p2);
			int dist34 = dist(p3,p4);
			if (dist12 != dist34) {
				return false;
			}
			int dist13 = dist(p1,p3);
			int dist24 = dist(p2,p4);
			if (dist13 != dist24) {
				return false;
			}
			return dist12 == dist13 && dist12 > 0;
		}
		return false;
	}

	public static boolean validSquare(int[][] a) {
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == j) {
					continue;
				}
				for (int k = 0; k < 4; k++) {
					if (i == k || j == k) {
						continue;
					}
					for (int l = 0; l < 4; l++) {
						if (i == l || j == l || k == l) {
							continue;
						}
						int[] p1 = a[i];
						int[] p2 = a[j];
						int[] p3 = a[k];
						int[] p4 = a[l];
						if (isSquare(p1, p2, p3, p4)) {
							return true;
						}
						
					}
					
				}
				
			}
			
		}
		
		return false;
        
    }

	public static void main(String[] arg) {
		
		int[][] a = {
				{0,0},
				{0,1},
				{1,0},
				{1,1}
		};

		System.out.println(validSquare(a));
		
		int[][] a1 = {
				{1,0},
				{0,1},
				{2,1},
				{1,2}
		};

		System.out.println(validSquare(a1));

		int[][] a2 = {
				{1,0},
				{0,5},
				{-2,1},
				{1,2}
		};

		System.out.println(validSquare(a2));
		int[][] a3 = {
				{1134,-2539},
				{492,-1255},
				{-792,-1897},
				{-150,-3181}
		};
		System.out.println(validSquare(a3));//true

	}

}
