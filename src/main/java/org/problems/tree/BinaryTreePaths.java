package org.problems.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Input:
 * 
 *    1 
 *   / \ 
 *  2   3
 *   \ 
 *    5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * 
 */
public class BinaryTreePaths {
	
	public static boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}

	public static void walk(TreeNode node, Stack<String> stack, List<String> result) {
		stack.add(""+node.val);
		if (isLeaf(node)) {
			result.add(String.join("->", stack.toArray(new String[stack.size()])));
		}else {
			if (node.left != null) {
				walk(node.left, stack, result);
			}
			if (node.right != null) {
				walk(node.right, stack, result);
			}
		}
		stack.pop();
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		Stack<String> stack = new Stack<>();
		walk(root, stack, result);
		return result;
	}

	public static void main(String[] arg) {

		Integer[] tree = {1,2,3,null,5};
		System.out.println(binaryTreePaths(Utils.loadTree(tree)));

	}

}
