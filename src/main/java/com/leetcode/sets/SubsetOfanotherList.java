package com.leetcode.sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
 * 
 * 
 * Given the array favoriteCompanies where favoriteCompanies[i] is the list of
 * favorites companies for the ith person (indexed from 0).
 *
 * Return the indices of people whose list of favorite companies is not a subset
 * of any other list of favorites companies. You must return the indices in
 * increasing order.
 * 
 * Input: favoriteCompanies =
 * [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * Output: [0,1,4]
 * 
 * Explanation: Person with index=2 has
 * favoriteCompanies[2]=["google","facebook"] which is a subset of
 * favoriteCompanies[0]=["leetcode","google","facebook"] corresponding to the
 * person with index 0. Person with index=3 has favoriteCompanies[3]=["google"]
 * which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"]
 * and favoriteCompanies[1]=["google","microsoft"]. Other lists of favorite
 * companies are not a subset of another list, therefore, the answer is [0,1,4].
 */
public class SubsetOfanotherList {

	static class Person {
		public Set<String> companies = new HashSet<>();

		public Person(List<String> companies) {
			this.companies = new HashSet<>(companies);
		}
	}

	public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
		int n = favoriteCompanies.size();
		Person[] persons = new Person[n];
		for (int i = 0; i < n; i++) {
			persons[i] = new Person(favoriteCompanies.get(i));
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int size = persons[i].companies.size();
			boolean inclusion = false;
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (persons[j].companies.size() < size) {// smaller set - not interested
					continue;
				}
				// for each company for i check inclusion
				if (persons[j].companies.containsAll(persons[i].companies)) {
					inclusion = true;
					break;
				}
			}
			if (!inclusion) {
				res.add(i);
			}
		}
		return res;

	}

	public static void main(String[] arg) {

		List<List<String>> favoriteCompanies = Arrays.asList(Arrays.asList("leetcode", "google", "facebook"),
				Arrays.asList("google", "microsoft"), Arrays.asList("google", "facebook"), Arrays.asList("google"),
				Arrays.asList("amazon"));

		System.out.println(peopleIndexes(favoriteCompanies));

		List<List<String>> favoriteCompanies1 = Arrays.asList(Arrays.asList("leetcode", "google", "facebook"),
				Arrays.asList("leetcode","amazon"), Arrays.asList("google", "facebook"));

		System.out.println(peopleIndexes(favoriteCompanies1));

		List<List<String>> favoriteCompanies2 = Arrays.asList(Arrays.asList("leetcode"),Arrays.asList("amazon"),
				Arrays.asList("google"), Arrays.asList( "facebook"));

		System.out.println(peopleIndexes(favoriteCompanies2));

	}

}
