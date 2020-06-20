package org.problems.regex;

/**
 * https://leetcode.com/problems/validate-ip-address/
 * 
 * Write a function to check whether an input string is a valid IPv4 address or
 * IPv6 address or neither.
 * 
 * IPv4 addresses are canonically represented in dot-decimal notation, which
 * consists of four decimal numbers, each ranging from 0 to 255, separated by
 * dots ("."), e.g.,172.16.254.1;
 * 
 * Besides, leading zeros in the IPv4 is invalid. For example, the address
 * 172.16.254.01 is invalid.
 * 
 * IPv6 addresses are represented as eight groups of four hexadecimal digits,
 * each group representing 16 bits. The groups are separated by colons (":").
 * For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid
 * one. Also, we could omit some leading zeros among four hexadecimal digits and
 * some low-case characters in the address to upper-case ones, so
 * 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading
 * zeros and using upper cases).
 * 
 * However, we don't replace a consecutive group of zero value with a single
 * empty group using two consecutive colons (::) to pursue simplicity. For
 * example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * 
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the
 * address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 * 
 * Note: You may assume there is no extra space or special characters in the
 * input string.
 * 
 * Example 1: Input: "172.16.254.1"
 * 
 * Output: "IPv4"
 * 
 * Explanation: This is a valid IPv4 address, return "IPv4". Example 2: Input:
 * "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 
 * Output: "IPv6"
 * 
 * Explanation: This is a valid IPv6 address, return "IPv6". Example 3: Input:
 * "256.256.256.256"
 * 
 * Output: "Neither"
 * 
 * Explanation: This is neither a IPv4 address nor a IPv6 address
 * 
 * 
 * 
 */
public class ValidateIpAddress {
	static final String N = "Neither";
	
	static boolean checkIp4Range(String s) {
		int base = 1;
		int num = 0;
		if (s == null || s.isEmpty()) {
			return false;
		}
		if (s.charAt(0) == '0' && s.length() > 1) {
			return false;
		}
		for (int i = s.length() - 1; i > -1; i--) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				num += (c - '0') * base;
				base *= 10;
			}else {
				return false;
			}
		}
		return num >= 0 && num <= 255;
	}
	
	static boolean checkIp6Range(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		if (s.length() > 1 && s.charAt(0) == '0' && s.charAt(1) == '0') {
//			return false;
		}
		if (s.length() > 4) {
			return false;
		}
		for (int i = s.length() - 1; i > -1; i--) {
			char c = s.charAt(i);
			if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')) {
			}else {
				return false;
			}
		}
		return true;
	}
	
	static String checkIpv4(String ip) {
		String[] blocks = ip.split("\\.");
		if (blocks.length == 4) {
			if (ip.charAt(ip.length()-1) == '.') {
				return N;
			}
			for (int i = 0; i < 4; i++) {
				if (!checkIp4Range(blocks[i])) {
					return N;
				}
			}
			return "IPv4";
		}
		return N;
		
	}

	static String checkIpv6(String ip) {
		String[] blocks = ip.split(":");
		if (blocks.length == 8) {
			if (ip.charAt(ip.length()-1) == ':') {
				return N;
			}
			boolean empty = true;
			for (int i = 0; i < 8; i++) {
				if (blocks[i].isEmpty()) {
					if (empty) {
						continue;
					}else {
						return N;
					}
				}else {
					empty = false;
				}
				if (!checkIp6Range(blocks[i])) {
					return N;
				}
			}
			return "IPv6";
		}
		return N;
	}

	public static String validIPAddress(String ip) {
		if (ip == null || ip.isEmpty()) {
			return N;
		}
		if (ip.contains(".")) {
			return checkIpv4(ip.toLowerCase());
		}
		if (ip.contains(":")) {
			return checkIpv6(ip.toLowerCase());
		}
		return N;

	}

	public static void main(String[] arg) {

		System.out.println(validIPAddress("172.16.254.1"));
		System.out.println(validIPAddress("172.16.254.01"));
		System.out.println(validIPAddress("0.0.0.1"));
		System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
		System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));

	}

}
