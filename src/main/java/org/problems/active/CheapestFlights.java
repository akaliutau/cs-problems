package org.problems.active;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * 
 * There are n cities connected by m flights. Each flight starts from city u and
 * arrives at v with a price w.
 * 
 * Now given all the cities and flights, together with starting city src and the
 * destination dst, your task is to find the cheapest price from src to dst with
 * up to k stops. If there is no such route, output -1.
 * 
 * Example 1: Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]] src = 0, dst
 * = 2, k = 1 Output: 200
 * 
 * Example 2: Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]] src = 0, dst
 * = 2, k = 0 Output: 500
 * 
 * Note:
 * 
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to
 * n - 1. 
 * The size of flights will be in range [0, n * (n - 1) / 2]. 
 * The format of each flight will be (src, dst, price). 
 * The price of each flight will be in the range [1, 10000]. k is in the range of [0, n - 1]. 
 * There will not be any duplicated flights or self cycles
 * 
 */
public class CheapestFlights {
	
	static class Path implements Comparable<Path>{
		public int price = 0;
		public int stops = 0;

		public Path(int price, int stops) {
			this.price = price;
			this.stops = stops;
		}

		@Override
		public String toString() {
			return "Path [price=" + price + ", stops=" + stops + "]";
		}

		@Override
		public int compareTo(Path p) {
			return Integer.compare(stops, p.stops);
		}
	}
	
	static class Node {
		public boolean processed = false;
		public int id;
		public int in = 0;
		public List<Path> paths = new ArrayList<>();
		public Map<Node,Integer> refs = new HashMap<>();
		
		public Node(int id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Node [processed=" + processed + ", id=" + id + ", in=" + in + ", paths=" + paths + "]";
		}

	}
	
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int total = flights.length;
		Node[] nodes = new Node[n];
		for (int i = 0; i < total; i++) {
			int[] flight = flights[i];
			int id = flight[0];
			if (nodes[id] == null) {
				nodes[id] = new Node(id);
			}
			int ref = flight[1];
			if (nodes[ref] == null) {
				nodes[ref] = new Node(ref);
			}
			nodes[id].refs.put(nodes[ref], flight[2]);
			nodes[ref].in ++;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(nodes[src]);
		Path p = new Path(0,0);
		nodes[src].paths.add(p);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.processed) {
				continue;
			}else {
				cur.processed = true;
			}
			for (Node ref : cur.refs.keySet()) {
				for (Path path : cur.paths) {
					if (path.stops - 1 < k)
						ref.paths.add(new Path(cur.refs.get(ref) + path.price,path.stops+1));
				}
				queue.add(ref);
				if (ref.id == dst && --ref.in == 0) {
					queue.clear();
					break;
				}
			}
			
		}
		System.out.println(nodes[dst]);
		if ( nodes[dst].paths.size() == 0) {
			return -1;
		}
		int minPrice = Integer.MAX_VALUE;
		for (Path path : nodes[dst].paths) {
			minPrice = minPrice > path.price ? path.price : minPrice;
		}
		
		return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
        
    }


	public static void main(String[] arg) {
		
		int[][] flights = {
				{0,1,100},
				{1,2,100},
				{0,2,500}
		};

		System.out.println(findCheapestPrice(3,flights, 0, 2, 1)); // 1 stop
		System.out.println(findCheapestPrice(3,flights, 0, 2, 0));// no stops
		
		int[][] flights1 = {
				{1,0,5}
		};

		System.out.println(findCheapestPrice(2,flights1, 0, 1, 1));

		int[][] flights2 = {
				{0,1,1},
				{0,2,5},
				{1,2,1},
				{2,3,1}
		};

		System.out.println(findCheapestPrice(4,flights2, 0, 3, 1));//6 - 1 stop
		System.out.println(findCheapestPrice(4,flights2, 0, 3, 2));//3 - 2 stops
		
			
		int[][] flights3 = {
				{4,1,1},
				{1,2,3},
				{0,3,2},
				{0,4,10},
				{3,1,1},
				{1,4,3}
		};

		System.out.println(findCheapestPrice(5,flights3, 2, 1, 1));//6 - 1 stop


	}

}
