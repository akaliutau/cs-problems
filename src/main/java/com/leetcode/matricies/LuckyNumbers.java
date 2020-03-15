package com.leetcode.matricies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 * 
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column


 */
public class LuckyNumbers {
	
	public static List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = 0;
        if (m > 0) {
        	n = matrix[0].length;
        }
        
        Set<Integer> res = new HashSet<>();
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
        	int minVal = 510000;
            for (int j = 0; j < n; j++) {
            	minVal = matrix[i][j] < minVal ? matrix[i][j] : minVal;
            }
            rows[i] = minVal;
        }

        for (int i = 0; i < n; i++) {
        	int maxVal = 0;
            for (int j = 0; j < m; j++) {
            	maxVal = matrix[j][i] > maxVal ? matrix[j][i] : maxVal;
            }
            cols[i] = maxVal;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            	if (matrix[i][j] == rows[i] && matrix[i][j] == cols[j]) {
            		res.add(matrix[i][j]);
            	}
            }
        }
        return new ArrayList<>(res);

    }
	

	public static void main(String[] arg) {
		
		int[][] mtx = {
				{3,7,8},
				{9,11,13},
				{15,16,17}
		};

		System.out.println(luckyNumbers(mtx));
		

	}

}
