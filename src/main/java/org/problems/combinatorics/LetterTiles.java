package org.problems.combinatorics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/letter-tile-possibilities/
 * 
 * You have a set of tiles, where each tile has one letter tiles[i] printed on
 * it. Return the number of possible non-empty sequences of letters you can
 * make.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "AAB" Output: 8 
 * Explanation: The possible sequences are "A", "B",
 * "AA", "AB", "BA", "AAB", "ABA", "BAA". 
 * 
 * Example 2:
 * 
 * Input: "AAABBC" Output: 188
 * 
 * 
 * Note:
 * 
 * 1 <= tiles.length <= 7 
 * tiles consists of uppercase English letters.
 * 
 * Runtime: 3 ms, faster than 71.92% of Java online submissions for Letter Tile Possibilities.
 * Memory Usage: 38.9 MB, less than 56.03% of Java online submissions for Letter Tile Possibilities.
 * 
 */
public class LetterTiles {
	
	static class Result {
		public int counter = 0;
	}
	
	static class Tile {
		public String str;
		public int[] distr = new int[26];
		public int len;
		public int variants;
		
		public Tile(String str) {
			this.str = str;
			this.len = str.length();
			for (int i = 0; i < len; i++) {
				int c = str.charAt(i) - 'A';
				distr[c] ++;
			}
			long f1 = fact(len);
			for (int i = 0; i < 26; i++) {
				if (distr[i] > 0) {
					f1 = f1 / fact(distr[i]);
				}
			}	
			variants = (int) f1;
		}
		
		public static int fact(int n) {
			long f = 1;
			if (n <= 1) {
				return 1;
			}
			while (n > 1) {
				f = f * n;
				n--;
			}
			return (int) f;
		}
		

		@Override
		public String toString() {
			return "Tile [str=" + str + ", variants=" + variants + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(distr);
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
			Tile other = (Tile) obj;
			if (!Arrays.equals(distr, other.distr))
				return false;
			return true;
		}
		
	}
	
	static void getPossibilities(Tile t, Set<Tile> processed, Result result) {
		int n = t.len;
		if (n == 1) {
			result.counter ++;
		}else {
			result.counter += t.variants;
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (i != j) {
						sb.append(t.str.charAt(j));
					}
				}
				Tile can = new Tile(sb.toString());
				if (!processed.contains(can)) {
					getPossibilities(can, processed, result);
				}
			}
		}
		processed.add(t);
	}

	public static int numTilePossibilities(String tiles) {
		Set<Tile> processed = new HashSet<>();
		Result result = new Result();
		Tile can = new Tile(tiles);
		getPossibilities(can, processed, result);
//		System.out.println(processed);
		return result.counter;
	}

	public static void main(String[] arg) {

		System.out.println(numTilePossibilities("ABA"));
		System.out.println(numTilePossibilities("AAB"));
		System.out.println(numTilePossibilities("AAABBC"));

	}

}
