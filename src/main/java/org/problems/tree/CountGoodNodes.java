package org.problems.tree;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * 
 * Given a binary tree root, a node X in the tree is named good if in the path
 * from root to X there are no nodes with a value greater than X.
 * 
 * Return the number of good nodes in the binary tree.
 * 
 * Input: root = [3,1,4,3,null,1,5] Output: 4 Explanation: Nodes in blue are
 * good. Root Node (3) is always a good node. Node 4 -> (3,4) is the maximum
 * value in the path starting from the root. Node 5 -> (3,4,5) is the maximum
 * value in the path Node 3 -> (3,1,3) is the maximum value in the path.
 * 
 */
public class CountGoodNodes {

	static int count(TreeNode node, int max) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.val >= max ? 1 : 0;
		}
		int cur = 0;
		if (node.val < max) {
			cur = 0;
		} else {
			cur = 1;
		}
		// at least 1
		int left = count(node.left, Math.max(max, node.val));
		int right = count(node.right, Math.max(max, node.val));
		return left + right + cur;
	}

	public static int goodNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return count(root, root.val);
	}

	public static void main(String[] arg) {

		Integer[] tree = { 3, 1, 4, 3, null, 1, 5 };
		TreeNode node = Utils.loadTree(tree);
		System.out.println(goodNodes(node));

		Integer[] tree1 = { 3, 3, null, 4, 2 };
		TreeNode node1 = Utils.loadTree(tree1);
		System.out.println(goodNodes(node1));

		Integer[] tree2 = { 1 };
		TreeNode node2 = Utils.loadTree(tree2);
		System.out.println(goodNodes(node2));

	}

}
