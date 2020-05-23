package org.problems.topology;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/escape-a-large-maze/
 * 
 * In a 1 million by 1 million grid, 
 * the coordinates of each grid square are (x, y)
 * 
 * We start at the source square and want to reach the target square. Each move,
 * we can walk to a 4-directionally adjacent square in the grid that isn't in
 * the given list of blocked squares.
 * 
 * Return true if and only if it is possible to reach the target square through
 * a sequence of moves.
 * 
 * Example 1:
 * 
 * Input: blocked = [[0,1},{1,0]], source = [0,0], target = [0,2] Output: false
 * Explanation: The target square is inaccessible starting from the source
 * square, because we can't walk outside the grid. 
 * 
 * Example 2:
 * 
 * Input: blocked = [], source = [0,0], target = [999999,999999] Output: true
 * Explanation: Because there are no blocked cells, it's possible to reach the
 * target square.
 * 
 * 
 * Note:
 * 
 * 0 <= blocked.length <= 200 
 * blocked[i].length == 2 
 * 0 <= blocked[i][j] < 10^6
 * source.length == target.length == 2 
 * 0 <= source[i][j], target[i][j] < 10^6
 * source != target
 * 
 * Runtime: 13 ms, faster than 91.85% of Java online submissions for Escape a Large Maze.
 * Memory Usage: 40.4 MB, less than 80.00% of Java online submissions for Escape a Large Maze
 * 
 */
public class EscapeMaze {
	
	static class Cell {
		public int absX;
		public int absY;
		public int x;
		public int y;
		public boolean visited;
		public boolean obstacle;
		public boolean processed;
		public boolean boundary;
		
		public Cell(int x, int y) {
			this.absX = x;
			this.absY = y;
		}
		
		public boolean isConnected(Cell cell) {
			return Math.abs(cell.absX - absX) <= 1 && Math.abs(cell.absY - absY) <= 1;
		}

		@Override
		public String toString() {
			return "Cell [absX=" + absX + ", absY=" + absY + ", x=" + x + ", y=" + y + ", visited=" + visited
					+ ", obstacle=" + obstacle + ", processed=" + processed + ", boundary=" + boundary + "]";
		}

		
	}
	
	/**
	 * 	Basket for connected cells
	 */
	static class Area {
		public int minX = Integer.MAX_VALUE;
		public int maxX = 0;
		public int minY = Integer.MAX_VALUE;
		public int maxY = 0;
		public int rangeX = 0;
		public int rangeY = 0;
		public boolean hasLeak = false;
		
		public Cell[][] field;
		
		public List<Cell> connected = new ArrayList<>();
		
		public void createField() {
			rangeX = maxX - minX + 1;
			rangeY = maxY - minY + 1;

			field = new Cell[rangeX][rangeY];
			for (Cell c : connected) {
				c.x = c.absX - minX;
				c.y = c.absY - minY;
				field[c.x][c.y] = c;
			}
			for (int i = 0; i < rangeX; i++) {
				for (int j = 0; j < rangeY; j++) {
					if (field[i][j] == null) {
						field[i][j] = new Cell(i+minX,j+minY);
						field[i][j].x = i;
						field[i][j].y = j;
						isBoundary(field[i][j]);
					}
				}
			}
			
		}
		
		public boolean isBoundary(Cell c) {
			if (c.absX == 0 || c.absX == 999999 || c.absY == 0 || c.absY == 999999) {
				if (!c.obstacle) {
					c.boundary = true;
				}
			}
			return c.boundary;
		}
		
		public boolean inArea(Cell cell) {
			return cell.absX >= minX && cell.absY >= minY && cell.absX <= maxX && cell.absY <= maxY;
		}
		
		public void put(Cell c) {
			c.x = c.absX - minX;
			c.y = c.absY - minY;
			field[c.x][c.y] = c;
			
		}		
		
		public void add(Cell cell) {
			minX = Math.min(minX, cell.absX);
			minY = Math.min(minY, cell.absY);
			maxX = Math.max(maxX, cell.absX);
			maxY = Math.max(maxY, cell.absY);
			cell.x = cell.absX - minX;
			cell.y = cell.absY - minY;

			cell.visited = true;
			cell.obstacle = true;
			connected.add(cell);
		}
		
		public boolean isConnected(Cell cell) {
			for (Cell c : connected) {
				if (c.isConnected(cell)) {
					return true;
				}
			}
			return false;
		}
		
		public static int[] shifts = {-1,0, 1,0, 0,-1, 0,1};
		
		public void fillFrom(Cell c) {
			c.visited = true;
			Queue<Cell> queue = new LinkedList<>();
			queue.add(c);
			while (!queue.isEmpty()) {
				Cell cur = queue.poll();
				cur.visited = true;
//				System.out.println("visiting:"+cur);
				for (int i = 0; i < 8; i+=2) {
					int nextX = cur.x + shifts[i];
					int nextY = cur.y + shifts[i+1];
//					System.out.println("check:"+nextX+","+nextY);
					if (isValid(nextX,nextY)) {
						Cell next = field[nextX][nextY];
//						System.out.println(next);
						if (!next.visited && !next.obstacle) {
							next.visited = true;
							queue.add(next);
//							System.out.println(next);
						}
					}
				}
			}
			
		}
		
		private boolean isValid(int x, int y) {
			boolean inside =  x >= 0 && x < rangeX && y >= 0 && y < rangeY;
			if (!inside && hasConnectionOutsideArea(x,y)) {
//				System.out.println("hasConnectionOutsideArea:"+x+","+y);

				hasLeak = true;
			}
			return inside;
		}
		
		private boolean hasConnectionOutsideArea(int x, int y) {
			return x + minX >= 0 && x + minX <= 999999 && y + minY >= 0 && y + minY <= 999999;
		}

