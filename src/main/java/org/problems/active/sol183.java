package org.problems.active;

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
 * Example 1:
 * 
 * Input: 
 * A = [
 * [1,1,0], 
 * [0,1,0], 
 * [0,1,0]] 
 * 
 * B = [
 * [0,0,0], 
 * [0,1,1], 
 * [0,0,1]]
 * Output: 3 Explanation: We slide A to right by 1 unit and down by 1 unit.
 * Notes:
 * 
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30 
 * 0 <= A[i][j], B[i][j] <= 1
 * 
 */
public class sol183 {
	
	static int row2int(int[] row) {
		int num = 0;
		for(int i = row.length - 1; i > -1; i--) {
			if (row[i] == 1) {
				num ++;
			}
			num = num << 1;
		}
		return num;
	}
	
	
	static int getOverlap(int[][] a, int[][] b, int x, int y, int dx, int dy) {
		int total = 0;
		for (int i = 0; i < dx; i ++) {
			for (int j = 0; j < dy; j ++) {
				if (a[i][j] == 1 && b[i+x][j+y] == 1) {
					total ++;
				}
			}
		}
		return total;
	}

	public static int largestOverlap(int[][] a, int[][] b) {
		int n = a.length;
		int overlap = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				overlap = Math.max(overlap, getOverlap(a, b, i, j, n-i, n-j));
			}
		}
		return overlap;
        
    }

	public static void main(String[] arg) {
		
		int[][] a = {
				{1,1,0}, 
				{0,1,0}, 
				{0,1,0}
		};

		int[][] b = {
				{0,0,0}, 
				{0,1,1}, 
				{0,0,1}
		};

		System.out.println(largestOverlap(a,b));
		
		int[][] a1 = {
				{0,0,0,0,0},
				{0,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,0,1},
				{0,1,0,0,1}};
		
		int[][] b1 = {
				{1,0,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{0,1,1,1,1},
				{1,0,1,1,1}};

		System.out.println(largestOverlap(a1,b1));

	}

}
