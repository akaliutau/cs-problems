package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import com.leetcode.model.TreeNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 * 
 * Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.


 */
public class BalanceBinarySearchTree {

	static void storeNodes(TreeNode root, List<TreeNode> nodes) {
		if (root == null) {
			return;
		}
		storeNodes(root.left, nodes);
		nodes.add(root);
		storeNodes(root.right, nodes);
	}

	static TreeNode update(List<TreeNode> nodes, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode node = nodes.get(mid);

		node.left = update(nodes, start, mid - 1);
		node.right = update(nodes, mid + 1, end);

		return node;
	}

	static TreeNode buildTree(TreeNode root) {
		List<TreeNode> nodes = new ArrayList<>();
		storeNodes(root, nodes);

		int n = nodes.size();
		return update(nodes, 0, n - 1);
	}

	static void reOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		reOrder(node.left);
		reOrder(node.right);
	}

	public static TreeNode balanceBST(TreeNode root) {
		List<Integer> array = new ArrayList<>();
		root = buildTree(root);
		reOrder(root);
		return root;
	}

	public static void main(String[] arg) {
		Integer[] root = {1,null,2,null,3,null,4,null,null};
		TreeNode tree = Utils.loadTree(root);
		System.out.println(balanceBST(tree));

	}

}
