package org.problems.datastructures;

/**
 * https://leetcode.com/problems/subrectangle-queries/
 * 
 * Implement the class SubrectangleQueries which receives a rows x cols
 * rectangle as a matrix of integers in the constructor and supports two
 * methods:
 * 
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 * 
 * Updates all values with newValue in the subrectangle whose upper left
 * coordinate is (row1,col1) and bottom right coordinate is (row2,col2). 2.
 * getValue(int row, int col)
 * 
 * Returns the current value of the coordinate (row,col) from the rectangle.
 * 
 * 
 * 
 */
public class SubrectangleQueriesImpl {

	static class SubrectangleQueries {
		private int rows;
		private int cols;
		private int[][] rectangle;

		public SubrectangleQueries(int[][] rectangle) {
			rows = rectangle.length;
			cols = 0;
			if (rows > 0) {
				cols = rectangle[0].length;
			}
			this.rectangle = rectangle;
		}

		public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
			for (int i = row1; i <= row2; i++) {
				for (int j = col1; j <= col2; j++) {
					rectangle[i][j] = newValue;
				}

			}

		}

		public int getValue(int row, int col) {
			return rectangle[row][col];

		}
	}

	public static void main(String[] arg) {
		int[][] rectangle = { { 1, 2, 1 }, { 4, 3, 4 }, { 3, 2, 1 }, { 1, 1, 1 } };
		SubrectangleQueries sq = new SubrectangleQueries(rectangle);

		System.out.println(sq.getValue(0, 2));
		sq.updateSubrectangle(0, 0, 3, 2, 5);

		System.out.println(sq.getValue(0, 2));
		System.out.println(sq.getValue(3, 1));
		sq.updateSubrectangle(3, 0, 3, 2, 10);

		System.out.println(sq.getValue(0, 2));
		System.out.println(sq.getValue(3, 1));

		int[][] rectangle1 = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
		SubrectangleQueries subrectangleQueries = new SubrectangleQueries(rectangle1);
		System.out.println(subrectangleQueries.getValue(0, 0)); // return 1
		subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
		System.out.println(subrectangleQueries.getValue(0, 0)); // return 100
		System.out.println(subrectangleQueries.getValue(2, 2)); // return 100
		subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
		System.out.println(subrectangleQueries.getValue(2, 2)); // return 20

	}

}
