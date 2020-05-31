package org.problems.datastructures;

/**
 * https://leetcode.com/problems/utf-8-validation/
 * 
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following
 * rules:
 * 
 * For 1-byte character, the first bit is a 0, followed by its unicode code. For
 * n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed
 * by n-1 bytes with most significant 2 bits being 10. This is how the UTF-8
 * encoding would work:
 * 
 * Char. number range  | UTF-8 octet sequence 
 * (hexadecimal)       |     (binary)
 * --------------------+--------------------------------------------- 
 * 0000 0000-0000 007F | 0xxxxxxx 
 * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx 
 * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx 
 * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx 
 * 
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 * 
 * Note: The input is an array of integers. Only the least significant 8 bits of
 * each integer is used to store the data. This means each integer represents
 * only 1 byte of data.
 * 
 * Example 1:
 * 
 * data = [197, 130, 1], which represents the octet sequence: 11000101 10000010
 * 00000001.
 * 
 * Return true. It is a valid utf-8 encoding for a 2-bytes character followed by
 * a 1-byte character. 
 * 
 * Example 2:
 * 
 * data = [235, 140, 4], which represented the octet sequence: 11101011 10001100
 * 00000100.
 * 
 * Return false. The first 3 bits are all one's and the 4th bit is 0 means it is
 * a 3-bytes character. The next byte is a continuation byte which starts with
 * 10 and that's correct. But the second continuation byte does not start with
 * 10, so it is invalid
 * 
 * Runtime: 1 ms, faster than 98.25% of Java online submissions for UTF-8 Validation.
 * Memory Usage: 40.3 MB, less than 9.09% of Java online submissions for UTF-8 Validation.
 */
public class UTF8Validation {
	
	
	static boolean twoBytes(int[] data, int idx) {
		if (data.length < idx + 2) {
			return false;
		}
		int word = data[idx+1];
		return (word & 192) == 128;
	}

	static boolean threeBytes(int[] data, int idx) {
		if (data.length < idx + 3) {
			return false;
		}
		int word1 = data[idx+1];
		int word2 = data[idx+2];
		return (word1 & 192) == 128 && (word2 & 192) == 128;
	}

	static boolean fourBytes(int[] data, int idx) {
		if (data.length < idx + 4) {
			return false;
		}
		int word1 = data[idx+1];
		int word2 = data[idx+2];
		int word3 = data[idx+3];
		return (word1 & 192) == 128 && (word2 & 192) == 128 && (word3 & 192) == 128;
	}
	
	static int checkType(int lead) {
		if ((lead & 128) == 0) {
			return 1;
		}else if ((lead & 224) == 192) {
			return 2;
		}else if ((lead & 240) == 224) {
			return 3;
		}else if ((lead & 248) == 240) {
			return 4;
		}
		return -1;
	}

	public static boolean validUtf8(int[] data) {
		
		int idx = 0;
		int n = data.length;
		if (n == 0) {
			return true;
		}
		while (idx < n) {
			int lead = data[idx];
			int type = checkType(lead);
			if (type == -1) {
				return false;
			}
			if (type == 1) {
				idx ++;
			}else if (type == 2) {
				if (!twoBytes(data, idx)) {
					return false;
				}
				idx += 2;
			}else if (type == 3) {
				if (!threeBytes(data, idx)) {
					return false;
				}
				idx += 3;
			}else if (type == 4) {
				if (!fourBytes(data, idx)) {
					return false;
				}
				idx += 4;
			}
		}
		return true;
        
    }

	public static void main(String[] arg) {
		
		int[] data = {197, 130, 1};

		System.out.println(validUtf8(data));

		int[] data1 = {235, 140, 4};

		System.out.println(validUtf8(data1));

	}

}
