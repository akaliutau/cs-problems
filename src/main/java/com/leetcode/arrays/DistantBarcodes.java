package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/distant-barcodes/
 * 
 * In a warehouse, there is a row of barcodes, where the i-th barcode is
 * barcodes[i].
 * 
 * Rearrange the barcodes so that no two adjacent barcodes are equal. You may
 * return any answer, and it is guaranteed an answer exists.
 * 
 * Example 1:
 * Input: [1,1,1,2,2,2] Output: [2,1,2,1,2,1] 
 * 
 * Example 2:
 * Input: [1,1,1,1,2,2,3,3] Output: [1,3,1,3,2,1,2,1]
 * 
 * Note:
 * 1 <= barcodes.length <= 10000 
 * 1 <= barcodes[i] <= 10000
 * 
 */
public class DistantBarcodes {
	
	static class Barcode{
		public int code;
		public int amount = 0;

		public Barcode(int code) {
			this.code = code;
		}

		@Override
		public String toString() {
			return "Barcode [code=" + code + ", amount=" + amount + "]";
		}
	}

	public static int[] rearrangeBarcodes(int[] barcodes) {
		Map<Integer,Barcode> codes = new HashMap<>();
		int n = barcodes.length;
		for (int code : barcodes) {
			if (!codes.containsKey(code)) {
				codes.put(code, new Barcode(code));
			}
			codes.get(code).amount++;
		}
		if (n < 3) {
			return barcodes;
		}
		
		Set<Integer> availableCodes = codes.keySet();
		int[] res = new int[n];
		int idx = 0;
		Comparator<Barcode> byAmount = (o,p) -> Integer.compare(p.amount, o.amount);

		List<Barcode> bars = new ArrayList<>(codes.values());
		bars.sort(byAmount);
		System.out.println(bars);

		while (!availableCodes.isEmpty() && idx < n) {
			
			Barcode barcode0 = bars.get(0);
			if (barcode0.amount > 0 ) {
				res[idx++] = barcode0.code;
				barcode0.amount --;
			}
			Barcode barcode1 = bars.get(1);
			if (barcode1.amount > 0 ) {
				res[idx++] = barcode1.code;
				barcode1.amount --;
			}
			
			for (int i = 2; i < availableCodes.size(); i++) {
				Barcode prevBarcode = bars.get(0);
				Barcode barcode = bars.get(i);
				if (barcode.amount > 0 && barcode.amount >= prevBarcode.amount) {
					res[idx++] = barcode.code;
					barcode.amount --;
				}
			}
		}
		
		return res;

	}

	public static void main(String[] arg) {
		
		int[] barcodes = {1,1,1,2,2,2};
		Utils.print(rearrangeBarcodes(barcodes));

		int[] barcodes1 = {1,1,1,1,2,2,3,3};
		Utils.print(rearrangeBarcodes(barcodes1));

		int[] barcodes2 = {1,1,1,1,1,1,2,2,2,2,3,3};
		Utils.print(rearrangeBarcodes(barcodes2));

	}

}
