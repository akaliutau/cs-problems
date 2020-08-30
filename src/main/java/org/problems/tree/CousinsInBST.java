package org.problems.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 * 
 * In a binary tree, the root node is at depth 0, and children of each depth k
 * node are at depth k+1.
 * 
 * Two nodes of a binary tree are cousins if they have the same depth, but have
 * different parents.
 * 
 * We are given the root of a binary tree with unique values, and the values x
 * and y of two different nodes in the tree.
 * 
 * Return true if and only if the nodes corresponding to the values x and y are
 * cousins.
 * 
 * Runtime: 1 ms, faster than 49.07% of Java online submissions for Cousins in Binary Tree.
 * Memory Usage: 37.5 MB, less than 57.96% of Java online submissions for Cousins in Binary Tree
 */
public class CousinsInBST {

	static boolean find(TreeNode node, int x, int y, int level, int parent, Map<Integer, Set<Integer>> levels, int[] parents) {
		if (node == null) {
			return false;
		}
		if (!levels.containsKey(level)) {
			levels.put(level, new HashSet<>());
		}
		levels.get(level).add(node.val);
		parents[node.val] = parent;
		if (levels.get(level).contains(x) && levels.get(level).contains(y) && parents[x] != parents[y]) {
			return true;
		}
		if (find(node.left, x, y, level + 1, node.val, levels, parents)) {
			return true;
		}
		return find(node.right, x, y, level + 1, node.val, levels, parents);
	}

	public static boolean isCousins(TreeNode root, int x, int y) {
		Map<Integer, Set<Integer>> levels = new HashMap<>();
		int[] parents = new int[101];
		return find(root, x, y, 0, -1, levels, parents);
	}

	public static void main(String[] arg) {

		Integer[] tree = { 1, 2, 3, null, 4, null, 5 };
		TreeNode root = Utils.loadTree(tree);
		System.out.println(isCousins(root, 5, 4));

		Integer[] tree1 = { 1, 2, 3, null, 4 };
		TreeNode root1 = Utils.loadTree(tree1);
		System.out.println(isCousins(root1, 2, 3));

	}

}
