package org.problems.tree;

import org.problems.model.TreeNode;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 * 
 * A binary tree is univalued if every node in the tree has the same value.
 * 
 * Return true if and only if the given tree is univalued.
 * 
 * Example 1:
 * 
 * Input: [1,1,1,1,1,null,1] Output: true
 * 
 * Note:
 * 
 * The number of nodes in the given tree will be in the range [1, 100]. 
 * Each node's value will be an integer in the range [0, 99].
 */
public class UnivaluedBST {
	
	static boolean isSame(TreeNode node, int val) {
		if (node == null) {
			return true;
		}
		if (node.val != val) {
			return false;
		}
		if (!isSame(node.left, val)) {
			return false;
		}
		if (!isSame(node.right, val)) {
			return false;
		}
		return true;
	}

	public boolean isUnivalTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSame(root, root.val);
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
