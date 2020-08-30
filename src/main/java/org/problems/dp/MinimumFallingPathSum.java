package org.problems.dp;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * 
 * Given a square array of integers A, we want the minimum sum of a falling path
 * through A.
 * 
 * A falling path starts at any element in the first row, and chooses one
 * element from each row. The next row's choice must be in a column that is
 * different from the previous row's column by at most one.
 * 
 * Example 1:
 * 
 * Input: 
 * 
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]] Output: 12 
 * 
 * Explanation: The possible falling
 * paths are: [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9] [2,4,7], [2,4,8],
 * [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9] [3,5,7], [3,5,8], [3,5,9],
 * [3,6,8], [3,6,9] 
 * 
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 * 
 * Constraints:
 * 
 * 1 <= A.length == A[0].length <= 100 
 * -100 <= A[i][j] <= 100
 */
public class MinimumFallingPathSum {

	public static int minFallingPathSum(int[][] a) {
		int n = a.length;
		for (int r = n-2; r >= 0; r--) {
            for (int c = 0; c < n; c++) {
                int next = a[r+1][c];
                if (c > 0){
                    next = Math.min(next, a[r + 1][c - 1]);
                }
                if (c + 1 < n){
                    next = Math.min(next, a[r + 1][c + 1]);
                }
                a[r][c] += next;
            }
        }
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, a[0][i]);
		}
		return min;
	}

	public static void main(String[] arg) {
		
		int[][] a = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		
		System.out.println(minFallingPathSum(a));
	}

}
