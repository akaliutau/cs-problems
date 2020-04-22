package com.leetcode.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * 
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array. 
 * 
 * Example 1: Input: 
 * 			3 
 *         / \ 
 *        9   20 
 *            / \ 
 *           15  7 
 *           
 * Output: [3, 14.5, 11]
 * 
 * 
 */
public class AverageofLevelsinBinaryTree {
	
	static class Level {
		public long sum = 0;
		public int n = 0;
		
		public double getAvg() {
			if (n != 0) {
				return (double) sum / n;
			}
			return 0.0d;
		}
	}
	
	static void getStat(TreeNode node, int level, Map<Integer,Level> levels) {
		if (node == null) {
			return;
		}
		if (!levels.containsKey(level)) {
			levels.put(level, new Level());
		}
		levels.get(level).n ++;
		levels.get(level).sum += node.val;
		getStat(node.left, level+1, levels);
		getStat(node.right, level+1, levels);
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		Map<Integer,Level> levels = new HashMap<>();
		getStat(root,0,levels);
		List<Double> avg = new ArrayList<>();
		int totalLevels = levels.size();
		for (int i = 0; i < totalLevels; i++) {
			avg.add(levels.get(i).getAvg());
		}
		return avg;

	}

	public static void main(String[] arg) {
		
		Integer[] in = {3, 9, 20, null, null, 15, 7};
		TreeNode root = Utils.loadTree(in);
		

		System.out.println(averageOfLevels(root));
		
		Integer[] in1 = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
		TreeNode root1 = Utils.loadTree(in1);
		

		System.out.println(averageOfLevels(root1));


	}

}
