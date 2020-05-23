package org.problems.tree;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * a binary tree in which the left and right subtrees of every node differ in
 * height by no more than 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Given the following tree [3,9,20,null,null,15,7]:
 * 
 *depth 		
 * 0   	 3 
 * 	    / \ 
 * 1   9  20 
 *        / \ 
 * 2     15  7 
 *      
 * Return true.
 * 
 * Runtime: 1 ms, faster than 52.15% of Java online submissions for Balanced Binary Tree.
 * Memory Usage: 41.7 MB, less than 9.26% of Java online submissions for Balanced Binary Tree.
 * 
 */
public class BalancedBinaryTree {

	static class TreeNodeWrapper {
		public TreeNodeWrapper left;
		public TreeNodeWrapper right;
		public int maxDepth;
		public int depth;
		public int val;
		
		public TreeNodeWrapper(int val,int depth){
			this.depth = depth;
			this.val = val;
		}

		@Override
		public String toString() {
			return "[maxDepth=" + maxDepth + ", depth=" + depth + ", val=" + val + "]";
		}
	}

	/**
	 * 
	 * @param left  - left branch
	 * @param right - right branch
	 * @return
	 */
	public static int createMirrorTree (TreeNode node, TreeNodeWrapper mirror, int level) {
		int depthL = level;
		int depthR = level;
		if (node.left != null) {
			mirror.left = new TreeNodeWrapper(node.left.val, level+1);
			depthL = createMirrorTree(node.left, mirror.left, level+1);
		}
		if (node.right != null) {
			mirror.right = new TreeNodeWrapper(node.right.val, level+1);
			depthR = createMirrorTree(node.right, mirror.right, level+1);
		}
		mirror.maxDepth = Math.max(depthL, depthR);
		return mirror.maxDepth;
	}
	
	public static boolean isBalanced(TreeNodeWrapper root) {
		if (root == null) {
			return true;
		}
		int leftDepth = root.left == null ? root.depth : root.left.maxDepth;
		int rightDepth = root.right == null ? root.depth : root.right.maxDepth;
		boolean balacedThis = Math.abs(leftDepth - rightDepth) <= 1;
		if (balacedThis) {
			if ( isBalanced(root.left)) {
				if (isBalanced(root.right)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isBalanced(TreeNode root) {
		
		if (root == null) {
			return true;
		}
		TreeNodeWrapper mirrorRoot = new TreeNodeWrapper(root.val,0);
		createMirrorTree(root,mirrorRoot,0);
		return isBalanced(mirrorRoot);

	}

	public static void main(String[] arg) {

		Integer[] tree = {3,9,20,null,null,15,7};
		System.out.println(isBalanced(Utils.loadTree(tree)));//true
		
		Integer[] tree1 = {3,9,20,null,null,15,7, null, null, null, 8};//false
		System.out.println(isBalanced(Utils.loadTree(tree1)));

		Integer[] tree2 = {3};
		System.out.println(isBalanced(Utils.loadTree(tree2)));//true

		Integer[] tree3 = {1,2,2,3,3,null,null,4,4};
		System.out.println(isBalanced(Utils.loadTree(tree3)));//false

		Integer[] tree4 = {1,null,2,null,3};
		System.out.println(isBalanced(Utils.loadTree(tree4)));//false

		Integer[] tree5 = {1,2,3,4,5,null,6,7};
		System.out.println(isBalanced(Utils.loadTree(tree5)));//true


	}

}
