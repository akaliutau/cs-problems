package org.problems.tree;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * Find the size of perfect subtree in a given tree
 * Example 1:
 * 
 * 			 1
 *         /  \
 *  	  2	   3
 *           /   \
 *          4     5
 *         / \   / \
 *        6   7 8   9
 *                   \
 *                    10
 * Output: 7
 * 
 */   
public class PerfectSubtree {
	
	public static int findPerfectSubtree(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		if (node.left == null && node.right == null) {
			return 1;
		}
		
		int left = findPerfectSubtree(node.left);
		int right = findPerfectSubtree(node.right);
		if (left == right) {
			return left + right + 1 ;
		}
		return Math.max(left, right);
	}

	
	public static void main(String[] arg) {
		
		Integer[] tree = {1, 2, 3, null, null, 4, 5, 6, 7, 8, 9, null, null, null, null, null, null, null, 10};
		TreeNode root = Utils.loadTree(tree);
		System.out.println(findPerfectSubtree(root));
		
		Integer[] tree1 = {1, 2, 3};
		TreeNode root1 = Utils.loadTree(tree1);
		System.out.println(findPerfectSubtree(root1));

	}

}
