package org.problems.minmax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/brick-wall/
 * 
 * There is a brick wall in front of you. The wall is rectangular and has
 * several rows of bricks. The bricks have the same height but different width.
 * You want to draw a vertical line from the top to the bottom and cross the
 * least bricks.
 * 
 * The brick wall is represented by a list of rows. Each row is a list of
 * integers representing the width of each brick in this row from left to right.
 * 
 * If your line go through the edge of a brick, then the brick is not considered
 * as crossed. You need to find out how to draw the line to cross the least
 * bricks and return the number of crossed bricks.
 * 
 * You cannot draw a line just along one of the two vertical edges of the wall,
 * in which case the line will obviously cross no bricks.
 * 
 * 
 * 
 * Example:
 * 
 * Input: 
 * [
 * [1,2,2,1], 
 * [3,1,2], 
 * [1,3,2], 
 * [2,4], 
 * [3,1,2], 
 * [1,3,1,1]]
 * 
 * Output: 2
 * 
 * 
 */
public class BrickWall {

	public static int leastBricks(List<List<Integer>> wall) {
		int lines = wall.size();
		
		Set<Integer> allVLines = new HashSet<>();
		Set<Integer>[] partialSums = new Set[lines];
		
		int idx = 0;
		for (List<Integer> line : wall) {
			Set<Integer> vLines = new HashSet<>();
			int sum = 0;
			for (int i = 0; i < line.size()-1; i++) {
				sum += line.get(i);
				vLines.add(sum);
			}
			partialSums[idx++] = vLines;
			allVLines.addAll(vLines);
		}
		
		System.out.println(allVLines);
		int maxCounter = 0;
		for (Integer brick : allVLines) {
			int counter = 0;
			for (int l = 0; l < lines; l++) {
				if (partialSums[l].contains(brick)) {
					counter ++;
				}
			}
			maxCounter = maxCounter < counter ? counter : maxCounter;
		}
		
		return lines-maxCounter;

	}

	public static void main(String[] arg) {

		int[][] bricks = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
		List<List<Integer>> wall = new ArrayList<>();
		for (int[] line : bricks) {
			wall.add(Arrays.stream(line).boxed().collect(Collectors.toList()));
		}
		System.out.println(leastBricks(wall));

	}

}
