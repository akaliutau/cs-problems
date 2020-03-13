package com.leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/path-sum-iii/
 * 
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1. 5 -> 3
 * 
 * 2. 5 -> 2 -> 1
 * 
 * 3. -3 -> 11
 * 
 */
public class PathSumIII {


	static int checkPath(TreeNode node, int sum, Stack<Integer> nodeValues, List<Integer> sums) {
		int counter = 0;
		if (node == null) {
			return counter;
		}

		List<Integer> newSet = sums.stream().map(val -> val + node.val).collect(Collectors.toList());
		newSet.add(node.val);
		nodeValues.push(node.val);

		for (Integer i : newSet) {
			if (i == sum) {
				counter++;
			}
		}

		counter += checkPath(node.left, sum, nodeValues, newSet);
		counter += checkPath(node.right, sum, nodeValues, newSet);

		nodeValues.pop();
		return counter;
	}

	public static int pathSum(TreeNode root, int sum) {
		Stack<Integer> paths = new Stack<>();
		List<Integer> sums = new ArrayList<>();
		int res = checkPath(root, sum, paths, sums);
		return res;
	}

	public static void main(String[] arg) {

		Integer[] vals = { 10, 5, -3, 3, 2, null, 11, 3, -2, null, 1 };
		TreeNode tree = Utils.loadTree(vals);

		System.out.println(pathSum(tree, 8));

		Integer[] vals2 = { 0, 1, 1 };
		TreeNode tree2 = Utils.loadTree(vals2);

		System.out.println(pathSum(tree2, 1));


	}
}
