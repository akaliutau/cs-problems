package com.leetcode.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 *
 * You need to construct a string consists of parenthesis and integers from a
 * binary tree with the preorder traversing way.
 * 
 * The null node needs to be represented by empty parenthesis pair "()". And you
 * need to omit all the empty parenthesis pairs that don't affect the one-to-one
 * mapping relationship between the string and the original binary tree.
 * 
 * Example 1: Input: Binary tree: [1,2,3,4] 
 * 
 * 		1 
 *     / \ 
 *    2   3 
 *   / 
 *  4
 * 
 * Output: "1(2(4))(3)"
 * 
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to
 * omit all the unnecessary empty parenthesis pairs. And it will be
 * "1(2(4))(3)". 
 * 
 * Example 2: Input: Binary tree: [1,2,3,null,4] 
 * 
 * 		1 
 *     / \
 *    2   3 
 *     \
 *      4
 * 
 * Output: "1(2()(4))(3)"
 * 
 * 
 * 
 */
public class ConstructStringFromBinaryTree {
	
	static String templ = "%d%s%s";// number(left)(right)
	
	static String getString(TreeNode node) {
		if (node.left == null && node.right == null) {
			return ""+node.val;
		}
		if (node.right == null) {
			return String.format(templ, node.val,"("+getString(node.left)+")","");
		}
		if (node.left == null) {
			return String.format(templ, node.val,"()","("+getString(node.right)+")");
		}
		return String.format(templ, node.val,"("+getString(node.left)+")","("+getString(node.right)+")");
	}

	public static String tree2str(TreeNode t) {
		if (t == null){
            return "";
        }
		return getString(t);
	}

	public static void main(String[] arg) {
		
		Integer[] lst = {1,2,3,null,4};
		TreeNode t = Utils.loadTree(lst);

		System.out.println(tree2str(t));

		Integer[] lst1 = {1,2,3,4};
		TreeNode t1 = Utils.loadTree(lst1);

		System.out.println(tree2str(t1));

	}

}
