package org.problems.datastructures;

/**
 * https://leetcode.com/problems/license-key-formatting/
 * 
 * You are given a license key represented as a string S which consists only
 * alphanumeric character and dashes. The string is separated into N+1 groups by
 * N dashes.
 * 
 * Given a number K, we would want to reformat the strings such that each group
 * contains exactly K characters, except for the first group which could be
 * shorter than K, but still must contain at least one character. Furthermore,
 * there must be a dash inserted between two groups and all lowercase letters
 * should be converted to uppercase.
 * 
 * Given a non-empty string S and a number K, format the string according to the
 * rules described above.
 * 
 * Example 1: Input: S = "5F3Z-2e-9-w", K = 4
 * 
 * Output: "5F3Z-2E9W"
 * 
 * Explanation: The string S has been split into two parts, each part has 4
 * characters. Note that the two extra dashes are not needed and can be removed.
 * Example 2: Input: S = "2-5g-3-J", K = 2
 * 
 * Output: "2-5G-3J"
 * 
 * Explanation: The string S has been split into three parts, each part has 2
 * characters except the first part as it could be shorter as mentioned above.
 * Note: The length of string S will not exceed 12,000, and K is a positive
 * integer. String S consists only of alphanumerical characters (a-z and/or A-Z
 * and/or 0-9) and dashes(-). String S is non-empty
 * 
 * 
 */
public class LicenseKeyFormatter {
	
	static class LicenseKey {
		public String s;
		public int idx;
		public int symbols = 0;
		public int groups = 0;
		public int firstGroupLen = 0;
		public int len = 0;
		
		public LicenseKey(String s, int len) {
			this.s = s.toLowerCase();
			this.len = len;
		}
		
		public char next() {
			while ( idx < s.length()) {
				char c= s.charAt(idx);
				idx ++;
				if (c != '-') {
					if (c >= '0' && c <= '9') {
						return c;
					}
					int index = c - 'a';
					return (char)(index + 'A');
				}
			}
			return 0;
		}

		
		public void analyse() {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != '-') {
					symbols ++;
				}
			}
			if (symbols % len != 0) {
				groups = symbols / len + 1;
				firstGroupLen = symbols % len;
			}else {
				groups = symbols / len;
				firstGroupLen = len;
				if (groups == 0) {
					groups = 1;
				}
			}
		}
		
		public String getGroup(int length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < length; i++) {
				sb.append(next());
			}
			return sb.toString();
		}
		
		public String getReformatted() {
			String[] str = new String[groups];
			str[0] = getGroup(firstGroupLen);
			for (int i = 1; i < groups; i++) {
				str[i] = getGroup(len);
			}
			return String.join("-", str);
		}

		@Override
		public String toString() {
			return "LicenseKey [s=" + s + ", idx=" + idx + ", symbols=" + symbols + ", groups=" + groups
					+ ", firstGroupLen=" + firstGroupLen + ", len=" + len + "]";
		}
		
	}

	public static String licenseKeyFormatting(String s, int k) {
		LicenseKey key = new LicenseKey(s,k);
		key.analyse();
		if (key.symbols == 0) {
			return "";
		}
		return key.getReformatted();
	}

	public static void main(String[] arg) {

		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w",4));
		System.out.println(licenseKeyFormatting("2-5g-3-J",2));
		System.out.println(licenseKeyFormatting("---",2));

	}

}
