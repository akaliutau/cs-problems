package org.problems.datastructures;

import java.util.Stack;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/simplify-path/
 * 
 * Given an absolute path for a file (Unix-style), simplify it. Or in other
 * words, convert it to the canonical path.
 * 
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level. For more
 * information, see: Absolute path vs relative path in Linux/Unix
 * 
 * Note that the returned canonical path must always begin with a slash /, and
 * there must be only a single slash / between two directory names. The last
 * directory name (if it exists) must not end with a trailing /. Also, the
 * canonical path must be the shortest string representing the absolute path.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "/home/" Output: "/home" 
 * Explanation: Note that there is no trailing slash after the last directory name. 
 * 
 * Example 2:
 * 
 * Input: "/../" Output: "/" 
 * Explanation: Going one level up from the root
 * directory is a no-op, as the root level is the highest level you can go.
 * 
 * Example 3:
 * 
 * Input: "/home//foo/" Output: "/home/foo" 
 * Explanation: In the canonical path,
 * multiple consecutive slashes are replaced by a single one.
 * 
 * 
 */
public class SimplifyPath {

	public static String simplifyPath(String path) {
		String[] parts = path.split("/");
		int n = parts.length;

		Stack<String> cleaned = new Stack<>();
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].equals("..")) {
				if (cleaned.isEmpty() || cleaned.peek().equals("..")){
					//cleaned.add("..");
				}else {
					cleaned.pop();
				}
			}else {
				if (!parts[i].equals(".") && !parts[i].isEmpty()) {
					cleaned.add(parts[i]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cleaned.size(); i++) {
			sb.append("/");
			sb.append(cleaned.get(i));
		}
		if (sb.length() == 0) {
			sb.append("/");
		}
		return sb.toString();

	}

	public static void main(String[] arg) {

		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/../"));
		System.out.println(simplifyPath("/home/../../foo/"));

	}
}
