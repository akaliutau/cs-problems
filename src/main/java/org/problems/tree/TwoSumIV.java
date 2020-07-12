package org.problems.tree;

import java.util.HashSet;
import java.util.Set;
import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * 
 * Given a Binary Search Tree and a target number, return true if there exist
 * two elements in the BST such that their sum is equal to the given target.
 * 
 * Example 1:
 * 
 * Input:    
 *       5 
 *      / \ 
 *     3   6 
 *    / \   \ 
 *   2   4   7
 * 
 * Target = 9
 * 
 * Output: True
 * 
 * 
 * Example 2:
 * 
 * Input:   
 *        5 
 *       / \ 
 *      3   6 
 *     / \   \ 
 *    2   4   7
 * 
 * Target = 28
 * 
 * Output: False
 * 
 * 
 */
public class TwoSumIV {
	
	static boolean find(TreeNode root, int sum, Set<Integer> need) {
		if (root == null) {
			return false;
		}
		if (need.contains(root.val)) {
			return true;
		}
		need.add(sum - root.val);

		if (find(root.left, sum, need)) {
			return true;
		}
		if (find(root.right, sum, need)) {
			return true;
		}
		return false;
	}

	public static boolean findTarget(TreeNode root, int k) {
		Set<Integer> need = new HashSet<>();
		return find(root, k, need);

	}

	public static void main(String[] arg) {
		Integer[] tree = {5,3,6,2,4,null,7};
		TreeNode t = Utils.loadTree(tree );
		System.out.println(findTarget(t, 9));
	}

}
