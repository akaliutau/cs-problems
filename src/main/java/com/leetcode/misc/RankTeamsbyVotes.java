package com.leetcode.misc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/rank-teams-by-votes/
 *
 * In a special ranking system, each voter gives a rank from highest to lowest
 * to all teams participated in the competition.
 * 
 * The ordering of teams is decided by who received the most position-one votes.
 * If two or more teams tie in the first position, we consider the second
 * position to resolve the conflict, if they tie again, we continue this process
 * until the ties are resolved. If two or more teams are still tied after
 * considering all positions, we rank them alphabetically based on their team
 * letter.
 * 
 * Given an array of strings votes which is the votes of all voters in the
 * ranking systems. Sort all teams according to the ranking system described
 * above.
 * 
 * Return a string of all teams sorted by the ranking system.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: votes = ["ABC","ACB","ABC","ACB","ACB"] Output: "ACB"
 * 
 */
public class RankTeamsbyVotes {

	public static class Vote {
		public char letter;
		public int[] votes;

		public Vote(char letter, int[] votes) {
			this.letter = letter;
			this.votes = votes;
		}

	}

	public static String rankTeams(String[] votes) {

		Comparator<Vote> sortByLetter = (o, p) -> Character.compare(o.letter, p.letter);// desc
		Comparator<Vote> sortByVotes = (o, p) -> {
			int[] votes1 = o.votes;
			int[] votes2 = p.votes;
			int n = p.votes.length;
			for (int i = 0; i < n; i++) {
				if (votes1[i] > votes2[i]) {
					return -1;
				} else if (votes1[i] < votes2[i]) {
					return 1;
				}
			}
			return 0;
		};
		int nv = votes.length;
		Map<Character, Vote> map = new HashMap<>();
		for (String block : votes) {
			for (int i = 0; i < block.length(); i++) {
				char c = block.charAt(i);
				if (!map.containsKey(c)) {
					map.put(c, new Vote(c, new int[block.length()]));
				}
				int[] vArr = map.get(c).votes;
				vArr[i] = vArr[i] + 1;
			}
		}
		List<Vote> collected = map.values().stream().sorted(sortByVotes.thenComparing(sortByLetter))
				.collect(Collectors.toList());
		StringBuilder sb = new StringBuilder();
		for (Vote v : collected) {
			sb.append(v.letter);
		}
		return sb.toString();

	}

	public static void main(String[] arg) {

		String[] arr = { "ABC", "ACB", "ABC", "ACB", "ACB" };
		System.out.print(rankTeams(arr));

	}

}
