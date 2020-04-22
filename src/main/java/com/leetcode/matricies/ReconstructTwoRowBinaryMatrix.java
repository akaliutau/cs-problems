package com.leetcode.matricies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
 *
 * Given the following details of a matrix with n columns and 2 rows :
 * 
 * The matrix is a binary matrix, which means each element in the matrix can be
 * 0 or 1. 
 * The sum of elements of the 0-th(upper) row is given as upper. 
 * The sum of elements of the 1-st(lower) row is given as lower. 
 * The sum of elements in the i-th column(0-indexed) is colsum[i], 
 * where colsum is given as an integer array with length n. 
 * Your task is to reconstruct the matrix with upper, lower and colsum.
 * 
 * Return it as a 2-D integer array.
 * 
 * If there are more than one valid solution, any of them will be accepted.
 * 
 * If no valid solution exists, return an empty 2-D array.
 * 
 * Example 1:
 * 
 * Input: upper = 2, lower = 1, colsum = [1,1,1] 
 * Output: 
 * [
 * [1,1,0],
 * [0,0,1]
 * ]
 * Explanation: [[1,0,1],[0,1,0]], and [[0,1,1],[1,0,0]] are also correct
 * answers. 
 * 
 * Example 2:
 * 
 * Input: upper = 2, lower = 3, colsum = [2,2,1,1] 
 * Output: [] 
 * 
 * Example 3:
 * 
 * Input: upper = 5, lower = 5, colsum = 
 * [2,1,2,0,1,0,1,2,0,1] 
 * 
 * Output:
 * [
 * [1,1,1,0,1,0,0,1,0,0],
 * [1,0,1,0,0,0,1,1,0,1]
 * ]
 * 
 * 
 */
public class ReconstructTwoRowBinaryMatrix {
	
	static List<Integer> getLine(int[] line){
		return Arrays.stream(line).boxed().collect(Collectors.toList());
	}

	public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		int cols = colsum.length;
		int[][] rows = new int[2][cols];
		boolean[] filled = new boolean[cols];
		int dec = 0;
		int filledCells = 0;
		for (int i = 0; i < cols; i++) {
			if (colsum[i] == 2) {
				rows[0][i] = 1;
				rows[1][i] = 1;
				filled[i] = true;
				filledCells ++;
				dec ++;
			}else if (colsum[i] == 0){
				filled[i] = true;
				filledCells ++;
			}
		}
		int upToFill = upper - dec;
		int lowerToFill = lower - dec;
		System.out.println("upToFill="+upToFill);
		System.out.println("lowerToFill="+lowerToFill);
		for (int i = 0; i < cols; i++) {
			if (colsum[i] == 1 && !filled[i] && upToFill > 0) {
				rows[0][i] = 1;
				upToFill --;
				filled[i] = true;
				filledCells ++;
			}
		}		
		for (int i = 0; i < cols; i++) {
			if (colsum[i] == 1 && !filled[i] && lowerToFill > 0) {
				rows[1][i] = 1;
				lowerToFill --;
				filled[i] = true;
				filledCells ++;
			}
		}
		
		List<List<Integer>> res = new ArrayList<>();
		// check array
		if (filledCells != cols || upToFill != 0 || lowerToFill != 0) {
			return res;
		}
		res.add(getLine(rows[0]));
		res.add(getLine(rows[1]));
		
		return res;
	}

	public static void main(String[] arg) {
		
		int[] colsum = {1,1,1};
		System.out.println(reconstructMatrix(2,1,colsum));

		int[] colsum1 = {2,2,1,1};
		System.out.println(reconstructMatrix(2,3,colsum1));

		int[] colsum2 = {2,1,2,0,1,0,1,2,0,1};
		System.out.println(reconstructMatrix(5,5,colsum2));

		int[] colsum3 = {2,1,2,0,0,2};
		System.out.println(reconstructMatrix(1,4,colsum3));


	}
}
