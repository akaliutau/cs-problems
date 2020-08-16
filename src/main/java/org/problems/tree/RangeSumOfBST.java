package org.problems.tree;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * 
 * Given the root node of a binary search tree, return the sum of values of all
 * nodes with value between L and R (inclusive).
 * 
 * The binary search tree is guaranteed to have unique values.
 * 
 * Example 1:
 * 
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15 Output: 32 
 * 
 * Example 2:
 * 
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10 Output: 23
 * 
 * 
 * Note:
 * 
 * The number of nodes in the tree is at most 10000. 
 * The final answer is guaranteed to be less than 2^31.
 */
public class RangeSumOfBST {
	
	static class Sum {
		public long s = 0;
	}
	
	static void summate(TreeNode node, Sum sum, int L, int R) {
		if (node == null) {
			return;
		}
		if (L <= node.val && node.val <= R) {
			sum.s += node.val;
		}
		summate(node.left, sum, L, R);
		summate(node.right, sum, L, R);
	}

	public static int rangeSumBST(TreeNode root, int L, int R) {
		Sum sum = new Sum();
		summate(root, sum, L, R);
		return (int) sum.s;
	}

	public static void main(String[] arg) {
		
		Integer[] arr = {10,5,15,3,7,null,18};
		System.out.println(rangeSumBST(Utils.loadTree(arr), 7, 15));

		Integer[] arr1 = {10,5,15,3,7,13,18,1,null,6};
		System.out.println(rangeSumBST(Utils.loadTree(arr1), 6, 10));
}

}
