package org.problems.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 * 
 * Given a binary tree, find the length of the longest path where each node in
 * the path has the same value. This path may or may not pass through the root.
 * 
 * The length of path between two nodes is represented by the number of edges
 * between them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 *         5 
 *        / \ 
 *       4   5 
 *      / \   \ 
 *     1   1   5 
 *     Output: 2
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 
 *         1
 *        / \ 
 *       4   5 
 *      / \   \ 
 *     4   4   5
 *  Output: 2
 * 
 * 
 * 
 * Note: The given binary tree has not more than 10000 nodes. 
 * The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath {
	
	static class Holder {
		public int counter;
		public int max = 0;
		public TreeNode node;
		
		
		public void inc() {
			counter ++;
			if (counter > max) {
				max = counter;
			}
		}

		@Override
		public String toString() {
			return "Holder [counter=" + counter + ", max=" + max + "]";
		}
	}
	
	static void path(TreeNode node, TreeNode maxNodeRef, Map<TreeNode, Holder> stat) {
		if (node == null) {
			return;
		}
		TreeNode next = null;
		if (maxNodeRef.val == node.val) {
			if (!stat.containsKey(maxNodeRef)) {
				stat.put(maxNodeRef, new Holder());
			}
			stat.get(maxNodeRef).inc();
			next = maxNodeRef;
		}else {
			if (!stat.containsKey(node)) {
				stat.put(node, new Holder());
			}
			stat.get(node).inc();
			next = node;
		}
		path(node.left, next, stat);
		path(node.right, next, stat);
		
	}
	
	static class Result {
		public boolean internal = false;
		public int max = 0;
		
		public void update(int val, boolean internal) {
			if (val > max) {
				this.internal = internal;
				max =val;
			}
		}
	}
	
	static int trace(TreeNode node, int val, int level, Result res) {
		if (node == null) {
			return level - 1;
		}
		if (node.val != val) {
			return level == 0 ? 0 : level - 1;
		}
		int left = trace(node.left, val, level + 1, res);
		int right = trace(node.right, val, level + 1, res);
		
		int internal = left - level + right - level;
		int max = Math.max(left, right);

		if (internal > max) {
			res.update(internal, true);
		}else {
			res.update(max, false);
		}
		return max;
	}

	public static int longestUnivaluePath(TreeNode root) {
		Map<TreeNode, Holder> map = new HashMap<>();
		if (root == null) {
			return 0;
		}
		path(root, root, map);
		
		for (TreeNode node : map.keySet()) {
			Holder holder = map.get(node);
			holder.node = node;
		}
		Comparator<Holder> byMax = (o,p) -> Integer.compare(p.max, o.max);
		List<Holder> lst = new ArrayList<>(map.values());
		Collections.sort(lst, byMax);
		int max = lst.get(0).max;
		int maxValue = 0;
		for (Holder h : lst) {
			if (h.max <= maxValue) {
				break;
			}
			Result res = new Result();
			trace(h.node, h.node.val, 0, res);
			maxValue = Math.max(maxValue, res.max);
		}
		return maxValue;
	}

	public static void main(String[] arg) {
		
		Integer[] intarr = {1, 4, 5, 4, 4, null, 5};
		TreeNode root = Utils.loadTree(intarr);
		

		System.out.println(longestUnivaluePath(root));

		
		Integer[] intarr1 = {5, 4, 5, 1, 1, null, 5};
		TreeNode root1 = Utils.loadTree(intarr1);
		

		System.out.println(longestUnivaluePath(root1));

		Integer[] intarr2 = {1, 4, 5, 4, 4, null, 5, null, null, null, 5, null, null, null, null};
		TreeNode root2 = Utils.loadTree(intarr2);
		

		System.out.println(longestUnivaluePath(root2));

		Integer[] intarr3 = {1};
		TreeNode root3 = Utils.loadTree(intarr3);
		

		System.out.println(longestUnivaluePath(root3));

		Integer[] intarr4 = {5, 4,5, 4,4,5,3, 4,4,null,null,null,4,null,null, 4,null,null,4,null,4, 4,null,null,4,4};
		TreeNode root4 = Utils.loadTree(intarr4);
		

		System.out.println(longestUnivaluePath(root4));
		
		Integer[] intarr5 = {4,  4, 5,  4, 4, 5, 5,  4, null};
		TreeNode root5 = Utils.loadTree(intarr5);
		

		System.out.println(longestUnivaluePath(root5));
		
	}

}
