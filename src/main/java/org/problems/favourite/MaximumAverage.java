package org.problems.favourite;

import org.problems.model.TreeNode;
import org.problems.utils.Utils;

/**
 * Maximum Average
 * 
 * Given an tree, find the subtree with the maximum average. Return the
 * root of the subtree. A subtree of a tree is the node which have at least 1
 * child plus all its descendants. The average value of a subtree is the sum of
 * its values, divided by the number of nodes
 */
public class MaximumAverage {
	
	static class NodeAverage {
		public double avg;
		public int count;

		public NodeAverage(double avg, int count) {
			this.avg = avg;
			this.count = count;
		}

	}
	
	static class Result {
		public double max = Integer.MIN_VALUE;
		public TreeNode maxNode;
	}
	
	private static NodeAverage process(TreeNode node, Result result) {
	    if (node == null) {
	    	return new NodeAverage(0, 0);
	    }

	    double curTotal = node.val;
	    int count = 1;
	    if (node.left != null) {
	    	NodeAverage na = process(node.left, result);
	        curTotal += na.avg;
	        count += na.count;
	    }
	    if (node.right != null) {
	    	NodeAverage na = process(node.right, result);
	        curTotal += na.avg;
	        count += na.count;
	    }
	    
	    double avg = curTotal / count;
	    if (count > 1 && avg > result.max) {
	    	result.max = avg;
	    	result.maxNode = node;
	    }
	    return new NodeAverage(curTotal, count);
	}


	public static TreeNode maximumAverageSubtree(TreeNode root) {
	    if (root == null) {
	    	return null;
	    }
	    Result result = new Result();
	    process(root, result);
	    return result.maxNode;
	}


	public static void main(String[] arg) {
		
		Integer[] tree = {20, 12,18, 11,3,15,8};
		
		TreeNode tr = Utils.loadTree(tree);
		

		System.out.println(maximumAverageSubtree(tr));

	}

}
