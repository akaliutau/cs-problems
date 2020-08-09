package org.problems.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple"); 
 * trie.search("apple"); // returns true
 * trie.search("app"); // returns false 
 * trie.startsWith("app"); // returns true
 * trie.insert("app"); 
 * trie.search("app"); // returns true 
 * 
 * Note:
 * 
 * You may assume that all inputs are consist of lowercase letters a-z. All
 * inputs are guaranteed to be non-empty strings.
 * 
 * Runtime: 43 ms, faster than 55.59% of Java online submissions for Implement Trie (Prefix Tree).
 * Memory Usage: 50.9 MB, less than 58.29% of Java online submissions for Implement Trie (Prefix Tree).
 * 
 */
public class TriePrefixTree {

	static class Elem {
		public char c;
		public boolean terminal;
		public Map<Character, Elem> elems = new HashMap<>();
		
		public Elem(char c) {
			this.c = c;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + c;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Elem other = (Elem) obj;
			if (c != other.c)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Elem [c=" + c + ", terminal=" + terminal + "]";
		}
	}
	
	static class Trie {

		private Map<Character, Elem> have;
		
		public Trie() {
			have = new HashMap<>();
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			Map<Character, Elem> cur = have;
			Elem elem = null;
			for (char c : word.toCharArray()) {
				if (!cur.containsKey(c)) {
					cur.put(c, new Elem(c));
				}
				elem = cur.get(c);
				cur = cur.get(c).elems;
			}
			if (elem != null) {
				elem.terminal = true;
			}
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			Map<Character, Elem> cur = have;
			Elem elem = null;
			for (char c : word.toCharArray()) {
				if (!cur.containsKey(c)) {
					return false;
				}
				elem = cur.get(c);
				cur = cur.get(c).elems;
			}
			if (elem != null) {
				return elem.terminal;
			}
			return false;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			Map<Character, Elem> cur = have;
			for (char c : prefix.toCharArray()) {
				if (!cur.containsKey(c)) {
					return false;
				}
				cur = cur.get(c).elems;
			}
			return true;
		}
	}

	public static void main(String[] arg) {
		
		Trie trie = new Trie();
		 
		trie.insert("apple"); 
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false 
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app"); 
		System.out.println(trie.search("app")); // returns true 


	}

}
