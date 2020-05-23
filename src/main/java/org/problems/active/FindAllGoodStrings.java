package org.problems.active;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/find-all-good-strings/
 * 
 * Given the strings s1 and s2 of size n, and the string evil. Return the number
 * of good strings.
 * 
 * A good string has size n, it is alphabetically greater than or equal to s1,
 * it is alphabetically smaller than or equal to s2, and it does not contain the
 * string evil as a substring. Since the answer can be a huge number, return
 * this modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2, s1 = "aa", s2 = "da", evil = "b" Output: 51 
 * 
 * Explanation: There
 * are 25 good strings starting with 'a': "aa","ac","ad",...,"az". Then there
 * are 25 good strings starting with 'c': "ca","cc","cd",...,"cz" and finally
 * there is one good string starting with 'd': "da". Example 2:
 * 
 * Input: n = 8, s1 = "leetcode", s2 = "leetgoes", evil = "leet" Output: 0
 * 
 * Explanation: All strings greater than or equal to s1 and smaller than or
 * equal to s2 start with the prefix "leet", therefore, there is not any good
 * string. Example 3:
 * 
 * Input: n = 2, s1 = "gx", s2 = "gz", evil = "x" Output: 2
 * 
 * 
 * Constraints:
 * 
 * s1.length == n s2.length == n 1 <= n <= 500 1 <= evil.length <= 50 All
 * strings consist of lowercase English letters.
 * 
 * 
 * 
 */
public class FindAllGoodStrings {

	static class Stat {
		public long match = 0;

		public void add(long val) {
			match += val;
			match = match % 1000000007;
		}

		@Override
		public String toString() {
			return "Stat [match=" + match + "]";
		}
	}

	public static long possibilities(int n, int amount) {
		long sum = 0;
		long base = 1;
		System.out.println(String.format("pos (%d,%d) ",n,amount));
		if (amount == 0) {
			return 0;
		}
		if (n == 0) {
			return amount;
		}
		while (n-- > 0) {
			base *= 26;
			base = base % 1000000007;
			sum += base;
			sum = sum % 1000000007;
		}
		sum = sum * amount;
		sum = sum % 1000000007;
		return sum;
	}

	public static int[] conv(String s) {
		int[] arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i) - 'a';
		}
		return arr;
	}

	public static void removeEvil(int[] from, int[] to, int idx, int[] evil, int eidx, Stat stat) {
		if (idx > from.length-1) {// sequence finished, return without update
			return;
		}
		Utils.print(from);
		Utils.print(to);
		System.out.println("idx "+idx);
		Utils.print(evil);
		System.out.println("eidx "+eidx);

		if (eidx == evil.length-1) {
			if (from[idx] <= evil[eidx] && evil[eidx] <= to[idx]) {
				long toRemove = possibilities(from.length - 1 - idx, 1); 
				System.out.println("toRemove "+toRemove);
				stat.add(-toRemove);
				return;
			}
		} else {
			if (from[idx] <= evil[eidx] && evil[eidx] <= to[idx]) {
				removeEvil(from, to, idx + 1, evil, eidx + 1, stat);
			}
		}

	}

	public static int[] sub(int[] from, int[] to, int n) {
		int excess = 0;
		int[] res = new int[n];
		for (int i = n-1; i > -1; i--) {
			if (to[i] - excess >= from[i]) {
				res[i] = to[i] - from[i] - excess;
				excess = 0;
			} else {
				res[i] = 27 + to[i] - from[i] - excess;
				excess = 1;
			}
		}
		return res;
	}

	public static int findGoodStrings(int n, String s1, String s2, String evil) {
		int[] from = conv(s1);
		int[] to = conv(s2);
		int[] e = conv(evil);

		int[] diff = sub(from, to, n);
		Utils.print(diff);
		Stat stat = new Stat();
		System.out.println("n "+n);

		for (int i = n - 1; i > -1; i--) {
			stat.add(possibilities(i, diff[n-1-i]));
		}
		stat.add(1);
		System.out.println(stat.toString());
		removeEvil(from, to, 0, e, 0, stat);

		return (int) stat.match;

	}

	public static void main(String[] arg) {

		System.out.println(findGoodStrings(2,"aa","da","b"));
		System.out.println(findGoodStrings(2,"gx","gz","y"));

	}

}
