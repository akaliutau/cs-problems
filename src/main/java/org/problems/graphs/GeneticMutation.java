package org.problems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 * 
 * A gene string can be represented by an 8-character long string, with choices
 * from "A", "C", "G", "T".
 * 
 * Suppose we need to investigate about a mutation (mutation from "start" to
 * "end"), where ONE mutation is defined as ONE single character changed in the
 * gene string.
 * 
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * 
 * Also, there is a given gene "bank", which records all the valid gene
 * mutations. A gene must be in the bank to make it a valid gene string.
 * 
 * Now, given 3 things - start, end, bank, your task is to determine what is the
 * minimum number of mutations needed to mutate from "start" to "end". If there
 * is no such a mutation, return -1.
 * 
 * Note:
 * 
 * Starting point is assumed to be valid, so it might not be included in the
 * bank. If multiple mutations are needed, all mutations during in the sequence
 * must be valid. You may assume start and end string is not the same.
 * 
 * 
 * Example 1:
 * 
 * start: "AACCGGTT" end: "AACCGGTA" bank: ["AACCGGTA"]
 * 
 * return: 1
 * 
 * 
 * Example 2:
 * 
 * start: "AACCGGTT" end: "AAACGGTA" bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 
 * return: 2
 * 
 * 
 * Example 3:
 * 
 * start: "AAAAACCC" end: "AACCCCCC" bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 
 * return: 3
 * 
 * Runtime: 1 ms, faster than 41.54% of Java online submissions for Minimum Genetic Mutation.
 * Memory Usage: 39.2 MB, less than 7.69% of Java online submissions for Minimum Genetic Mutation
 * 
 */
public class GeneticMutation {
	
	static class Gen {
		public String str;
		public List<Gen> refs = new ArrayList<>();
		public int count = -1;

		public Gen(String str) {
			this.str = str;
		}
		
		public boolean isMutable(Gen gen) {
			int count = 0;
			for (int i = 0; i < 8; i++) {
				if (gen.str.charAt(i) != str.charAt(i)) {
					count ++;
				}
				if (count > 1) {
					return false;
				}
			}
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((str == null) ? 0 : str.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Gen other = (Gen) obj;
			if (str == null) {
				if (other.str != null)
					return false;
			} else if (!str.equals(other.str))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Gen [str=" + str + ", refs=" + refs.size() + ", count=" + count + "]";
		}

	}
	
	static Gen buildNet(Gen root, List<Gen> gens) {
		int n = gens.size();
		for (int i = 0; i < n; i++) {
			Gen gen = gens.get(i);
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				Gen related = gens.get(j);
				if (gen.isMutable(related)) {
					gen.refs.add(related);
				}
			}
		}
		return root;
		
	}

	public static int minMutation(String start, String end, String[] bank) {
		
		List<Gen> gens = new ArrayList<>();
		Gen startGen = new Gen(start);
		Gen endGen = new Gen(end);
		gens.add(startGen);
		gens.add(endGen);
		boolean endGenPresent = false;
		for (String s : bank) {
			if (s.equals(end)) {
				endGenPresent = true;
			}else {
				gens.add(new Gen(s));
			}
		}
		buildNet(startGen, gens);

		if (startGen.equals(endGen)) {
			return 0;
		}
		if (!endGenPresent) {
			return -1;
		}
		// end gen presents in bank
		if (startGen.isMutable(endGen)) {
			return 1;
		}
		Queue<Gen> queue = new LinkedList<>();
		queue.add(startGen);
		while (!queue.isEmpty()) {
			Gen g = queue.poll();
			g.count++;
			if (g == endGen) {
				break;
			}
			for (Gen ref : g.refs) {
				if (ref.count == -1) {
					ref.count = g.count;
					queue.add(ref);
				}
			}
		}
		return endGen.count;
        
    }

	public static void main(String[] arg) {
		
		String[] bank = {"AACCGGTA"};
		System.out.println(minMutation("AACCGGTT", "AACCGGTA", bank));

		String[] bank1 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		System.out.println(minMutation("AACCGGTT", "AAACGGTA", bank1));

		String[] bank2 = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
		System.out.println(minMutation("AAAAACCC", "AACCCCCC", bank2));

		String[] bank3 = {"AAAACCCC", "ACACCCCC", "AACCCCCC"};
		System.out.println(minMutation("AAAAACCC", "AACCCCCC", bank3));

	}

}
