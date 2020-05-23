package org.problems.matricies;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 *
 * Given an 2D board, count how many battleships are in it. The battleships are
 * represented with 'X's, empty slots are represented with '.'s. You may assume
 * the following rules: You receive a valid board, made of only battleships or
 * empty slots. Battleships can only be placed horizontally or vertically. In
 * other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1
 * (N rows, 1 column), where N can be of any size. At least one horizontal or
 * vertical cell separates between two battleships - there are no adjacent
 * battleships.
 * 
 * Example:
 * 
 * X..X
 * ...X
 * ...X
 * 
 * output: 2
 * 
 */
public class BattleshipsInaBoard {
	
	static int getValue(int[][] ships, int i, int j, int n, int m) {
		if (i >=0 && i < m && j >=0 && j < n) {
			return ships[i][j];
		}
		return 0;
	}
	
	static int updateMap(char[][] board, int[][] ships, int i, int j, int counter, int n, int m) {
		if (board[i][j] != 'X') {
			return counter;
		}
		int m1 = getValue(ships,i-1,j,n,m);
		int m2 = getValue(ships,i+1,j,n,m);
		int m3 = getValue(ships,i,j-1,n,m);
		int m4 = getValue(ships,i,j+1,n,m);
		int neighbour = Math.max(m1, Math.max(m2, Math.max(m3, Math.max(0, m4))));
		if (neighbour == 0) {
			ships[i][j] = ++counter;
		}else {
			ships[i][j] = counter;
		}
		return counter;
		
	}

	public static int countBattleships(char[][] board) {
		int counter = 0;
		int m = board.length;
		int n = 0;
		if (m > 0) {
			n = board[0].length;
		}
		int[][] ships = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				counter = updateMap(board,ships,i,j,counter,n,m);
			}
		}
		
		return counter;

	}

	public static void main(String[] arg) {

		char[][] arr = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
		System.out.println(countBattleships(arr));

		char[][] arr1 = {{'X','.','.','.'},{'.','.','.','X'},{'.','.','.','X'}};
		System.out.println(countBattleships(arr1));

	
		char[][] arr2 = {{'X','X','X','.'},{'.','.','.','X'},{'.','.','.','X'}};
		System.out.println(countBattleships(arr2));

		char[][] arr3 = {{'X','.','.','.'},{'.','.','.','.'},{'.','.','.','.'}};
		System.out.println(countBattleships(arr3));
}

}
