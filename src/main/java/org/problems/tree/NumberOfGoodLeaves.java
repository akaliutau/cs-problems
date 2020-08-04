package org.problems.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.problems.model.TreeNode;

/**
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 * 
 * Given the root of a binary tree and an integer distance. A pair of two
 * different leaf nodes of a binary tree is said to be good if the length of the
 * shortest path between them is less than or equal to distance.
 * 
 * Return the number of good leaf node pairs in the tree.
 * 
 * 
 * 
 */
public class NumberOfGoodLeaves {

	static class Path {
		public int len;
		public List<Integer> p = new ArrayList<>();

		public Path(Stack<Integer> path) {
			p = new ArrayList<>(path);
			len = p.size();
		}

		@Override
		public String toString() {
			return "Path [len=" + len + ", p=" + p + "]";
		}
	}

	static void build(TreeNode node, Stack<Integer> path, Map<Path, Integer> map) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			map.put(new Path(path), node.val);
		} else {
			path.add(0);
			build(node.left, path, map);
			path.pop();
			path.add(1);
			build(node.right, path, map);
			path.pop();
		}
	}

	static int hash(int[] arr) {
		Arrays.parallelSort(arr);
		return arr[0] * 1000 + arr[1];
	}

	static int dist(Path p1, Path p2) {
		for (int i = 0; i < p1.len && i < p2.len; i++) {
			if (p1.p.get(i) != p2.p.get(i)) {
				return p1.len - i + p2.len - i;
			}
		}
		return 0;
	}

	public int countPairs(TreeNode root, int distance) {

		Map<Path, Integer> map = new HashMap<>();
		Stack<Integer> path = new Stack<>();
		build(root, path, map);
		if (map.isEmpty()) {
			return 0;
		}
		if (map.size() == 1) {
			return 0;
		}
		List<Path> paths = new ArrayList<>(map.keySet());
		Set<Integer> found = new HashSet<>();
		int counter = 0;
		for (int i = 0; i < paths.size(); i++) {
			Path p1 = paths.get(i);
			for (int j = i + 1; j < paths.size(); j++) {
				Path p2 = paths.get(j);
				int d = dist(p1, p2);
				if (d <= distance) {
					int[] arr = { map.get(p1), map.get(p2) };
					int h = hash(arr);
					if (!found.contains(h)) {
						found.add(h);
					}
					counter++;
				}
			}
		}
		return counter;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
