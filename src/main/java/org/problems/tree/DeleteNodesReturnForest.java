package org.problems.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 * 
 * Given the root of a binary tree, each node in the tree has a distinct value.
 * 
 * After deleting all nodes with a value in to_delete, we are left with a forest
 * (a disjoint union of trees).
 * 
 * Return the roots of the trees in the remaining forest. You may return the
 * result in any order.
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5] Output:
 * [[1,2,null,4],[6],[7]]
 * 
 *        1
 *      /  \
 *     2    3
 *    / \  / \  
 *   4  5 6   7
 *   
 *   Runtime: 1 ms, faster than 98.18% of Java online submissions for Delete Nodes And Return Forest.
 *   Memory Usage: 40.3 MB, less than 100.00% of Java online submissions for Delete Nodes And Return Forest.
 */
public class DeleteNodesReturnForest {
	
	static boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}
	
	public static void processNode(TreeNode node, Set<Integer> toDelete, List<TreeNode> results) {
		if (node == null) {
			return;
		}
		if (toDelete.contains(node.val)) {
			if (isLeaf(node)) {
				// do nothing
			}else {
				if (node.left != null) {
					if (!toDelete.contains(node.left.val))
						results.add(node.left);
					processNode(node.left, toDelete, results);
					}
				if (node.right != null) {
					if (!toDelete.contains(node.right.val))
						results.add(node.right);
					processNode(node.right, toDelete, results);
				}
			}
		}else {
			processNode(node.left, toDelete, results);
			processNode(node.right, toDelete, results);
		}
		if (node.left != null && toDelete.contains(node.left.val)) {
			node.left = null;
		}
		if (node.right != null && toDelete.contains(node.right.val)) {
			node.right = null;
		}
	}

	public static List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
		Set<Integer> delete = new HashSet<>();
		for (int i = 0; i < toDelete.length; i++) {
			delete.add(toDelete[i]);
		}
		List<TreeNode> results = new ArrayList<>();
		if (!delete.contains(root.val)) {
			results.add(root);
		}
		processNode(root, delete, results);
		return results;
	}

	public static void main(String[] arg) {
		
		Integer[] nodes = {1,2,3,4,5,6,7};
		int[] toDelete = {3,5};
		TreeNode root = Utils.loadTree(nodes);
		
		System.out.println(delNodes(root, toDelete));

	}

}
