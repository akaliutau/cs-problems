package org.problems.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/sudoku-solver/
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * Each of the digits 1-9 must occur exactly once in each row. Each of the
 * digits 1-9 must occur exactly once in each column. Each of the the digits 1-9
 * must occur exactly once in each of the 9 3x3 sub-boxes of the grid. Empty
 * cells are indicated by the character '.'.
 * 
 * Note:
 * 
 * The given board contains only digits 1-9 and the character '.'. You may
 * assume that the given Sudoku puzzle will have a single unique solution. The
 * given board size is always 9x9.
 * 
 * Total brute-force complexity (9!)^9 ~ 10^15
 * 
 * solution:
 * 
 * maximum use constraints
 * 
 * 1) build a table of candidates for row and cols and bocies
 * 
 * 2) sort entries by number of possibilities
 * 
 * 
 * Runtime: 20 ms, faster than 17.07% of Java online submissions for Sudoku Solver.
 * Memory Usage: 41.7 MB, less than 5.26% of Java online submissions for Sudoku Solver.
 */
public class SudokuSolver {

	static char[] charMap = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	static class Cell implements Comparable<Cell> {
		public int i;
		public int j;
		public int[] possibilities;

		public Cell(int i, int j, int[] possibilities) {
			this.possibilities = possibilities;
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Cell cell) {
			return Integer.compare(this.possibilities.length, cell.possibilities.length);
		}

		@Override
		public String toString() {
			return "["+i+","+j+"]="+Arrays.stream(possibilities).boxed().collect(Collectors.toList()).toString();
		}

	}

	static int[] getPossibilities(int[] rows, int[] cols, int[] square) {
		List<Integer> lst = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			if (rows[i] == 1 && cols[i] == 1 && square[i] == 1) {
				lst.add(i);
			}
		}
		int[] res = new int[lst.size()];
		int idx = 0;
		for (Integer i : lst) {
			res[idx++] = i+1;
		}
		return res;
	}

	static List<Cell> getTable(int[][] solution) {
		int[][][] square = new int[3][3][9];
		int[][] cols = new int[9][9];
		int[][] rows = new int[9][9];
		for (int r = 0; r < 9; r++) {
			for (int i = 0; i < 9; i++) {
				int val = solution[r][i] - 1;
				if (val != -1) {
					rows[r][val] = 1;
				}
			}
			for (int i = 0; i < 9; i++) {
				rows[r][i] ^= 1;
			}
		}
		for (int c = 0; c < 9; c++) {
			for (int i = 0; i < 9; i++) {
				int val = solution[i][c] - 1;
				if (val != -1) {
					cols[c][val] = 1;
				}
			}
			for (int i = 0; i < 9; i++) {
				cols[c][i] ^= 1;
			}
		}
		// square (i,j)
		// (0,0), (0,1), (0,2)
		// (1,0), (1,1), (1,2)
		// (2,0), (2,1), (2,2)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// inner square
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						int val = solution[i * 3 + r][j * 3 + c] - 1;
						if (val != -1) {
							square[i][j][val] = 1;
						}
					}
				}
				for (int l = 0; l < 9; l++) {
					square[i][j][l] ^= 1;
				}
			}
		}

		List<Cell> cells = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (solution[i][j] != 0) {
					continue;
				}
				int[] variants = getPossibilities(rows[i], cols[j], square[i / 3][j / 3]);
				if (variants.length == 1) {
					cells.add(new Cell(i, j, variants));
				} else if (variants.length > 1) {
					cells.add(new Cell(i, j, variants));
				}
			}
		}

		return cells;
	}

	static int cellsSolved(int[][] solution) {
		int counter = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (solution[i][j] != 0) {
					counter++;
				}
			}
		}
		return counter;
	}

	static void add(int[][] solution, List<Integer> result) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				result.add(solution[i][j]);
			}
		}
	}

	static boolean solve(int[][] solution, int it, List<Integer> result) {
		if (it > 500) {
			return false;
		}
		List<Cell> update = getTable(solution);
		if (update.isEmpty() && cellsSolved(solution) == 81) {
			add(solution, result);
			return true;
		}
		Collections.sort(update);
		if (update.size() == 0) {
			return false;
		}
		Cell toUpdate = update.get(0);
		if (toUpdate.possibilities.length == 0) {
			return false;
		}
		for (int i : toUpdate.possibilities) {
			int[][] copy = copyArray(solution);
			copy[toUpdate.i][toUpdate.j] = i;
			if (solve(copy, it + 1, result)) {
				return true;
			}
		}
		return false;
	}
	
	public static int[][] copyArray(int[][] copy){
		int[][] solution = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				solution[i][j] = copy[i][j];
			}
		}
		return solution;
	}
	

	public static void solveSudoku(char[][] board) {
		int[][] solution = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c != '.') {
					solution[i][j] = c - '0';
				}
			}
		}
		List<Integer> result = new ArrayList<>();
		if (solve(solution, 0, result)) {
			int counter = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					board[i][j] = charMap[result.get(counter++)];
				}
			}
			Utils.print(board);
			return;
		}
		Utils.print(board);
		System.out.print("cannot solve sudoku!");

	}

	public static void main(String[] arg) {

		char[][] mat = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },

				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },

				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' }, 
				};
		solveSudoku(mat);
		
		char[][] mat1 = {
				{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}
				};
		solveSudoku(mat1);

	}

}
