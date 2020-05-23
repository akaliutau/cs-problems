package org.problems.sudoku;

/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition. Each column must
 * contain the digits 1-9 without repetition. Each of the 9 3x3 sub-boxes of the
 * grid must contain the digits 1-9 without repetition.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 */
public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
		// check rows
		boolean[][] rowMap = new boolean[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int col = (int) board[i][j] - 49;
					if (rowMap[i][col]) {
						return false;
					}
					rowMap[i][col] = true;
				}
			}
		}

		// check columns
		boolean[][] colMap = new boolean[9][9];
		for (int i = 0; i < 9; i++) {// column
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					int row = (int) board[j][i] - 49;
					if (colMap[row][i]) {
						return false;
					}
					colMap[row][i] = true;
				}
			}
		}

		boolean[][] boxMap = new boolean[9][9];
		// check sub-bocies
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int col = (int) board[i][j] - 49;
					int box = 3 * (i / 3 - 1) + (j / 3 - 1) + 4;
					if (boxMap[box][col]) {
						return false;
					}
					boxMap[box][col] = true;
				}
			}
		}

		return true;

	}

	public static void main(String[] arg) {

		char[][] arr = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		char[][] arr1 = { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		char c = '1';
		System.out.println(isValidSudoku(arr));
		System.out.println(isValidSudoku(arr1));

	}

}
