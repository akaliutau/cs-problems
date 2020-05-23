package org.problems.matricies;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/flipping-an-image/
 * 
 * Given a binary matrix A, we want to flip the image horizontally, then invert
 * it, and return the resulting image.
 * 
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * 
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced
 * by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * 
 * Example 1:
 * 
 * Input: [[1,1,0],[1,0,1],[0,0,0]] Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]]. Then, invert
 * the image: [[1,0,0],[0,1,0],[1,1,1]] Example 2:
 * 
 * Input: 
 * [
 * [1,1,0,0],
 * [1,0,0,1],
 * [0,1,1,1],
 * [1,0,1,0]
 * ]
 *  Output:
 * [
 * [1,1,0,0],
 * [0,1,1,0],
 * [0,0,0,1],
 * [1,0,1,0]
 * ] 
 * 
 * Explanation: First reverse each
 * row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]. Then invert the image:
 * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] 
 * 
 * Notes:
 * 1 <= A.length = A[0].length <= 20 
 * 0 <= A[i][j] <= 1
 */
public class FlippingOfImage {
	
	static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	static void flipH(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n/2; i++) {
			swap(arr,i,n-i-1);
		}
	}
	
	static void invert(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = 1 - arr[i];
		}
	}


	public static int[][] flipAndInvertImage(int[][] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			flipH(arr[i]);
			invert(arr[i]);
		}		
		return arr;

	}

	public static void main(String[] arg) {
		
		int[][] blocked = {
				{1,0},
				{0,1}
		};


		Utils.print(flipAndInvertImage(blocked));

		int[][] blocked1 = {
				{1,1,0,0},
				{1,0,0,1},
				{0,1,1,1},
				{1,0,1,0}
		};


		Utils.print(flipAndInvertImage(blocked1));

	}

}
