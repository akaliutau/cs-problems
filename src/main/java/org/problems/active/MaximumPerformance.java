package org.problems.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/maximum-performance-of-a-team/
 * 
 * There are n engineers numbered from 1 to n and two arrays: speed and
 * efficiency, where speed[i] and efficiency[i] represent the speed and
 * efficiency for the i-th engineer respectively. Return the maximum performance
 * of a team composed of at most k engineers, since the answer can be a huge
 * number, return this modulo 10^9 + 7.
 * 
 * The performance of a team is the sum of their engineers' speeds multiplied by
 * the minimum efficiency among their engineers.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60
 * 
 * Explanation: We have the maximum performance of the team by selecting
 * engineer 2 (with speed=10 and efficiency=4) and engineer 5 (with speed=5 and
 * efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
 * 
 * 
 * 
 * 
 */
public class MaximumPerformance {

	static class Eng {

		public int id;
		public int speed;
		public int efficiency;

		public Eng(int id, int speed, int efficiency) {
			this.id = id;
			this.speed = speed;
			this.efficiency = efficiency;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
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
			Eng other = (Eng) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[id=" + id + ", speed=" + speed + ", efficiency=" + efficiency + "]";
		}

	}

	public static long performance(long speedSum, int efficiency) {
		return speedSum * efficiency;
	}

	public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		List<Eng> engineers1 = new ArrayList<>();
		List<Eng> engineers2 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Eng eng = new Eng(i, speed[i], efficiency[i]);
			engineers1.add(eng);
			engineers2.add(eng);
		}
		Comparator<Eng> bySpeed = (o, p) -> Integer.compare(o.speed, p.speed);
		Comparator<Eng> byEfficiency = (o, p) -> Integer.compare(o.efficiency, p.efficiency);
		engineers1.sort(bySpeed);
		engineers2.sort(byEfficiency);
		Set<Eng> selected = new HashSet<>();
		int added = 0;
		int idx1 = n - 1;
		int idx2 = n - 1;
		System.out.println(engineers1);
		System.out.println(engineers2);

		long speedSum = 0;
		int minEfficiency = Integer.MAX_VALUE;
		long perf = 0;
		long[] perfMatrix = new long[n];

		while (added < k) {
			Arrays.fill(perfMatrix, -1);
			for ( int i = idx1; i > -1; i--) {
				Eng eng1 = engineers1.get(i);
				if (selected.contains(eng1)) {
					continue;
				}
//				System.out.println("analysing "+eng1);
				long curSpeedSum = speedSum + eng1.speed;
				int curEfficiency = Math.min(minEfficiency, eng1.efficiency);
				long curPerf = performance(curSpeedSum, curEfficiency);
//				System.out.println(curSpeedSum);
//				System.out.println(curEfficiency);
//				System.out.println(curPerf);
				perfMatrix[i] = curPerf;
			}
			Utils.print(perfMatrix);
			int minIdx = idx1;
			long maxPerf = 0;
			for ( int i = idx1; i > -1; i--) {
				if (perfMatrix[i] > maxPerf) {
					maxPerf = perfMatrix[i];
					minIdx = i;
				}
			}
			perf = perfMatrix[minIdx];
			speedSum += engineers1.get(minIdx).speed;
			minEfficiency = Math.min(minEfficiency, engineers1.get(minIdx).efficiency);
			selected.add(engineers1.get(minIdx));
			added++;
			idx1 = minIdx;
			if (added >= k) {
				break;
			}
			
			Arrays.fill(perfMatrix, -1);
			for ( int i = idx2; i > -1; i--) {
				Eng eng2 = engineers2.get(i);
				if (selected.contains(eng2)) {
					continue;
				}
				System.out.println("analysing "+eng2);
				long curSpeedSum = speedSum + eng2.speed;
				int curEfficiency = Math.min(minEfficiency, eng2.efficiency);
				long curPerf = performance(curSpeedSum, curEfficiency);
				perfMatrix[i] = curPerf;
			}
			Utils.print(perfMatrix);
			minIdx = idx2;
			maxPerf = 0;
			for ( int i = idx2; i > -1; i--) {
				if (perfMatrix[i] > maxPerf) {
					maxPerf = perfMatrix[i];
					minIdx = i;
				}
			}
			perf = perfMatrix[minIdx];
			speedSum += engineers2.get(minIdx).speed;
			minEfficiency = Math.min(minEfficiency, engineers2.get(minIdx).efficiency);
			selected.add(engineers2.get(minIdx));
			added++;
			idx2 = minIdx;
		
			if (added >= k) {
				break;
			}
			
			
		}
		System.out.println(selected);
		System.out.println(minEfficiency);
		System.out.println(speedSum);

		return (int) Math.floorMod(perf, 1000000007);

	}

	public static void main(String[] arg) {

		int[] speed0 = { 2, 10, 3, 1, 5, 8 };
		int[] efficiency0 = { 5, 4, 3, 9, 7, 2 };

		System.out.println(maxPerformance(6, speed0, efficiency0, 2));// 60

		int[] speed1 = { 2, 10, 3, 1, 5, 8 };
		int[] efficiency1 = { 5, 4, 3, 9, 7, 2 };

		System.out.println(maxPerformance(6, speed1, efficiency1, 3));// 68

		int[] speed2 = { 2, 10, 3, 1, 5, 8 };
		int[] efficiency2 = { 5, 4, 3, 9, 7, 2 };

		System.out.println(maxPerformance(6, speed2, efficiency2, 4));// 72

		int[] speed3 = { 2, 8, 2 };
		int[] efficiency3 = { 2, 7, 1 };

		System.out.println(maxPerformance(3, speed3, efficiency3, 2));// 20

	}

}
