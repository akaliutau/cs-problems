package org.problems.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * 
 * Note:
 * 
 * If there are multiple valid itineraries, you should return the itinerary that
 * has the smallest lexical order when read as a single string. For example, the
 * itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. All
 * airports are represented by three capital letters (IATA code). You may assume
 * all tickets form at least one valid itinerary. One must use all the tickets
 * once and only once. 
 * 
 * Example 1:
 * 
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"] 
 * 
 * Example 2:
 * 
 * Input:
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"] 
 * 
 * Explanation: Another possible
 * reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in
 * lexical order.
 * 
 * 
 * 
 * 
 */
public class ReconstructItinerary {
	
	static class Flight {
		public List<String> ticket;
		public boolean done = false;

		public Flight(List<String> ticket) {
			this.ticket = ticket;
		}
		
		public String getSrc() {
			return ticket.get(0);
		}

		public String getDest() {
			return ticket.get(1);
		}

	}
	
	static boolean processSegment(Map<String,List<Flight>> flights, String src, Stack<String> res, int len) {
		int curLen = res.size();
		if (!flights.containsKey(src)) {
			return curLen == len;
		}
		if (curLen == len) {
			return true;
		}
		List<Flight> nextDest = flights.get(src);
		for (Flight f : nextDest) {
			if (f.done) {
				continue;
			}
			res.add(f.getDest());
			f.done = true;
			if (processSegment(flights, f.getDest(), res, len)) {
				
				return  true;
			}
			res.pop();
			f.done = false;
		}
		return false;
	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		Map<String,List<Flight>> flights = new HashMap<>();
		for (List<String> tk : tickets) {
			if (!flights.containsKey(tk.get(0))) {
				flights.put(tk.get(0), new ArrayList<>());
			}
			flights.get(tk.get(0)).add(new Flight(tk));
		}
		Comparator<Flight> byDest = (o,p) -> o.getDest().compareTo(p.getDest());
		for (String src : flights.keySet()) {
			flights.get(src).sort(byDest);
		}
		
		
		String cur = "JFK";
		Stack<String> res = new Stack<>();
		res.add(cur);
		processSegment(flights, cur, res, tickets.size() + 1);
		return res;

	}

	public static void main(String[] arg) {
		
		
		List<List<String>> tickets = Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"));
		System.out.println(findItinerary(tickets));

		List<List<String>> tickets1 = Arrays.asList(Arrays.asList("JFK","SFO"), Arrays.asList("JFK","ATL"), Arrays.asList("SFO","ATL"), Arrays.asList("ATL","JFK"), Arrays.asList("ATL","SFO"));
		System.out.println(findItinerary(tickets1));

	}

}
