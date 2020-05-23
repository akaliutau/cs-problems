package org.problems.iterations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/jump-game-ii/
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4] Output: 2
 * 
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
 * step from index 0 to 1, then 3 steps to the last index. Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 * Solution: 
 * 1. Build graph using nums[i] as criteria of nearness 
 * 
 * 2. Use Dijkstra algorithm to find the best (extremal) path 
 * 
 * 3. Return length of path as solution
 * 
 */
public class JumpGameII {

	public static class Node {
		int id;
		int val;
		int dist = Integer.MAX_VALUE;
		List<Node> ref = new ArrayList<>();

		public Node(int id, int val) {
			this.id = id;
			this.val = val;
		}

		@Override
		public String toString() {
			return "id=" + id + ",ref.size=" + ref.size();
		}

	}

	static void processRange(int[] nums, int left, int right, Node result, Set<Integer> processed, Queue<Node> toProcess) {
		for (int i = left; i <= right; i++) {
			if (i >= 0 && i < nums.length && !processed.contains(i)) {
				result.ref.add(new Node(i, nums[i]));
			}
		}
		toProcess.addAll(result.ref);
	}
	

	public static int jump(int[] nums) {
		Node root = new Node(0, nums[0]);
		if (root.val == 0) {
			return 0;
		}
        if (nums.length == 1) {
			return 0;
		}
		
		Set<Integer> processed = new HashSet<>();
		Queue<Node> toProcess = new LinkedList<>();
		toProcess.add(root);
		while (!toProcess.isEmpty()) {
			Node node = toProcess.poll();
			processed.add(node.id);
			int dist = node.val;
			processRange(nums, node.id - dist, node.id + dist, node, processed, toProcess);
		}
		// walk through graph starting at root 
		int len = 0;
		int lastId = nums.length-1;
		toProcess.add(root);
		root.dist = 0;
		while(!toProcess.isEmpty()) {
			Node curNode = toProcess.poll();
			len ++;
			boolean found = false;
			for (Node node : curNode.ref) {
				if (node.dist > (curNode.dist+1)) {
					node.dist = curNode.dist+1;
				}
				if (node.id == lastId) {
					found = true;
					len = curNode.dist;
					break;
				}
			}
			if (found) {
				break;
			}
			toProcess.addAll(curNode.ref);
		}
		
		return len+1;

	}

	public static void main(String[] arg) {

		int[] nums = new int[] { 2, 3, 1, 1, 4 };
		System.out.println(jump(nums));

		int[] nums1 = new int[] { 2};
		System.out.println(jump(nums1));

		int[] nums2 = new int[] { 4, 3, 1, 1, 4 };
		System.out.println(jump(nums2));

		int[] nums3 = new int[] { 0};
		System.out.println(jump(nums3));

		int[] nums4 = new int[] { 2};
		System.out.println(jump(nums4));

		int[] nums5 = new int[] { 1,2,1,1,1};
		System.out.println(jump(nums5));
}
}
