package org.problems.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * 
 * Given a Binary Search Tree (BST) with the root node root, return the minimum
 * difference between the values of any two different nodes in the tree.
 * 
 * Example :
 * 
 * Input: root = [4,2,6,1,3,null,null] Output: 1 Explanation: Note that root is
 * a TreeNode object, not an array.
 * 
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * 
 *          4 
 *         / \ 
 *        2   6 
 *       / \ 
 *      1   3
 * 
 * while the minimum difference in this tree is 1, it occurs between node 1 and
 * node 2, also between node 3 and node 2. 
 * 
 * Note:
 * 
 * The size of the BST will be between 2 and 100. The BST is always valid, each
 * node's value is an integer, and each node's value is different.
 * 
 */
public class MinimumDistanceInBST {
	
	static void collect(TreeNode node, List<Integer> lst) {
		if (node != null) {
			lst.add(node.val);
			collect(node.left, lst);
			collect(node.right, lst);
		}
	}

	public static int minDiffInBST(TreeNode root) {
		List<Integer> lst = new ArrayList<>();
		collect(root, lst);
		Collections.sort(lst);
		int dist = Integer.MAX_VALUE;
		for (int i = 0; i < lst.size() - 1; i++) {
			int d = lst.get(i + 1)  - lst.get(i);
			dist = Math.min(dist, d);
			if (dist == 0) {
				break;
			}
		}
		return dist;

	}

	public static void main(String[] arg) {
		Integer[] tree = {4,2,6,1,3,null,null};
		TreeNode t = Utils.loadTree(tree );
		System.out.println(minDiffInBST(t));

	}

}
