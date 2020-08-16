package org.problems.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 * 
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of them.
 * 
 * Two trees are duplicate if they have the same structure with same node
 * values.
 * 
 * Example 1:
 * 
 * 			1 
 *         / \ 
 *        2   3 
 *       /   / \ 
 *      4   2   4 
 *         / 
 *        4 
 *        
 * The following are two duplicate subtrees:
 * 
 *    2 
 *   / 
 *  4 
 *  
 * and
 * 
 * 4 
 * 
 * Therefore, you need to return above trees' root in the form of a list.
 * 
 * Runtime: 35 ms, faster than 24.22% of Java online submissions for Find Duplicate Subtrees.
 * Memory Usage: 51.3 MB, less than 33.18% of Java online submissions for Find Duplicate Subtrees.
 * 
 * Solution: use hash for tree, NOTE: introduce separators for left-right branches
 */
public class DuplicateSubtree {
	
	static class TreeHash {

		public List<String> seq = new ArrayList<>();

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((seq == null) ? 0 : seq.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TreeHash other = (TreeHash) obj;
			if (seq == null) {
				if (other.seq != null)
					return false;
			} else if (!seq.equals(other.seq))
				return false;
			return true;
		}

	}
	
	static void process(int hashCode, TreeNode node, Map<Integer, TreeNode> treeMap, List<TreeNode> dup, Set<Integer> processed) {
		if (treeMap.containsKey(hashCode)) {
			if (!processed.contains(hashCode)) {
				dup.add(node);
				processed.add(hashCode);
			}
		} else {
			treeMap.put(hashCode, node);
		}
	}
	
	static void find(TreeNode node, TreeHash tHash, Map<Integer, TreeNode> treeMap, List<TreeNode> dup, Set<Integer> processed) {
		if (node == null) {
            tHash.seq.add("null");
			return;
		}
		TreeHash newHash = new TreeHash();
		newHash.seq.add(String.valueOf(node.val));
		newHash.seq.add("null");
		find(node.left, newHash, treeMap, dup, processed);
		newHash.seq.add("null");
		find(node.right, newHash, treeMap, dup, processed);
		process(newHash.hashCode(), node, treeMap, dup, processed);
		tHash.seq.addAll(newHash.seq);
	}

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		Map<Integer, TreeNode> treeMap = new HashMap<>();
		List<TreeNode> dup = new ArrayList<>();
		Set<Integer> processed = new HashSet<>();
		TreeHash tHash = new TreeHash();
		find(root, tHash, treeMap, dup, processed);
		return dup;
	}

	public static void main(String[] arg) {
		Integer[] arr = {1,2,3,4,null,2,4,null,null,4};
		System.out.println(findDuplicateSubtrees(Utils.loadTree(arr)));

		Integer[] arr1 = {0,0,0,0,null,null,0,null,null,null,0};
		System.out.println(findDuplicateSubtrees(Utils.loadTree(arr1)));
	}

}
