package com.leetcode.tree;

/**
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 *
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two
 * children leftChild[i] and rightChild[i], return true if and only if all the
 * given nodes form exactly one valid binary tree.
 * 
 * If node i has no left child then leftChild[i] will equal -1, similarly for
 * the right child.
 * 
 * Note that the nodes have no values and that we only use the node numbers in
 * this problem.
 */
public class ValidateBinaryTree {

	public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

		boolean[] nodes = new boolean[10000];
		nodes[0] = true;

		for (int i = 0; i < n; i++) {
			if (!nodes[i]) {
				return false;
			}
			if (leftChild[i] != -1) {
				if (nodes[leftChild[i]] || leftChild[i] == i) {
					return false;
				}
				nodes[leftChild[i]] = true;
			}
			if (rightChild[i] != -1) {
				if (nodes[rightChild[i]] || rightChild[i] == i) {
					return false;
				}
				nodes[rightChild[i]] = true;
			}
		}

		return true;

	}

	public static void main(String[] arg) {

		int[] leftChild = { 1, -1, 3, -1 };
		int[] rightChild = { 2, -1, -1, -1 };
		System.out.println(validateBinaryTreeNodes(4, leftChild, rightChild));
		int[] leftChild1 = { 1, -1, 3, -1 };
		int[] rightChild1 = { 2, 3, -1, -1 };
		System.out.println(validateBinaryTreeNodes(4, leftChild1, rightChild1));
		int[] leftChild2 = { 1, 0 };
		int[] rightChild2 = { -1, -1 };
		System.out.println(validateBinaryTreeNodes(2, leftChild2, rightChild2));
		int[] leftChild3 = { 1, -1, -1, 4, -1, -1 };
		int[] rightChild3 = { 2, -1, -1, 5, -1, -1 };
		System.out.println(validateBinaryTreeNodes(6, leftChild3, rightChild3));

	}

}
