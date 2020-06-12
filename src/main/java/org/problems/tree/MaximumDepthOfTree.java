package org.problems.tree;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *       3 
 *      / \ 
 *     9   20 
 *         / \ 
 *        15  7 
 * return its depth = 3.
 */
public class MaximumDepthOfTree {
	
	static int getDepth(TreeNode node, int level) {
		if (node == null) {
			return level;
		}
		if (node.left == null && node.right == null) {
			return level;
		}
		return Math.max(getDepth(node.left, level + 1), getDepth(node.right, level + 1));
	}

	public static int maxDepth(TreeNode root) {
		if (root == null){
            return 0;
        }
		return getDepth(root, 1);

	}

	public static void main(String[] arg) {
		
		Integer[] lst = {3,9,20,null,null,15,7};
		TreeNode root = Utils.loadTree(lst);

		Integer[] lst1 = {31};
		TreeNode root1 = Utils.loadTree(lst1);

		System.out.println(maxDepth(root));
		System.out.println(maxDepth(root1));

	}

}
