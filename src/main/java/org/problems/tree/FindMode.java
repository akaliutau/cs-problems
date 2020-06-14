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
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * 
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key. The right subtree of a node contains only nodes with keys
 * greater than or equal to the node's key. Both the left and right subtrees
 * must also be binary search trees.
 * 
 * 
 * For example: Given BST [1,null,2,2],
 * 
 *    1
 *     \
 *      2
 *      / 
 *     2
 * 
 * 
 * return [2].
 * 
 * Note: If a tree has more than one mode, you can return them in any order
 * 
 * 
 */
public class FindMode {
	
	static class Mode {
		public int val;
		public int freq = 0;
		
		public Mode(int val) {
			this.val = val;
		}
	}
	
	static void find(TreeNode node, Map<Integer, Mode> stat) {
		if (node == null) {
			return;
		}
		if (!stat.containsKey(node.val)) {
			stat.put(node.val, new Mode(node.val));
		}
		stat.get(node.val).freq ++;
		find(node.left, stat);
		find(node.right, stat);
	}

	public static int[] findMode(TreeNode root) {
		Map<Integer, Mode> stat = new HashMap<>();
		find(root, stat);
		Comparator<Mode> byFreq = (o,p) -> Integer.compare(p.freq, o.freq);
		List<Mode> modes = new ArrayList<>(stat.values());
		Collections.sort(modes, byFreq);
		List<Integer> res = new ArrayList<>();
		if (!modes.isEmpty()) {
			int theMostFreq = modes.get(0).freq;
			for (Mode mode : modes) {
				if (mode.freq != theMostFreq) {
					break;
				}
				res.add(mode.val);
			}
					
		}
		int[] results = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			results[i] = res.get(i);
		}
		return results;

	}

	public static void main(String[] arg) {
		
		Integer[] nodes = {1,null,2,2};
		TreeNode root = Utils.loadTree(nodes);

		Utils.print(findMode(root));

	}

}
