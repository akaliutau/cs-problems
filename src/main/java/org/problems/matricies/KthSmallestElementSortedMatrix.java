package org.problems.matricies;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example:
 * 
 * matrix = [ 
 * [ 1, 5, 9], 
 * [10, 11, 13], 
 * [12, 13, 15] 
 * ], k = 8,
 * 
 * return 13. Note: You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class KthSmallestElementSortedMatrix {
	

    public static int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); 
        int n = matrix.length;
        
        for(int i = 0;i < n; i++){
            for(int j = 0;j < n; j++){
                heap.offer(matrix[i][j]);
                if(heap.size() > k) {
                 	heap.poll();
                }
            }
        }
        
        return heap.poll();        
    }
	public static void main(String[] arg) {
		
		int[][] matrix = {
				{ 1, 5, 9}, 
		        {10, 11, 13}, 
		        {12, 13, 15} 
		        };

		System.out.println(kthSmallest(matrix, 6));
		System.out.println(kthSmallest(matrix, 7));
		System.out.println(kthSmallest(matrix, 8));
		System.out.println(kthSmallest(matrix, 9));
		
		int[][] matrix1 = {
					{ 1} 
		        };

		System.out.println(kthSmallest(matrix1, 1));
		
		int[][] matrix2 = {
				{1,4,7,11,15},
				{2,5,8,12,19},
				{3,6,9,16,22},
				{10,13,14,17,24},
				{18,21,23,26,30}
	        };

		System.out.println(kthSmallest(matrix2, 5));

	}

}
