package org.problems.matricies;

/**
 * https://leetcode.com/problems/image-overlap/
 * 
 * Two images A and B are given, represented as binary, square matrices of the
 * same size. (A binary matrix has only 0s and 1s as values.)
 * 
 * We translate one image however we choose (sliding it left, right, up, or down
 * any number of units), and place it on top of the other image. After, the
 * overlap of this translation is the number of positions that have a 1 in both
 * images.
 * 
 * (Note also that a translation does not include any kind of rotation.)
 * 
 * What is the largest possible overlap?
 * 
 * 
 */
public class ImageOverlap {
	/**
	 * 
	 * @param a
	 * @param b
	 * @param dx: defines eq: a_x = b_x + dx
	 * @return
	 */
	static int overlap(int[][] a, int[][] b, int dx, int dy) {
		int overlap = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int ax = i + dx;
			if (ax < 0 && ax >= n) {
				continue;
			}
			for (int j = 0; j < n; j++) {
				int ay = j + dy;
				if (ay < 0 && ay >= n) {
					continue;
				}
				if (a[ax][ay] == b[i][j]) {
					overlap++;
				}
			}
		}
		return overlap;
	}

	public int largestOverlap(int[][] a, int[][] b) {
		int n = a.length;
		int maxOverlap = 0;
		for (int dx = -n + 1; dx < n; dx++) {
			for (int dy = -n + 1; dy < n; dy++) {
				maxOverlap = Math.max(maxOverlap, overlap(a, b, dx, dy));
			}
		}
		return maxOverlap;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
