package org.problems.favourite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * K Nearest Post Offices
 * 
 * Find the k post offices located closest to you, given your location and a
 * list of locations of all post offices available. Locations are given in 2D
 * coordinates in [X, Y], where X and Y are integers. Euclidean distance is
 * applied to find the distance between you and a post office. Assume your
 * location is [m, n] and the location of a post office is [p, q], the Euclidean
 * distance between the office and you is R^2 . 
 * k is a positive integer much smaller than the given number of post offices. 
 * 
 * Example
 * Input 
 * inital position: [0, 0] 
 * post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]] 
 * k = 3
 * 
 * Output [[-1, 2], [0, 3], [4, 3]]
 * 
 * 
 */
public class KPostOffices {
	
	static class Location {

		public int[] coords;
		public long dist;
		
		public Location(int[] coords, long dist) {
			this.coords = coords;
			this.dist = dist;
		}
	}
	
	static long sqr(int a) {
		return a * a;
	}
	
	static long dist(int[] coords1, int[] coords2) {
		return sqr(coords1[0] - coords2[0]) + sqr(coords1[1] - coords2[1]);
	}
	
	public static List<List<Integer>> kNearestOffices(int k, int[] pos, int[][] offices){
		List<Location> locs = new ArrayList<>();

		for (int[] office : offices) {
			locs.add(new Location(office, dist(pos, office)));
		}
		Collections.sort(locs, (o,p) -> Long.compare(o.dist, p.dist));
		List<List<Integer>> ret = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ret.add(Arrays.asList(locs.get(i).coords[0], locs.get(i).coords[1]));
		}
		return ret;
	}

	public static void main(String[] arg) {
		int[] pos = {0, 0};
		int[][] offices = {
				{-16, 5}, {-1, 2}, {4, 3}, {10, -2}, {0, 3}, {-5, -9}
		};
		System.out.println(kNearestOffices(3, pos, offices));
	}

}
