package org.problems.statistics;

import java.util.HashMap;
import java.util.Map;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/making-file-names-unique/
 * 
 * Given an array of strings names of size n. You will create n folders in your
 * file system such that, at the ith minute, you will create a folder with the
 * name names[i].
 * 
 * Since two files cannot have the same name, if you enter a folder name which
 * is previously used, the system will have a suffix addition to its name in the
 * form of (k), where, k is the smallest positive integer such that the obtained
 * name remains unique.
 * 
 * Return an array of strings of length n where ans[i] is the actual name the
 * system will assign to the ith folder when you create it.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: names = ["pes","fifa","gta","pes(2019)"] Output:
 * ["pes","fifa","gta","pes(2019)"] 
 * 
 * Explanation: Let's see how the file system
 * creates folder names: "pes" --> not assigned before, remains "pes" "fifa" -->
 * not assigned before, remains "fifa" "gta" --> not assigned before, remains
 * "gta" "pes(2019)" --> not assigned before, remains "pes(2019)"
 * 
 */
public class UniqueFileNames {

	static class Holder {
		public int last = 1;
	}

	public static String[] getFolderNames(String[] names) {
		int n = names.length;
		Map<String, Holder> map = new HashMap<>();
		Map<String, Holder> map1 = new HashMap<>();
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			if (map.containsKey(names[i])) {
				String s = String.format("%s(%d)", names[i], map.get(names[i]).last++);
				while (map1.containsKey(s) || map.containsKey(s)) {
					s = String.format("%s(%d)", names[i], map.get(names[i]).last++);
				}
				res[i] = s;
				map.put(s, new Holder());
			} else {
				res[i] = names[i];
				map.put(names[i], new Holder());
			}
		}
		return res;
	}

	public static void main(String[] arg) {

		String[] names = { "kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)" };

		Utils.print(getFolderNames(names));

	}

}
