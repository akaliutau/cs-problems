package org.problems.matricies;

import java.util.LinkedList;
import java.util.Queue;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/flood-fill/
 *
 * An image is represented by a 2-D array of integers, each integer representing
 * the pixel value of the image (from 0 to 65535).
 * 
 * Given a coordinate (sr, sc) representing the starting pixel (row and column)
 * of the flood fill, and a pixel value newColor, "flood fill" the image.
 * 
 * To perform a "flood fill", consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color as the starting pixel), and so on. Replace the
 * color of all of the aforementioned pixels with the newColor.
 * 
 * At the end, return the modified image.
 * 
 * Example 1: Input: image = [ [1,1,1], [1,1,0], [1,0,1] ]
 * 
 * sr = 1, sc = 1, newColor = 2 Output: [ [2,2,2], [2,2,0], [2,0,1] ]
 * 
 * Explanation: From the center of the image (with position (sr, sc) = (1, 1)),
 * all pixels connected by a path of the same color as the starting pixel are
 * colored with the new color. Note the bottom corner is not colored 2, because
 * it is not 4-directionally connected to the starting pixel.
 * 
 * Note:
 * 
 * The length of image and image[0] will be in the range [1, 50]. The given
 * starting pixel will satisfy
 * 
 * 0 <= sr < image.length and 0 <= sc < image[0].length.
 * 
 * The value of each color in image[i][j] and newColor will be an integer in [0,
 * 65535].
 */
public class FloodFill {

	static boolean isValid(int[][] image, int i, int j, int n, int m, int color, boolean[][] bmap) {
		return i >= 0 && i < n && j >= 0 && j < m && image[i][j] == color && !bmap[i][j];
	}

	static void updatePixel(int i, int j, int[][] image, boolean[][] visited, int fillColor, Queue<Integer> queue) {
		visited[i][j] = true;
		image[i][j] = fillColor;
		queue.add(i);
		queue.add(j);
	}

	static void add(int[][] image, int i, int j, int n, int m, int color, int fillColor, boolean[][] visited,
			Queue<Integer> queue) {
		if (isValid(image, i + 1, j, n, m, color, visited)) {
			updatePixel(i + 1, j, image, visited, fillColor, queue);
		}
		if (isValid(image, i - 1, j, n, m, color, visited)) {
			updatePixel(i - 1, j, image, visited, fillColor, queue);
		}
		if (isValid(image, i, j + 1, n, m, color, visited)) {
			updatePixel(i, j + 1, image, visited, fillColor, queue);
		}
		if (isValid(image, i, j - 1, n, m, color, visited)) {
			updatePixel(i, j - 1, image, visited, fillColor, queue);
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int rows = image.length;
		int cols = 0;
		if (rows > 0) {
			cols = image[0].length;
		}

		boolean[][] visited = new boolean[rows][cols];
		int pickColor = image[sr][sc];
		Queue<Integer> queue = new LinkedList<>();
		updatePixel(sr, sc, image, visited, newColor, queue);
		while (!queue.isEmpty()) {
			int r = queue.poll();
			int c = queue.poll();
			add(image, r, c, rows, cols, pickColor, newColor, visited, queue);
		}
		
		return image;

	}

	public static void main(String[] arg) {
		
		int[][] img0 = {
				{1,1,1},
				{1,1,0},
				{1,0,1}
		};

		floodFill(img0,1,1,2);
		Utils.print(img0);

		int[][] img1 = {
				{1}
		};

		floodFill(img1,0,0,2);
		Utils.print(img1);

	}
}
