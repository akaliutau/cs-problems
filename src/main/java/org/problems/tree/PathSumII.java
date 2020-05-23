package org.problems.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * 
 */
public class PathSumII {

	static boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}

	static void checkPath(TreeNode node, int partialSum, int sum, Stack<Integer> stack, List<List<Integer>> results) {
		if (node == null) {
			return;
		}

		int next = partialSum + node.val;
		stack.add(node.val);
		System.out.println(stack);
		System.out.println(next);

		if (isLeaf(node)) {
			if (next == sum) {
				results.add(new ArrayList<>(stack));
			}
			stack.pop();
			return;
		}

		checkPath(node.left, next, sum, stack, results);
		checkPath(node.right, next, sum, stack, results);

		stack.pop();
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> array = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		checkPath(root, 0, sum, stack, array);
		return array;
	}

	public static void main(String[] arg) {

		Integer[] vals = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 };
		TreeNode tree = Utils.loadTree(vals);

		System.out.println(pathSum(tree, 22));

	}
}
