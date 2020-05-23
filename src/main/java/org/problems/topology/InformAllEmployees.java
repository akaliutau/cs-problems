package org.problems.topology;

/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * 
 * A company has n employees with a unique ID for each employee from 0 to n - 1.
 * The head of the company has is the one with headID.
 * 
 * Each employee has one direct manager given in the manager array where
 * manager[i] is the direct manager of the i-th employee, manager[headID] = -1.
 * Also it's guaranteed that the subordination relationships have a tree
 * structure.
 * 
 * The head of the company wants to inform all the employees of the company of
 * an urgent piece of news. He will inform his direct subordinates and they will
 * inform their subordinates and so on until all employees know about the urgent
 * news.
 * 
 * The i-th employee needs informTime[i] minutes to inform all of his direct
 * subordinates (i.e After informTime[i] minutes, all his direct subordinates
 * can start spreading the news).
 * 
 * Return the number of minutes needed to inform all the employees about the
 * urgent news.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1, headID = 0, manager = [-1], informTime = [0] Output: 0
 * Explanation: The head of the company is the only employee in the company.
 * 
 * 
 */
public class InformAllEmployees {

	public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

		int tMax = 0;
		for (int i = 0; i < manager.length; i++) {
			int t = informTime[headID];
			int manId = i;
			while (headID != manId) {
				t += informTime[manId];
				manId = manager[manId];
			}
			tMax = tMax > t ? tMax : t;
		}

		return tMax;

	}

	public static void main(String[] arg) {

		int n0 = 1;
		int headID0 = 0;
		int[] manager0 = { -1 };
		int[] informTime0 = { 0 };
		System.out.println(numOfMinutes(n0, headID0, manager0, informTime0));

		int n1 = 6;
		int headID1 = 2;
		int[] manager1 = { 2, 2, -1, 2, 2, 2 };
		int[] informTime1 = { 0, 0, 1, 0, 0, 0 };
		System.out.println(numOfMinutes(n1, headID1, manager1, informTime1));

		int n3 = 7;
		int headID3 = 6;
		int[] manager3 = { 1, 2, 3, 4, 5, 6, -1 };
		int[] informTime3 = { 0, 6, 5, 4, 3, 2, 1 };
		System.out.println(numOfMinutes(n3, headID3, manager3, informTime3));

		int n4 = 15;
		int headID4 = 0;
		int[] manager4 = { -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 };
		int[] informTime4 = { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(numOfMinutes(n4, headID4, manager4, informTime4));

	}

}