		@Override
		public String toString() {
			return "Area [minX=" + minX + ", maxX=" + maxX + ", minY=" + minY + ", maxY=" + maxY + ", rangeX=" + rangeX
					+ ", rangeY=" + rangeY + ", hasLeak=" + hasLeak + ", connected=" + connected + "]";
		}

		
	}
	
	private static void process(Cell c, List<Area> areas, List<Cell> cells) {
		c.processed = true;
		for (Area a : areas) {
			if (a.isConnected(c)) {
				a.add(c);
				return;
			}
		}
		Area newArea = new Area();
		newArea.add(c);
		for (Cell cell : cells) {
			if (!cell.processed && newArea.isConnected(cell)) {
				newArea.add(cell);
				c.processed = true;
			}
		}
		areas.add(newArea);
	}

	public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
		
		List<Area> areas = new ArrayList<>();
		List<Cell> cells = new ArrayList<>();
		for (int[] c : blocked) {
			cells.add(new Cell(c[0],c[1]));
		}
		for (Cell cell : cells) {
			process(cell, areas, cells);
		}
		

//		System.out.println("areas before:"+areas);
		
		// check availability
		Area sourceArea = null;
		Cell sourceCell = new Cell(source[0],source[1]);
		process(sourceCell, areas, cells);
		Cell targetCell = new Cell(target[0],target[1]);
		process(targetCell, areas, cells);
		for (Area a : areas) {
			a.createField();
			if (a.inArea(sourceCell)) {
				sourceArea = a;
				sourceArea.put(sourceCell);
				break;
			}
		}		

		Area targetArea = null;
		for (Area a : areas) {
			if (a.inArea(targetCell)) {
				targetArea = a;
//				targetArea.put(targetCell);
				break;
			}
		}
		sourceCell.visited = false;
		sourceCell.obstacle = false;
		targetCell.visited = false;
		targetCell.obstacle = false;
		if (sourceArea == targetArea) {// source and target inside the same area
//			System.out.println("areas are the same, targetCell.visited="+targetCell);
//			sourceArea.add(targetCell);
//		    targetCell.visited = false;
//		    targetCell.obstacle = false;
			
			sourceArea.fillFrom(sourceCell);
//			System.out.println("areas are the same, result of visited="+targetCell);
//			return sourceCell.visited && sourceArea.field[targetCell.x][targetCell.y].visited;
			return sourceCell.visited && targetCell.visited;
		}

		sourceArea.fillFrom(sourceCell);
		targetArea.fillFrom(targetCell);
//		System.out.println("areas after:"+areas);

		
		return sourceArea.hasLeak && targetArea.hasLeak;

	}

	public static void main(String[] arg) {
		
		int[][] blocked = {
				{1,0},
				{0,1}
		};
		
		int[] source = {0,0};
		int[] target = {23,12};

		System.out.println(isEscapePossible(blocked, source, target));
		
		int[][] blocked0 = {
				{1,0},
				{0,1}
		};
		
		int[] source0 = {0,0};
		int[] target0 = {1,1};

		System.out.println(isEscapePossible(blocked0, source0, target0));

		
		int[][] blocked1 = {
				{0,3},
				{1,3},
				{2,2},
				{3,1},
				{5,0}
		};
		
		int[] source1 = {1,1};
		int[] target1 = {99999,12};

		System.out.println(isEscapePossible(blocked1, source1, target1));

		int[][] blocked2 = {
				{0,3},
				{1,3},
				{2,2},
				{3,1},
				{4,0}
		};
		
		int[] source2 = {1,1};
		int[] target2 = {3,0};

		System.out.println(isEscapePossible(blocked2, source2, target2));
		
		int[][] blocked3 = {
				{100059,100063},{100060,100064},{100061,100065},{100062,100066},{100063,100067},{100064,100068},{100065,100069},{100066,100070},
				{100067,100071},{100068,100072},{100069,100073},{100070,100074},{100071,100075},{100072,100076},{100073,100077},{100074,100078},
				{100075,100079},{100076,100080},{100077,100081},{100078,100082},{100079,100083},{100080,100082},{100081,100081},{100082,100080},
				{100083,100079},{100084,100078},{100085,100077},{100086,100076},{100087,100075},{100088,100074},{100089,100073},{100090,100072},
				{100091,100071},{100092,100070},{100093,100069},{100094,100068},{100095,100067},{100096,100066},{100097,100065},{100098,100064},
				{100099,100063},{100098,100062},{100097,100061},{100096,100060},{100095,100059},{100094,100058},{100093,100057},{100092,100056},
				{100091,100055},{100090,100054},{100089,100053},{100088,100052},{100087,100051},{100086,100050},{100085,100049},{100084,100048},
				{100083,100047},{100082,100046},{100081,100045},{100080,100044},{100079,100043},{100078,100044},{100077,100045},{100076,100046},
				{100075,100047},{100074,100048},{100073,100049},{100072,100050},{100071,100051},{100070,100052},{100069,100053},{100068,100054},
				{100067,100055},{100066,100056},{100065,100057},{100064,100058},{100063,100059},{100062,100060},{100061,100061},{100060,100062}
				};

		int[] source3 = {100079,100063};
		int[] target3 = {999948,999967};

		System.out.println(isEscapePossible(blocked3, source3, target3));
		
		int[][] blocked4 = {};
		
		int[] source4 = {0,0};
		int[] target4 = {23,12};
		System.out.println(isEscapePossible(blocked4, source4, target4));

		int[][] blocked5 = {
				{0,3},
				{1,0},
				{1,1},
				{1,2},
				{1,3}
		};
		
		int[] source5 = {0,0};
		int[] target5 = {0,2};

		System.out.println(isEscapePossible(blocked5, source5, target5));
	}

}
