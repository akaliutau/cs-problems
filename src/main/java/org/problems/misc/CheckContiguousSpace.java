package org.problems.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Given the set of occupied sectors on HDD =occupiedSectors and the size of HDD =blockSize
 * find it is possible or not to write a contiguous file of size = fileSize
 * 
 */
public class CheckContiguousSpace {

    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        List<Integer> occupied = new ArrayList<>(occupiedSectors);
       int min = Integer.MAX_VALUE;
       int max = 0;
       for (Integer i : occupied) {
    	   min = Math.min(min, i);
    	   max = Math.max(max, i);
       }
       if (min - 1 >= fileSize || blockSize - max >= fileSize) {
    	   return true;
       }
       Collections.sort(occupied);
       for (int i = 1; i < occupied.size(); i++) {
    	   if (occupied.get(i) - occupied.get(i - 1) - 1 >= fileSize) {
    		   return true;
    	   }
       }
       return false;
   }
	
	public static void main(String[] arg) {
		System.out.println(true);
	}

}
