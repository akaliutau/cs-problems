package org.problems.topology;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/contest/weekly-contest-187/problems/destination-city/
 * 
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there
 * exists a direct path going from cityAi to cityBi. Return the destination
 * city, that is, the city without any path outgoing to another city.
 * 
 * It is guaranteed that the graph of paths forms a line without any loop,
 * therefore, there will be exactly one destination city
 * 
 * 
 */
public class DestinationCity {

	public static String destCity(List<List<String>> paths) {
		Set<String> cities = new HashSet<>();
		for (List<String> pair : paths) {
			cities.add(pair.get(0));
			cities.add(pair.get(1));
		}
		for (List<String> pair : paths) {
			if (cities.contains(pair.get(0)))
				cities.remove(pair.get(0));
		}
		for (String city : cities) {
			return city;
		}

		return null;

	}

	public static void main(String[] arg) {

		List<List<String>> paths = Arrays.asList(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"),
				Arrays.asList("Lima", "Sao Paulo"));
		System.out.println(destCity(paths));

		List<List<String>> paths1 = Arrays.asList(Arrays.asList("B", "C"), Arrays.asList("D", "B"),
				Arrays.asList("C", "A"));
		System.out.println(destCity(paths1));

	}

}
