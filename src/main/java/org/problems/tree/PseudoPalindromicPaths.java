package org.problems.tree;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 * 
 * Given a binary tree where node values are digits from 1 to 9. A path in the
 * binary tree is said to be pseudo-palindromic if at least one permutation of
 * the node values in the path is a palindrome.
 * 
 * Return the number of pseudo-palindromic paths going from the root node to
 * leaf nodes.
 * 
 */
public class PseudoPalindromicPaths {

	static class State {
		public int ways = 0;
		public int[] distr = new int[9];

		public boolean isPalindrom() {
			int even = 0;
			int odd = 0;
			for (int i = 0; i < 9; i++) {
				if (distr[i] % 2 == 0) {
					even++;
				} else {
					odd++;
				}
				if (odd > 1) {
					return false;
				}
			}
			return true;
		}
	}

	static void count(TreeNode node, State state) {
		if (node == null) {
			return;
		}
		state.distr[node.val - 1]++;
		if (node.left == null && node.right == null) {
			if (state.isPalindrom()) {
				state.ways++;
			}
			state.distr[node.val - 1]--;
			return;
		}
		if (node.left != null) {
			count(node.left, state);
		}
		if (node.right != null) {
			count(node.right, state);
		}
		state.distr[node.val - 1]--;

	}

	public static int pseudoPalindromicPaths(TreeNode root) {
		State state = new State();
		count(root, state);
		return state.ways;
	}

	public static void main(String[] arg) {

		Integer[] tree = { 2, 3, 1, 3, 1, null, 1 };
		TreeNode root = Utils.loadTree(tree);

		System.out.println(pseudoPalindromicPaths(root));

		Integer[] tree1 = { 2, 1, 1, 1, 3, null, null, null, null, null, 1 };
		TreeNode root1 = Utils.loadTree(tree1);

		System.out.println(pseudoPalindromicPaths(root1));

		Integer[] tree2 = { 9 };
		TreeNode root2 = Utils.loadTree(tree2);

		System.out.println(pseudoPalindromicPaths(root2));

	}

}
