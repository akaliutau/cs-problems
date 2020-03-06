package com.leetcode.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * 
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 * "1.11.11.135", "11.1.111.35"
 * 
 * 
 * conditions: 1) 4 elems of length 1-3 2) elem[0] = [0,2]
 * 
 * memoization;
 * 
 * Map 11135 => [11.135,111.35]
 * 
 * 
 * Runtime: 3 ms, faster than 66.26% of Java online submissions for Restore IP Addresses.
 * Memory Usage: 38.7 MB, less than 20.93% of Java online submissions for Restore IP Addresses.
 * 
 * 
 */
public class RestoreIpAddresses {

	static void getIp(String[] curAddr, String addr, int n, Set<String> results) {
		if (n == 1) {
			int len = addr.length();
			if (len > 0 && len < 4) {
				char first = addr.charAt(0);
				if (first == '0' && len > 1) {
					return;
				}
				Integer last = Integer.valueOf(addr);
				if (last >= 0 && last < 256) {
					curAddr[4 - n] = addr;
					String res = String.join(".", curAddr);
					results.add(res);
				}
			}
		} else {
			for (int i = 1; i < 4 && i < addr.length(); i++) {
				String head = addr.substring(0, i);
				char first = head.charAt(0);
				if (first == '0' && i > 1) {
					continue;
				}
				Integer last = Integer.valueOf(head);
				if (last >= 0 && last < 256) {
					String tail = addr.substring(i);
					String[] next = new String[4];
					for (int j = 0; j < 4 - n; j++) {
						next[j] = curAddr[j];
					}
					next[4 - n] = head;
					getIp(next, tail, n - 1, results);
					results.add(tail);
				}
			}

		}
	}

	public static List<String> restoreIpAddresses(String s) {
		String[] next = new String[4];
		Set<String> results = new HashSet<>();
		getIp(next, s, 4, results);
		List<String> res = new ArrayList<>();
		for (String addr : results) {
			if (addr.contains(".")) {
				res.add(addr);
			}
		}
		return res;

	}

	public static void main(String[] arg) {

		System.out.println(restoreIpAddresses("11111135"));
		System.out.println(restoreIpAddresses("11135"));
		System.out.println(restoreIpAddresses("1134444135"));
		System.out.println(restoreIpAddresses("25525511135"));
		System.out.println(restoreIpAddresses("010010"));

	}
}
