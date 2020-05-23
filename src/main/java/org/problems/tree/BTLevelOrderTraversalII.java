package org.problems.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7], 
 * 
 *    3
 *   / \ 
 *  9  20 
 *     / \ 
 *    15  7
 *    
 * return its bottom-up level order traversal as: [ [15,7], [9,20], [3] ]
 * 
 * 
 * 
 */
public class BTLevelOrderTraversalII {
	
	public static boolean isLeaf(TreeNode node) {
		return node == null || (node.left == null && node.right == null);
	}

	
	public static void traverse(TreeNode node, List<List<Integer>> levels, int level) {
		if (isLeaf(node)) {
			if (levels.size() < level) {
				levels.add(new ArrayList<>());
			}
			if (node != null) {
				levels.get(level-1).add(node.val);
			}
			return;
		}
		if (levels.size() < level) {
			levels.add(new ArrayList<>());
		}
		levels.get(level-1).add(node.val);
		traverse(node.left, levels, level+1);
		traverse(node.right, levels, level+1);
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		traverse(root, result, 1);
		Collections.reverse(result);
		return result;
    }

	public static void main(String[] arg) {

		Integer[] tree = {3,9,20,null,null,15,7};
		System.out.println(levelOrderBottom(Utils.loadTree(tree)));

		Integer[] tree1 = {3};
		System.out.println(levelOrderBottom(Utils.loadTree(tree1)));

		Integer[] tree2 = {3,9,null,5,null,15,null,7};
		System.out.println(levelOrderBottom(Utils.loadTree(tree2)));

		Integer[] tree3 = {};
		System.out.println(levelOrderBottom(Utils.loadTree(tree3)));
	}
}
