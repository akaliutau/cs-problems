package org.problems.tree;

import org.problems.model.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 * 
 * Given two binary trees and imagine that when you put one of them to cover the
 * other, some nodes of the two trees are overlapped while the others are not.
 * 
 * You need to merge them into a new binary tree. The merge rule is that if two
 * nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 * 
 */
public class MergeTwoBinaryTrees {
	
	static void compose (TreeNode main, TreeNode branch) {
        if (main == null || branch == null){
            return;
        }    
		main.val = main.val + branch.val;
		if (main.left == null && branch.left == null && main.right == null && branch.right == null) {
			return;// merged
		}
            boolean left = false;
		if (main.left == null && branch.left != null) {
			main.left = branch.left;
            left = true;
		}
           boolean right = false;
		if (main.right == null && branch.right != null) {
			main.right = branch.right;
            right = true;
		}
        if (!left)    
		compose(main.left, branch.left);
        if (!right)    
		compose(main.right, branch.right);
	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return null;
        }
        if (t1 == null ){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
		TreeNode main = t1;
		compose(main, t2);
		return main;
	}

	public static void main(String[] arg) {

	}

}
