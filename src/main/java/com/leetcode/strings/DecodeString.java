package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/decode-string/
 * 
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc". 
 * s = "3[a2[c]]", return "accaccacc". 
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef"
 */
public class DecodeString {

	static class StringWrapper {
		public String string;
		public int from;

		public StringWrapper(String string, int pos) {
			this.string = string;
			this.from = pos;
		}

		public int len() {
			return string.length();
		}
	}
	
	static class Block {
		public StringBuilder times = new StringBuilder();
		public StringBuilder data = new StringBuilder();
		public List<Block> body = new ArrayList<>();
		
		public Block() {
		}
		
		public void addDigit(char c) {
			times.append(c);
		}
		
		public void addChar(char c) {
			data.append(c);
		}
		
		public void add(Block block) {
			body.add(block);
		}
		
		public Block get() {
			Block block = new Block();
			body.add(block);
			return block;
		}

		
		public String eval() {
			StringBuilder sb = new StringBuilder();
			
			int t = times.length() == 0 ? 1 : Integer.valueOf(times.toString());
			for (Block b : body) {
				sb.append(b.eval());
			}
			StringBuilder sb1 = new StringBuilder();
			sb1.append(data.toString());
		
			for (int i = 0; i < t; i++) {
				sb1.append(sb.toString());
			}
			
			return sb1.toString();
		}

		@Override
		public String toString() {
			return "[times=" + times.toString() + ", data=" + data.toString() + ", body=" + body + "]";
		}
		
	}

	public static void decodeString(Block master, StringWrapper sw) {
		Block block = master.get();
		while(sw.from < sw.len()) {
			char c = sw.string.charAt(sw.from);
				sw.from++;
			if ('0' <= c  && c <= '9') {
				block.addDigit(c);
			}else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
				block.addChar(c);
			}else if (c == ']') {
				return;
			}else if (c == '[') {
				decodeString(block, sw);
				block = master.get();
			}
		}
	}
	
	
	public static String decodeString(String s) {
		StringWrapper sw = new StringWrapper(s, 0);
		Block master = new Block();
		decodeString(master, sw);
		return master.eval();
	}

	public static void main(String[] arg) {

		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]a3[cd]ef"));
		System.out.println(decodeString("100[a]"));
		System.out.println(decodeString("3[a]2[b4[F]c]"));
		System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));//zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
		
	}

}
