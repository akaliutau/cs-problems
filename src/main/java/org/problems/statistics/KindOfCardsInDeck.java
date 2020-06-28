package org.problems.statistics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * 
 * In a deck of cards, each card has an integer written on it.
 * 
 * Return true if and only if you can choose X >= 2 such that it is possible to
 * split the entire deck into 1 or more groups of cards, where:
 * 
 * Each group has exactly X cards. All the cards in each group have the same
 * integer.
 * 
 * 
 * Example 1:
 * 
 * Input: deck = [1,2,3,4,4,3,2,1] Output: true Explanation: Possible partition
 * [1,1],[2,2],[3,3],[4,4]. 
 * 
 * Example 2:
 * 
 * Input: deck = [1,1,1,2,2,2,3,3] Output: false´ Explanation: No possible
 * partition. 
 * 
 * Example 3:
 * 
 * Input: deck = [1] Output: false Explanation: No possible partition. 
 * 
 * Example 4:
 * 
 * Input: deck = [1,1] Output: true Explanation: Possible partition [1,1].
 * Example 5:
 * 
 * Input: deck = [1,1,2,2,2,2] Output: true Explanation: Possible partition
 * [1,1],[2,2],[2,2].
 * 
 * 
 * Constraints:
 * 
 * 1 <= deck.length <= 10^4 
 * 0 <= deck[i] < 10^4
 * 
 * Runtime: 4 ms, faster than 79.56% of Java online submissions for X of a Kind in a Deck of Cards.
 * Memory Usage: 40 MB, less than 38.06% of Java online submissions for X of a Kind in a Deck of Cards.
 */
public class KindOfCardsInDeck {
	
	public static long gcd(long x, long y) {
		if (x == y) {
			return x;
		} else if ((x & 1) == 0 && (y & 1) == 0) {// x and y are even.
			return gcd(x >>> 1, y >>> 1) << 1;
		} else if ((x & 1) == 0 && (y & 1) != 0) {// x is even, y is odd.
			return gcd(x >>> 1, y);
		} else if ((x & 1) != 0 && (y & 1) == 0) {// x is odd, y is even.
			return gcd(x, y >>> 1);
		} else if (x > y) {// Both x and y are odd, and x > y.
			return gcd(x - y, y);
		}
		return gcd(x, y - x); // Both x and y are odd, and x <= y.
	}


	public static boolean hasGroupsSizeX(int[] deck) {
		int n = deck.length;
		if (n < 2) {
			return false;
		}
		int[] state = new int[10001];
		for (int i : deck) {
			state[i] ++;
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 10001; i++) {
			if (state[i] > 0) {
				set.add(state[i]);
			}
		}
		List<Integer> lst = new ArrayList<>(set);
		for (int i = 0; i < lst.size(); i++) {
			for (int j = i + 1; j < lst.size(); j++) {
				if (gcd(lst.get(i), lst.get(j)) == 1) {
					return false;
				}
			}
		}
		
		return true;

	}

	public static void main(String[] arg) {
		
		int[] deck = {1,2,3,4,4,3,2,1};
		System.out.println(hasGroupsSizeX(deck));

		int[] deck1 = {1,1,1,2,2,2,3,3};
		System.out.println(hasGroupsSizeX(deck1));

		int[] deck2 = {1,1,2,2,2,2};
		System.out.println(hasGroupsSizeX(deck2));

		int[] deck3 = {1,1};
		System.out.println(hasGroupsSizeX(deck3));

		int[] deck4 = {1,1,1,1,2,2,2,2,2,2};
		System.out.println(hasGroupsSizeX(deck4));

		int[] deck5 = {1,1,1,1,1,1, 2,2,2,2,2,2,2,2,2, 3,3,3,3,3,3,3,3};
		System.out.println(hasGroupsSizeX(deck5));//false
		
	}

}
