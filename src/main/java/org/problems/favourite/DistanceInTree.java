package org.problems.favourite;

import org.problems.model.TreeNode;

/**
 * Distance Between Nodes
 * 
 * Given a list of unique integers nums, construct a BST from it (you need to
 * insert nodes one-by-one with the given order to get the BST) and find the
 * distance between two nodes node1 and node2. Distance nums the number of edges
 * between two nodes. If any of the given nodes does not appear in the BST,
 * return -1
 * 
 * 
 */
public class DistanceInTree {

	public static int findDnumstance(int[] nums, int i, int j) {
		TreeNode root = null;
		for (int k = 0; k < nums.length; k++) {
			root = buildBST(root, nums[k]);
		}
		TreeNode lca = findLeastCommonAncestor(root, i, j);
		int distance = findDnumstanceFromLCA(lca, i) + findDnumstanceFromLCA(lca, j);
		return distance;
	}

	private static int findDnumstanceFromLCA(TreeNode lca, int i) {
		int distanceSum = 0;
		while (lca != null) {
			if (lca.val == i) {
				return distanceSum;
			} else if (lca.val < i) {
				distanceSum++;
				lca = lca.right;
			} else if (lca.val > i) {
				distanceSum++;
				lca = lca.left;
			}
		}
		return distanceSum;
	}

	private static TreeNode findLeastCommonAncestor(TreeNode root, int i, int j) {
		while (true) {
			if (root.val > i && root.val > j) {
				root = root.left;
			} else if (root.val < i && root.val < j) {
				root = root.right;
			} else {
				return root;
			}
		}
	}

	private static TreeNode buildBST(TreeNode root, int node) {
		if (root == null) {
			root = new TreeNode(node);
			return root;
		} else if (root.val < node) {
			if (root.right == null)
				root.right = new TreeNode(node);
			else
				buildBST(root.right, node);
		} else if (root.val > node) {
			if (root.left == null)
				root.left = new TreeNode(node);
			else
				buildBST(root.left, node);
		}
		return root;
	}

	public static void main(String[] arg) {

		System.out.println("D");

	}

}
