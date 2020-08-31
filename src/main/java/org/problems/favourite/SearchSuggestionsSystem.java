package org.problems.favourite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Search Suggestions System
 * 
 * Given an array of strings products and a string searchWord. We want to design
 * a system that suggests at most three product names from products after each
 * character of searchWord is typed. Suggested products should have common
 * prefix with the searchWord. If there are more than three products with a
 * common prefix return the three lexicographically minimums products.
 * 
 * Return list of lists of the suggested products after each character of
 * searchWord is typed
 * 
 * 
 */
public class SearchSuggestionsSystem {

	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> res = new ArrayList<>();
		int n = products.length;
		int len = searchWord.length();
		String word = searchWord.substring(0, 1);
		List<String> found = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			found.add(products[i]);
		}
		Collections.sort(found);
		for (int i = 0; i < len; i++) {
			word = searchWord.substring(0, i + 1);
			List<String> subList = new ArrayList<>();
			for (String foundWord : found) {
				if (foundWord.startsWith(word)) {
					subList.add(foundWord);
				}
			}
			if (subList.isEmpty()) {
				res.add(subList);
				continue;
			}
			int counter = Math.min(3, subList.size());
			res.add(subList.subList(0, counter));
			found = subList;
		}

		return res;

	}

	public static void main(String[] arg) {
		
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};

		System.out.println(suggestedProducts(products, "mouse"));

	}

}
