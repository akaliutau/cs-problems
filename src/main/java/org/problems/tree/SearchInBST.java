package org.problems.tree;

import java.io.File;
import java.util.Stack;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * 
 * Given the root node of a binary search tree (BST) and a value. You need to
 * find the node in the BST that the node's value equals the given value. Return
 * the subtree rooted with that node. If such node doesn't exist, you should
 * return NULL.
 * 
 * For example,
 * 
 * Given the tree:  
 *         4
 *        / \ 
 *       2   7 
 *      / \ 
 *     1   3
 * 
 * And the value to search: 2 You should return this subtree:
 * 
 *           2 
 *          / \ 
 *         1   3 
 * In the example above, if we want to search the value 5, since there
 * is no node with value 5, we should return NULL.
 * 
 * Note that an empty tree is represented by NULL, therefore you would see the
 * expected output (serialized tree format) as [], not null.
 * 
 * 
 * 
 */
public class SearchInBST {
	
	static TreeNode find(TreeNode node, int val) {
		if (node == null) {
			return null;
		}
		if (node.val == val) {
			return node;
		}
		TreeNode left = find(node.left, val);
		if (left != null) {
			return left;
		}
		TreeNode right = find(node.right, val);
		if (right != null) {
			return right;
		}
		return null;
	}

	public static TreeNode searchBST(TreeNode root, int val) {
		return find(root, val);
	}

	public static void main(String[] arg) {
		Integer[] tree = {18,2,22,null,null,null,63,null,84,null,null};
		TreeNode t = Utils.loadTree(tree );
		System.out.println(searchBST(t, 63));

	}

}
