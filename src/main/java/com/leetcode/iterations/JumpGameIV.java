package com.leetcode.iterations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/jump-game-iv/
 *
 * Given an array of integers arr, you are initially positioned at the first
 * index of the array.
 * 
 * In one step you can jump from index i to index:
 * 
 * i + 1 where: i + 1 < arr.length. 
 * i - 1 where: i - 1 >= 0. 
 * j where: arr[i] == arr[j] and i != j.
 * 
 * Return the minimum number of steps to reach the last index of the array.
 * 
 * Notice that you can not jump outside of the array at any time.
 *
 * 
 * Runtime: 69 ms, faster than 50.00% of Java online submissions for Jump Game
 * IV. Memory Usage: 61.4 MB, less than 100.00% of Java online submissions for
 * Jump Game IV.
 */
public class JumpGameIV {

	public static final int n = 12;

	public static class Pos {
		int index;
		int val;
		List<Pos> ties;
		boolean last = false;
		int dist = 1000000;
		boolean processed = false;

		Pos(int index, int val) {
			this.index = index;
			this.val = val;
		}

		@Override
		public String toString() {
			return "{index=" + index + ", val=" + val + ",dist=" + dist + "}";
		}
	}

	public static int minJumps(int[] full) {

		ArrayList<Integer> cleaned = new ArrayList<>();
		int last;
		if (full.length > 5) {
			last = full[0];
			cleaned.add(full[0]);
			for (int i = 1; i < full.length - 3; i++) {
				if (last != full[i]) {
					cleaned.add(full[i]);
				}
				last = full[i];
			}
			for (int i = full.length - 3; i < full.length; i++) {
				cleaned.add(full[i]);
			}

		} else {
			for (int i = 0; i < full.length; i++) {
				cleaned.add(full[i]);
			}

		}
		Integer[] arr = cleaned.toArray(new Integer[cleaned.size()]);
		System.out.println("arr=" + arr.length);
		Pos[] array = new Pos[arr.length];
		Map<Integer, List<Pos>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			array[i] = new Pos(i, val);
			if (!map.containsKey(val)) {
				map.put(val, new ArrayList<>());
			}
			map.get(val).add(array[i]);
		}
		// update ties
		for (int i = 0; i < arr.length; i++) {
			Pos p = array[i];
			List<Pos> ties = map.get(p.val);
			p.ties = new ArrayList<>();
			for (Pos rel : ties) {
				if (rel.index != i) {
					p.ties.add(rel);
				}
			}
			if (i - 1 > 0) {
				p.ties.add(array[i - 1]);
			}
			if (i + 1 < arr.length) {
				p.ties.add(array[i + 1]);
			}
		}
		// search
		Queue<Pos> q = new LinkedList<Pos>();
		Pos pos = new Pos(-1, 0);
		pos.last = true;
		pos.dist = 0;
		pos.processed = true;
		if (arr.length > 0) {// boundary conditions
			array[arr.length - 1].last = true;
			pos = array[0];
			pos.dist = 0;
			pos.processed = true;
			q.add(pos);
		}

		int jumps = 0;
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			cur.processed = true;
			if (cur.last) {
				jumps = cur.dist;
				break;
			}
			List<Pos> ties = cur.ties;
			for (Pos p : ties) {
				if (cur.dist + 1 < p.dist) {
					p.dist = cur.dist + 1;
				}
				if (!p.processed)
					q.add(p);
			}
		}

		return jumps;

	}

	public static void main(String[] arg) {

		int[] arr = { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 };
		int res = minJumps(arr);

		System.out.print(res);

	}

}
