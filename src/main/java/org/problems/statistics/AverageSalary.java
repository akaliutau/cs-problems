package org.problems.statistics;

/**
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * 
 * Given an array of unique integers salary where salary[i] is the salary of the
 * employee i.
 * 
 * Return the average salary of employees excluding the minimum and maximum
 * salary.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: salary = [4000,3000,1000,2000] Output: 2500.00000 
 * Explanation: Minimum
 * salary and maximum salary are 1000 and 4000 respectively. Average salary
 * excluding minimum and maximum salary is (2000+3000)/2= 2500
 */
public class AverageSalary {

	public double average(int[] salary) {
		int n = salary.length;
		long sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, salary[i]);
			max = Math.max(max, salary[i]);
			sum += salary[i];
		}
		return (double) (sum - max - min) / (n - 2);
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
