package org.problems.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/snapshot-array/
 * 
 * Implement a SnapshotArray that supports the following interface:
 * 
 * SnapshotArray(int length) initializes an array-like data structure with the
 * given length. Initially, each element equals 0. void set(index, val) sets the
 * element at the given index to be equal to val. int snap() takes a snapshot of
 * the array and returns the snap_id: the total number of times we called snap()
 * minus 1. int get(index, snap_id) returns the value at the given index, at the
 * time we took the snapshot with the given snap_id
 * 
 * 
 * Example 1:
 * 
 * Input: ["SnapshotArray","set","snap","set","get"] [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5]
 * 
 * Explanation: SnapshotArray snapshotArr = new SnapshotArray(3); // set the
 * length to be 3 snapshotArr.set(0,5); // Set array[0] = 5 snapshotArr.snap();
 * // Take a snapshot, return snap_id = 0 snapshotArr.set(0,6);
 * snapshotArr.get(0,0); // Get the value of array[0] with snap_id = 0, return 5
 * 
 * 
 * Constraints:
 * 
 * 1 <= length <= 50000 At most 50000 calls will be made to set, snap, and get.
 * 0 <= index < length 0 <= snap_id < (the total number of times we call snap())
 * 0 <= val <= 10^9
 * 
 * 
 */
public class SnapshotArrayImpl {

	static class SnapshotArray {
		static class Patch {
			public Map<Integer, Integer> map = new HashMap<>();

			public static Patch get(int[] oldArr, int[] newArr) {
				Patch p = new Patch();
				for (int i = 0; i < oldArr.length; i++) {
					if (oldArr[i] != newArr[i]) {
						p.map.put(i, newArr[i]);
					}
				}
				return p;
			}

			@Override
			public String toString() {
				return "Patch [map=" + map + "]";
			}
		}

	    int counter;
	    Patch current;
	    Map<Integer, Patch> snaps;
	    
	    public SnapshotArray(int length) {
	        counter = 0;
	        current = new Patch();
	        snaps = new HashMap<>();
	    }
	    
	    public void set(int index, int val) {
	        current.map.put(index, val);
	    }
	    
	    public int snap() {
	        snaps.put(counter, current);
	        current = new Patch();
	        return counter++;
	    }
	    
	    public int get(int index, int snap_id) {
	        while (snap_id >= 0) {
	             Map<Integer, Integer> map = snaps.get(snap_id).map;
	             if (map.containsKey(index)) {
	            	 return map.get(index);
	             }
	             snap_id--;
	        }
	        return 0;
	    }
	}

	public static void main(String[] arg) {

		System.out.println("D");

	}

}
