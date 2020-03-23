package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 		3 
 *     / \ 
 *    9  20 
 *       / \ 
 *      15  7 
 * 
 * return its minimum depth = 2.
 */

public class MinimumDepth {
	
	public static boolean isLeaf(TreeNode node) {
		return node == null || (node.left == null && node.right == null);
	}
	
	public static int depth(TreeNode node, int depth) {
		if (isLeaf(node)) {
			return depth;
		}
		int dleft,dright;
		if (node.left != null && node.right != null) {
			dright = depth(node.right,depth+1);
			dleft = depth(node.left,depth+1);
			return Math.min(dleft, dright);
		}else if (node.left != null) {
			return depth(node.left,depth+1);
		}else if (node.right != null) {
			return depth(node.right,depth+1);
		}
		return depth;
	}
	

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return depth(root,1);
        
    }
	
	public static void main(String[] arg) {

		Integer[] tree = {3,9,20,null,null,15,7};
		System.out.println(minDepth(Utils.loadTree(tree)));

		Integer[] tree1 = {3};
		System.out.println(minDepth(Utils.loadTree(tree1)));

		Integer[] tree2 = {1,2,null,3,null,4,null,5};
		System.out.println(minDepth(Utils.loadTree(tree2)));

	}
}
