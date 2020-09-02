package org.problems.favourite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Highest rank of node in hierarchy
 * 
 * Manager nodes have chid nodes for each employee that reports to them; each of
 * these employees can, in turn, have child nodes representing their respective
 * reportees. Each node in the tree contains an integer representing the number
 * of months the employee has spent at the company. Team tenure is computed as
 * the average tenure of the manager and all the company employees working below
 * the manager. The oldest team has the highest team tenure.
 * 
 * Write an algorithm to find the manager of the team with the highest tenure.
 * An employee must have child nodes to be a manager.
 * 
 * Input The input to the function/method consists of an argument - president, a
 * node representing the root node of the employee hierarchy.
 * 
 * Output Return the node which has the oldest team.
 * 
 * Note There will be at least one child node in the tree and there will be no
 * ties.
 * 
 * Example
 * 
 * Input 
 *
 *		 20
 *	    /   \
 *	  12     18
 *   / | \   | \
 * 11  2  3  15 8
 * 
 * Output = 18 Explanation : There are three managers in this tree with the
 * following team tenures : 
 * 12 => (11+2+3+12)/4 = 7 
 * 18 => (18+15+8)/3 = 13.67 
 * 20 => (12+11+2+3+18+15+8+20)/8 = 11.125
 * 
 * 
 */
public class HighestNodeInHierarchy {
	
	static class Trie {
		int id;
		int age;
		List<Trie> refs = new ArrayList<>();

		public Trie(int id, int age) {
			this.id = id;
			this.age = age;
		}
	}
	
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
		public int id;
	}
	
	private static NodeAverage process(Trie node, Result result) {
	    if (node == null) {
	    	return new NodeAverage(0, 0);
	    }

	    double curTotal = node.age;
	    int count = 1;
	    for (Trie trie : node.refs) {
	    	NodeAverage na = process(trie, result);
	        curTotal += na.avg;
	        count += na.count;
	    }
	    
	    double avg = curTotal / count;
	    if (count > 1 && avg > result.max) {
	    	result.max = avg;
	    	result.id = node.id;
	    }
	    return new NodeAverage(curTotal, count);
	}


	public static int getOldestTeam(int n, int[][] edges, int[] tenure) {
		Map<Integer, Trie> map = new HashMap<>();
		for (int[] edge : edges) {
			if (!map.containsKey(edge[0])) {
				map.put(edge[0], new Trie(edge[0], tenure[edge[0]]));
			}
			if (!map.containsKey(edge[1])) {
				map.put(edge[1], new Trie(edge[1], tenure[edge[1]]));
			}
			map.get(edge[0]).refs.add(map.get(edge[1]));
		}
		Result result = new Result();
		process(map.get(0), result);
		return result.id;
	}
	

	public static void main(String[] arg) {
		//              0   1  2   3  4 5 6  7 
		int[] tenure = {20, 12,18, 11,2,3,15,8};
		
		int[][] edges = {
				{0, 1},	
				{0, 2},	
				{1, 3},	
				{1, 4},	
				{1, 5},	
				{2, 6},	
				{2, 7}	
		};
		
		System.out.println(getOldestTeam(8, edges, tenure));
	}

}
