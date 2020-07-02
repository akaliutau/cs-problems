package org.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/parallel-courses-ii/
 * 
 * Given the integer n representing the number of courses at some university
 * labeled from 1 to n, and the array dependencies where dependencies[i] = [xi,
 * yi] represents a prerequisite relationship, that is, the course xi must be
 * taken before the course yi. Also, you are given the integer k.
 * 
 * In one semester you can take at most k courses as long as you have taken all
 * the prerequisites for the courses you are taking.
 * 
 * Return the minimum number of semesters to take all courses. It is guaranteed
 * that you can take all courses in some way.
 * 
 * Input: n = 4, dependencies = [[2,1],[3,1],[1,4]], k = 2 Output: 3
 * Explanation: The figure above represents the given graph. In this case we can
 * take courses 2 and 3 in the first semester, then take course 1 in the second
 * semester and finally take course 4 in the third semester.
 * 
 */
public class ParallelCoursesII {

	static class Course {
		public int id;
		public List<Course> dep = new ArrayList<>();
		public boolean done;

		public Course(int id) {
			this.id = id;
		}

		public boolean canDo() {
			for (Course c : dep) {
				if (!c.done) {
					return false;
				}
			}
			return true;
		}

		public int activeDep() {
			int t = 0;
			for (Course c : dep) {
				if (!c.done) {
					t++;
				}
			}
			return t;
		}

		@Override
		public String toString() {
			return "Course [id=" + id + "]";
		}
	}

	public int minNumberOfSemesters(int n, int[][] dependencies, int k, Comparator<Course> byDep) {
		int levels = 0;
		Course[] courses = new Course[n];
		for (int i = 0; i < n; i++) {
			courses[i] = new Course(i);
		}
		for (int[] dep : dependencies) {
			courses[dep[1] - 1].dep.add(courses[dep[0] - 1]);
		}
		int complete = 0;
		while (complete < n) {
			int limit = k;
			List<Course> thisSem = new ArrayList<>();
			Arrays.sort(courses, byDep);

			for (Course c : courses) {
				if (!c.done && c.canDo()) {
					if (limit > 0) {
						thisSem.add(c);
						limit--;
						complete++;
					}
				}
				if (limit == 0) {
					break;
				}
			}

			for (Course c : thisSem) {
				c.done = true;
			}
			if (!thisSem.isEmpty())
				levels++;
		}

		return levels;
	}

	public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
		int min1 = minNumberOfSemesters(n, dependencies, k, (o, p) -> Integer.compare(o.activeDep(), p.activeDep()));
		int min2 = minNumberOfSemesters(n, dependencies, k, (o, p) -> Integer.compare(p.activeDep(), o.activeDep()));
		return Math.min(min1, min2);
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
