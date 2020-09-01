package org.problems.favourite;

import org.problems.model.TreeNode;

/**
 * Subtree of Another Tree
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. 
 * A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. 
 * The tree s could also be considered as a subtree of itself
  */
public class SubtreeOfAnotherTree {

	static boolean check(TreeNode s, TreeNode t) {
		if (s == null && t != null) {
			return false;
		}
		if (s != null && t == null) {
			return false;
		}
		if (s == null && t == null) {
			return true;
		}
		if (s.val != t.val) {
			return false;
		}
		if (!check(s.left, t.left)) {
			return false;
		}
		if (!check(s.right, t.right)) {
			return false;
		}
		return true;
	}

	static boolean collectNodes(TreeNode s, TreeNode t, int val) {
		if (s == null) {
			return false;
		}
		if (s.val == val) {
			if (check(s, t)) {
				return true;
			}
		}
		if (collectNodes(s.left, t, val)) {
			return true;
		}
		if (collectNodes(s.right, t, val)) {
			return true;
		}
		return false;
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null && t != null) {
			return false;
		}

		return collectNodes(s, t, t.val);

	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
