package org.problems.tree;

import java.util.ArrayList;
import java.util.List;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * 
 * 
 */
public class BSTInorderTraversal {

	static void add(TreeNode root, List<Integer> res) {
		if (root != null) {
			if (root.left != null) {
				add(root.left, res);
			}
			res.add(root.val);
			if (root.right != null) {
				add(root.right, res);
			}
		}
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		add(root, res);
		return res;
	}

	public static void main(String[] arg) {
		Integer[] tree = {5,3,6,2,4,null,7};
		TreeNode t = Utils.loadTree(tree );

		System.out.println(inorderTraversal(t));

	}

}
