package org.problems.games;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 * 
 * In a town, there are N people labelled from 1 to N. There is a rumor that one
 * of these people is secretly the town judge.
 * 
 * If the town judge exists, then:
 * 
 * 1) The town judge trusts nobody. 
 * 2) Everybody (except for the town judge) trusts the town judge. 
 * 
 * There is exactly one person that satisfies properties 1 and
 * 2. You are given trust, an array of pairs trust[i] = [a, b] representing that
 * the person labelled a trusts the person labelled b.
 * 
 * If the town judge exists and can be identified, return the label of the town
 * judge. Otherwise, return -1.
 * 
 * 
 * 
 * Example 1:
 * Input: N = 2, trust = [[1,2]] Output: 2 
 * 
 * Example 2:
 * Input: N = 3, trust = [[1,3],[2,3]] Output: 3 
 * 
 * Example 3:
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]] Output: -1 
 * 
 * Example 4:
 * Input: N = 3, trust = [[1,2],[2,3]] Output: -1 
 * 
 * Example 5:
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]] Output: 3
 * 
 * 
 * Note:
 * 
 * 1 <= N <= 1000 
 * trust.length <= 10000 
 * trust[i] are all different 
 * trust[i][0] != trust[i][1] 
 * 1 <= trust[i][0], trust[i][1] <= N
 * 
 */
public class FindJudge {

	public static int findJudge(int n, int[][] trust) {
		
		boolean[] trustTo = new boolean[n];
		int[] trustBy = new int[n];
		for (int[] person : trust) {
			trustBy[person[1]-1] ++;
			trustTo[person[0]-1] = true;
		}

		int judge = -1;
		for (int i = 0; i < n; i++) {
			if (trustBy[i] == n-1 && !trustTo[i]) {
				if (judge == -1) {
					judge = i+1;
				}else {
					return -1;
				}
			}
		}
		return judge;

	}

	public static void main(String[] arg) {
		
		int[][] trust = {
				{1, 2}
		};
		System.out.println(findJudge(2,trust));

		int[][] trust1 = {
				{1, 3},
				{2, 3}
		};
		System.out.println(findJudge(3,trust1));


		int[][] trust2 = {
				{1,3},
				{2,3},
				{3,1}
		};
		System.out.println(findJudge(3,trust2));


		int[][] trust3 = {
				{1, 2},
				{2, 3}
		};
		System.out.println(findJudge(3,trust3));


		int[][] trust4 = {
				{1,3},
				{1,4},
				{2,3},
				{2,4},
				{4,3}
		};
		System.out.println(findJudge(4,trust4));


	}

}
