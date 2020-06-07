package org.problems.tree;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 *      3 
 *     / \ 
 *    9  20 
 *       / \ 
 *      15  7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 */
public class SumOfLeftLeaves {
	
	static int getSum(TreeNode node, boolean add) {
		if (node == null) {
			return 0;
		}
		int sum = 0;
		sum += getSum(node.right, false);
		sum += getSum(node.left, true);
		if (add && node.right == null && node.left == null) {
			sum += node.val; 
		}
	    return sum;
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		return getSum(root,false);
	}

	public static void main(String[] arg) {
		
		Integer[] tree = {3,9,20,null,null,15,7};
		TreeNode node = Utils.loadTree(tree);

		System.out.println(sumOfLeftLeaves(node));

		Integer[] tree1 = {1,2,3,4,5};
		TreeNode node1 = Utils.loadTree(tree1);

		System.out.println(sumOfLeftLeaves(node1));

	}

}
