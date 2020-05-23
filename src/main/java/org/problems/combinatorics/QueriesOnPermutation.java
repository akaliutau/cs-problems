package org.problems.combinatorics;

import org.problems.utils.Utils;

/**
 * 	https://leetcode.com/problems/queries-on-a-permutation-with-key/
 * 
 * Given the array queries of positive integers between 1 and m, you have to process all queries[i] (from i=0 to i=queries.length-1) according to the following rules:

In the beginning, you have the permutation P=[1,2,3,...,m].
For the current i, find the position of queries[i] in the permutation P (indexing from 0) and then move this at the beginning of the permutation P. Notice that the position of queries[i] in P is the result for queries[i].
Return an array containing the result for the given queries.

 * 
 */
public class QueriesOnPermutation {
	
	public static int[] processQueries(int[] queries, int m) {
		
		int[] p = new int[m];
		for (int i = 1; i <=m; i++) {
			p[i-1] = i;
		}
		int n = queries.length;
		int[] res = new int[n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			int num = queries[i];
			for (int j = 0; j <m; j++) {
				if (p[j] == num) {
					res[idx++] = j;
					for (int k = j-1; k > -1; k--) {
						p[k+1] = p[k];
					}
					p[0] = num;
					break;
				}	
			}
		}
		return res;
    }

	public static void main(String[] arg) {
		int[] queries = {3,1,2,1};

		Utils.print(processQueries(queries,5));

		int[] queries1 = {4,1,2,2};

		Utils.print(processQueries(queries1,4));

		int[] queries2 = {7,5,5,8,3};

		Utils.print(processQueries(queries2,8));

	}

}

