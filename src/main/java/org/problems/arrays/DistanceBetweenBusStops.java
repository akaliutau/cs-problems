package org.problems.arrays;

/**
 * https://leetcode.com/problems/distance-between-bus-stops/
 * 
 * A bus has n stops numbered from 0 to n - 1 that form a circle. We know the
 * distance between all pairs of neighboring stops where distance[i] is the
 * distance between the stops number i and (i + 1) % n.
 * 
 * The bus goes along both directions i.e. clockwise and counterclockwise.
 * 
 * Return the shortest distance between the given start and destination stops.
 * 
 * Input: distance = [1,2,3,4], start = 0, destination = 1 Output: 1
 * Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 * 
 */
public class DistanceBetweenBusStops {

	public static int distanceBetweenBusStops(int[] distance, int s, int d) {
        int dest1 = 0;
		int dest2 = 0;
        int start, destination;
        if (s < d){
            start = s;
            destination = d;
        }else{
            start = d;
            destination = s;
        }
		int n = distance.length;
		for (int i = start; i < destination; i++) {
			dest1 += distance[i];
		}
		for (int i = destination; i < start + n; i++) {
			dest2 += distance[i % n];
		}
		return Math.min(dest1, dest2);
	}

	public static void main(String[] arg) {
		
		int[] distance = {1,2,3,4};
		System.out.println(distanceBetweenBusStops(distance, 0 ,1));

		int[] distance1 = {1,2,3,4};
		System.out.println(distanceBetweenBusStops(distance1, 0 ,3));

	}

}
