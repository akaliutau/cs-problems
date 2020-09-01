package org.problems.favourite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Nearest Houses in the perfect city
 * 
 * The houses are arranged on a group that has been divided up like an ordinary
 * Cartesian plane. Each house is located at an (x,y) coordinate
 * intersection. House names and locations are given in the form of three arrays:
 * c,x, and y, which are aligned by the index to provide the house name (c[i]),
 * and its coordinates, (x[i],y[i]).
 * 
 * Write an algorithm to determine the name of the nearest house that shares an x
 * or a y coordinate with the queried house. If no houses share an x or y
 * coordinate, return none. If two houses have the same distance to the queried
 * house, q[i], consider the one with an alphabetically smaller name (e.e 'ab' <
 * 'aba' < 'abb') as the closest choice.
 * 
 * The distance is denoted on a Euclidean plan: the difference in x plus the
 * difference in y.
 * 
 * Input the input to the function/method consists of six arguments:
 * numOfCities, an integer representing the number of houses; 
 * houses, a list of strings representing the names of each house[i]; 
 * xCoordinates, a list of integers representing the X-coordinates of each house[i]; 
 * yCoordinates, a list of integers representing the Y-coordinates of each house[i]; 
 * numOfQueries, an integer representing the number of queries; 
 * queries, a list of strings representing the names of the queried houses.
 * 
 * Output Return a list of strings representing the name of the nearest house
 * that shares either an x or a y coordinate with the queried house.
 * 
 * Constraints 
 * 1 ≤ numOfCities, numOfQueries ≤ 10^5 
 * 1 ≤ xCoordinates[i], yCoordinates[i] <= 10^9 
 * 1 ≤ length of queries[i] and houses[i] ≤ 10
 */
public class NearestHouses {
	
	static final String NONE ="none";

	static class House {
		int x;
		int y;
		String name;
	}
	
	static int sqr(int i) {
		return i * i;
	}

	static private int dist(House c1, House c2) {
		return sqr(c2.x - c1.x) + sqr(c2.y - c1.y);
	}

	static public List<String> getNearestCities(int numOfCities, List<String> houses, List<Integer> xCoordinates,
			List<Integer> yCoordinates, int numOfQueries, List<String> queries) {
		Map<String, House> houseMap = new HashMap<>();
		Map<Integer, Set<String>> xMap = new HashMap<>();
		Map<Integer, Set<String>> yMap = new HashMap<>();

		for (int i = 0; i < numOfCities; i++) {
			House house = new House();
			house.name = houses.get(i);
			house.x = xCoordinates.get(i);
			house.y = yCoordinates.get(i);

			houseMap.put(house.name, house);

			Set<String> xMapCities = xMap.getOrDefault(house.x, new HashSet<>());
			xMapCities.add(house.name);
			xMap.put(house.x, xMapCities);

			Set<String> yMapCities = yMap.getOrDefault(house.y, new HashSet<>());
			yMapCities.add(house.name);
			yMap.put(house.y, yMapCities);
		}

		List<String> result = new LinkedList<>();
		for (String query : queries) {
			House house = houseMap.get(query);

			Set<String> set = new HashSet<>();
			set.addAll(xMap.get(house.x));
			set.addAll(yMap.get(house.y));

			int minDist = Integer.MAX_VALUE;
			String str = "";
			for (String houseName : set) {
				House c = houseMap.get(houseName);
				int dist = dist(house, c);
				if (!houseName.equals(query) && dist <= minDist) {
					if (dist < minDist) {
						str = c.name;
					} else if (str.compareTo(c.name) < 0) {
						str = c.name;
					}
					minDist = dist;
				}
			}

			if (str.length() > 0) {
				result.add(str);
			} else {
				result.add(NONE);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int numOfCities = 3;
		String[] houses = { "c1", "c2", "c3" };
		Integer[] xCoordinates = { 3, 2, 1 };
		Integer[] yCoordinates = { 3, 2, 3 };
		int numOfQueries = 3;
		String[] queries = { "c1", "c2", "c3" };
		List<String> result = getNearestCities(numOfCities, Arrays.asList(houses), Arrays.asList(xCoordinates),
				Arrays.asList(yCoordinates), numOfQueries, Arrays.asList(queries));
		for (String str : result) {
			System.out.println(str);
		}
	}

}
