package org.problems.tree;

import java.util.ArrayList;
import java.util.List;

import org.problems.model.TreeNode;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 * 
 * Consider all the leaves of a binary tree. From left to right order, the
 * values of those leaves form a leaf value sequence.
 * 
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9,
 * 8).
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 * 
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 * 
 * Constraints:
 * 
 * Both of the given trees will have between 1 and 200 nodes. Both of the given
 * trees will have values between 0 and 200
 * 
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for
 * Leaf-Similar Trees. 
 * Memory Usage: 37.6 MB, less than 54.75% of Java online
 * submissions for Leaf-Similar Trees.
 * 
 * 
 */
public class LeafSimilarTrees {

	static class LeafSequence {
		public List<Integer> seq = new ArrayList<>();
		public int idx = 0;

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
			LeafSequence other = (LeafSequence) obj;
			if (seq == null) {
				if (other.seq != null)
					return false;
			} else if (!seq.equals(other.seq))
				return false;
			return true;
		}
	}

	static void getSeq(TreeNode node, LeafSequence seq) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			seq.seq.add(node.val);
			return;
		}
		getSeq(node.left, seq);
		getSeq(node.right, seq);
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		LeafSequence seq1 = new LeafSequence();
		LeafSequence seq2 = new LeafSequence();
		getSeq(root1, seq1);
		getSeq(root2, seq2);
		return seq1.equals(seq2);
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
