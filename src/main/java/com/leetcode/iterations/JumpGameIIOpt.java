package com.leetcode.iterations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * Runtime: 113 ms, faster than 29.74% of Java online submissions for Jump Game II.
 * Memory Usage: 185.9 MB, less than 5.77% of Java online submissions for Jump Game II
 * 
 */
public class JumpGameIIOpt {

	public static class Node implements Comparable<Node>{
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
			return "id=" + id + ",dist=" + dist;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(node.id, id);
		}

	}

	static boolean processRange(int[] nums, int left, int right, Node result, boolean[] processed, Queue<Node> toProcess, int lastId) {
		boolean found = false;
		for (int i = left; i <= right; i++) {
			if (i >= 0 && i < nums.length && !processed[i]) {
				Node node = new Node(i, nums[i]);
				result.ref.add(node);
				if (node.dist > (result.dist+1)) {
					node.dist = result.dist+1;
				}
				if (node.id == lastId) {
					found = true;
					break;
				}
			}
		}
		Collections.sort(result.ref);
		toProcess.addAll(result.ref);
		return found;
	}
	

	public static int jump(int[] nums) {
		Node root = new Node(0, nums[0]);
		if (root.val == 0) {
			return 0;
		}
        if (nums.length == 1) {
			return 0;
		}
		boolean[] processed = new boolean[nums.length];
		Queue<Node> toProcess = new LinkedList<>();
		root.dist = 0;
		toProcess.add(root);
		int len = 0;
		int lastId = nums.length-1;

		while (!toProcess.isEmpty()) {
			Node node = toProcess.poll();
			len ++;
			processed[node.id] = true;
			int dist = node.val;
			if (processRange(nums, node.id - dist, node.id + dist, node, processed, toProcess, lastId)) {
				len = node.dist;
				break;
			}
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
		
		int[] nums6 = new int[] {5,8,1,8,9,8,7,1,7,5,8,6,5,4,7,3,9,9,0,6,6,3,4,8,0,5,8,9,5,3,7,2,1,8,2,3,8,9,4,7,6,2,5,2,8,2,7,9,3,7,6,9,2,0,8,2,7,8,4,4,1,1,6,4,1,0,7,2,0,3,9,8,7,7,0,6,9,9,7,3,6,3,4,8,6,4,3,3,2,7,8,5,8,6,0};
		System.out.println(jump(nums6));
	}

}
