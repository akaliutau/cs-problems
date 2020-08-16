package org.problems.tree;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 * 
 * Given a binary tree, each node has value 0 or 1. Each root-to-leaf path
 * represents a binary number starting with the most significant bit. For
 * example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent
 * 01101 in binary, which is 13.
 * 
 * For all leaves in the tree, consider the numbers represented by the path from
 * the root to that leaf.
 * 
 * Return the sum of these numbers
 * 
 * Example 1.
 * 
 * Input: [1,0,1,0,1,0,1] Output: 22 
 * 
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 
 * Note:
 * 
 * The number of nodes in the tree is between 1 and 1000. 
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1
 */
public class SumOfBinaryNumbers {
	
	static class Sum {
		public long s = 0;
	}
	
	static int parseNumber(int[] num, int idx) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < idx; i++) {
			sb.append(num[i]);
		}
		return Integer.parseInt(sb.toString(), 2);
	}
	
	static void sumOnLeaf(TreeNode node, Sum sum, int[] num, int idx) {
		if (node == null) {
			return;
		}
		num[idx] = node.val;
		if (node.left == null && node.right == null) {
			sum.s += parseNumber(num, idx + 1);
		}else {
			sumOnLeaf(node.left, sum, num, idx + 1);
			sumOnLeaf(node.right, sum, num, idx + 1);
		}
	}

	public static int sumRootToLeaf(TreeNode root) {
		int[] num = new int[32];
		Sum sum = new Sum();
		sumOnLeaf(root, sum, num, 0);
		return (int) sum.s;

	}

	public static void main(String[] arg) {
		
		Integer[] arr = {1,0,1,0,1,0,1};
		TreeNode root = Utils.loadTree(arr);
		
		System.out.println(sumRootToLeaf(root));
	}

}
