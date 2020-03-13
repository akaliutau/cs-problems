package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/path-sum/
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 */
public class PathSum {
	
	static boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}
	
	static boolean checkPath(TreeNode node, int partialSum, int sum) {
		if (node == null) {
			return false;
		}
		int next =  partialSum + node.val;

		if (isLeaf(node)) {
			return next == sum;
		}
		boolean result = false;

		result = result || checkPath(node.left, next, sum);
		result = result || checkPath(node.right, next, sum);

		return result;
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		return checkPath(root,0,sum);
    }

	public static void main(String[] arg) {
		
		Integer[] vals = {-2,null,-3};
		TreeNode tree = Utils.loadTree(vals);
		

		System.out.println(hasPathSum(tree,-5));

	}
}
