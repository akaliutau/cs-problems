package org.problems.tree;

/**
 * https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
 * 
 * You are given a tree with n nodes numbered from 0 to n-1 in the form of a
 * parent array where parent[i] is the parent of node i. The root of the tree is
 * node 0.
 * 
 * Implement the function getKthAncestor(int node, int k) to return the k-th
 * ancestor of the given node. If there is no such ancestor, return -1.
 * 
 * The k-th ancestor of a tree node is the k-th node in the path from that node
 * to the root
 * 
 * Runtime: 225 ms, faster than 100.00% of Java online submissions for Kth Ancestor of a Tree Node.
 * Memory Usage: 159.4 MB, less than 100.00% of Java online submissions for Kth Ancestor of a Tree Node.
 * 
 */
public class KthAncestorOfTree {

	static class TreeAncestor {
		
		// 20-levels deep cache (2^20 > 500000)
		// contains parents-refs for k represented as 0100110110 
		// 0 - left branch, 1 - right branch
		private int[][] cache;

		public TreeAncestor(int n, int[] parent) {
			this.cache = new int[500000][20];
			for (int i = 0; i < n; ++i) {
				cache[i][0] = parent[i];
			}
			// pre-calc parents for all levels
			for (int level = 1; level < 20; ++level) {
				for (int j = 0; j < n; ++j) {
					int k = cache[j][level-1]; 
					cache[j][level] = k < 0 ? -1 : cache[k][level-1];
				}
			}
		}

		public int getKthAncestor(int node, int k) {
			for (int level = 0; level < 20; ++level) {
				if ((k & (1 << level)) != 0) {
					node = cache[node][level];
					if (node == - 1) {
						return -1;
					}
				}
			}		
			return node;
		}
	}

	public static void main(String[] arg) {
		int[] parent = {-1, 0, 0, 1, 1, 2, 2};
		
		TreeAncestor treeAncestor = new TreeAncestor(7, parent);

		System.out.println(treeAncestor.getKthAncestor(3, 1));  // returns 1 which is the parent of 3
		System.out.println(treeAncestor.getKthAncestor(5, 2));  // returns 0 which is the grandparent of 5
		System.out.println(treeAncestor.getKthAncestor(6, 3));  // returns -1 because there is no such ancestor
		System.out.println(treeAncestor.cache);

		int[] parent1 = {-1, 0, 0, 2, 1};
		
		TreeAncestor treeAncestor1 = new TreeAncestor(5, parent1);

		System.out.println(treeAncestor1.getKthAncestor(3, 5));  // returns -1 because there is no such ancestor
		System.out.println(treeAncestor1.getKthAncestor(2, 3));  // returns -1 because there is no such ancestor
		System.out.println(treeAncestor1.getKthAncestor(1, 2));  // returns -1 because there is no such ancestor
		System.out.println(treeAncestor1.getKthAncestor(1, 5));  // returns -1 because there is no such ancestor
		System.out.println(treeAncestor1.getKthAncestor(1, 6));  // returns -1 because there is no such ancestor
		System.out.println(treeAncestor1.cache);

	}

}
