package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Invert a binary tree.
 * 
 * Example:
 * 
 * Input:
 * 
 *      4 
 *     / \
 *    2   7 
 *   / \ / \ 
 *  1  3 6  9 
 *  
 *  Output:
 * 
 *      4 
 *     / \ 
 *    7   2 
 *   / \ / \ 
 *  9  6 3  1
 *  
 */
public class InvertBinaryTree {
	
	public static void invert(TreeNode node) {
		if (node != null) {
			invert(node.left);
			invert(node.right);
			TreeNode t = node.right;
			node.right = node.left;
			node.left = t;
		}
	}

	public static TreeNode invertTree(TreeNode root) {
		invert(root);
		return root;

	}

	public static void main(String[] arg) {
		
		Integer[] tree = {4,2,7,1,3,6,9};
		TreeNode root = Utils.loadTree(tree );
		System.out.println(root.left);
		System.out.println(root.right);

		invertTree(root);

		System.out.println(root.left);
		System.out.println(root.right);

	}
}
