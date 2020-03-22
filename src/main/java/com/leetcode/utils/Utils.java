package com.leetcode.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

import com.leetcode.model.ListNode;
import com.leetcode.model.TreeNode;

/**
 * I/O util methods
 */
public class Utils {

	private static <T> void print(Stream<T> stream) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		stream.forEach(e -> {
			if (sb.length() > 1) {
				sb.append(",");
			}
			sb.append(e);
		});
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	public static TreeNode loadTree(Integer[] tree) {
		if (tree.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(tree[0]);
		int idx = 0;
		int counter = 1;
		Queue<TreeNode> toProcess = new LinkedList<>();
		toProcess.add(root);
		while (++idx < tree.length) {
			TreeNode cur = toProcess.poll();
			if (idx < tree.length && tree[idx] != null) {
				cur.left = new TreeNode(tree[idx]);
				toProcess.add(cur.left);
				counter++;
			}else {
				cur.left = null;
			}
			idx++;
			if (idx < tree.length && tree[idx] != null) {
				cur.right = new TreeNode(tree[idx]);
				toProcess.add(cur.right);
				counter++;
			}else {
				cur.right = null;
			}
		}
		System.out.println("Total "+counter+" node(s) have been added");
		return root;
	}

	public static void print(int[] vector) {
		print(Arrays.stream(vector).boxed());
	}
	
	public static void print(long[] vector) {
		print(Arrays.stream(vector).boxed());
	}

	
	public static void print(int[][] vector) {
		for (int i = 0; i < vector.length; i++) {
			print(Arrays.stream(vector[i]).boxed());
		}
	}

	public static void print(char[][] vector) {
		for (int i = 0; i < vector.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < vector[i].length; j++) {
				sb.append(vector[i][j]);
			}
			System.out.println(sb.toString());
		}
		System.out.println();
	}


	public static void print(String[] vector) {
		print(Arrays.stream(vector));
	}

	public static void print(char[] vector, int from) {
		int newSize = vector.length - from;
		Character[] newVector = new Character[newSize < 0 ? 0 : newSize];
		for (int i = from; i < vector.length; i++) {
			newVector[i - from] = vector[i];
		}
		print(Arrays.stream(newVector));

	}
	
	public static void print(ListNode lst) {
		if (lst == null) {
			System.out.println("Empty list");
			return;
		}
		Set<ListNode> processed = new HashSet<>();
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		while (lst != null) {
			if (processed.contains(lst)) {
				System.out.println("Cycle detected!");
				//return;
			}
			if (!first) {
				sb.append("->");
			}
			first = false;
			sb.append(lst.val);
			processed.add(lst);
			lst = lst.next;
		}
		System.out.println(sb.toString());
	}


}
