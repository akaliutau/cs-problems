package com.leetcode.utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

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
		Queue<TreeNode> toProcess = new LinkedList<>();
		toProcess.add(root);
		while (++idx < tree.length) {
			TreeNode cur = toProcess.poll();
			if (tree[idx] != null) {
				cur.left = new TreeNode(tree[idx]);
				toProcess.add(cur.left);
			}else {
				cur.left = null;
			}
			idx++;
			if (tree[idx] != null) {
				cur.right = new TreeNode(tree[idx]);
				toProcess.add(cur.right);
			}else {
				cur.right = null;
			}
		}
		return root;
	}

	public static void print(int[] vector) {
		print(Arrays.stream(vector).boxed());
	}
	
	public static void print(int[][] vector) {
		for (int i = 0; i < vector.length; i++) {
			print(Arrays.stream(vector[i]).boxed());
		}
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

}
