package org.problems.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * 
 * There are n servers numbered from 0 to n-1 connected by undirected
 * server-to-server connections forming a network where connections[i] = [a, b]
 * represents a connection between servers a and b. Any server can reach any
 * other server directly or indirectly through the network.
 * 
 * A critical connection is a connection that, if removed, will make some server
 * unable to reach some other server.
 * 
 * Return all critical connections in the network in any order.
 * 
 * Example 1:
 * 
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]] Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 * 
 * Constraints:
 * 
 * 1 <= n <= 10^5 
 * n-1 <= connections.length <= 10^5 
 * connections[i][0] != connections[i][1] 
 * There are no repeated connections.
 * 
 */
public class CriticalConnections {
	
	static class Server {
		public int id;
		public boolean check;
		
		public List<Integer> conn = new ArrayList<>();
		
		public Server(int id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			return id;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Server other = (Server) obj;
			if (id != other.id)
				return false;
			return true;
		}
	}
	
	/**
	 * Find edges with only one route
	 * @param graph
	 * @param visited
	 * @param rank
	 * @param prevNode
	 * @param curNode
	 * @param curRunk
	 * @param results
	 */
    private static void dfs(Map<Integer, Server> graph, boolean[] visited, int[] rank, int prevNode, int curNode, int curRunk, List<List<Integer>> results){
        rank[curNode] = curRunk;
        visited[curNode] = true;
        for (int neighbor : graph.get(curNode).conn){
            if (neighbor == prevNode) {
                continue;
            }
            if (!visited[neighbor]) {
                dfs(graph, visited, rank, curNode, neighbor, curRunk + 1, results);
            }
            // compare with neighbor - will be downgraded if and only if there is one route
            rank[curNode] = Math.min(rank[curNode], rank[neighbor]);
            // add critical if any
            if (rank[neighbor] == curRunk + 1){
            	results.add(Arrays.asList(curNode, neighbor));
            }
        }
    }

	
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    	Map<Integer, Server> graph = new HashMap<>();
    	List<List<Integer>> res = new LinkedList<>();
        for (List<Integer> connection : connections){
            int cur = connection.get(0);
            int ref = connection.get(1);
            graph.putIfAbsent(cur, new Server(cur));
            graph.putIfAbsent(ref, new Server(ref));
            graph.get(cur).conn.add(ref);
            graph.get(ref).conn.add(cur);
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; ++i){
            rank[i] = i;
        }
        boolean[] visited = new boolean[n];
        int prevNode = -1;
        int curNode = 0;
        int curRank = 0;
        dfs(graph, visited, rank, prevNode, curNode, curRank, res);
        return res;
    }
    
	
	public static void main(String[] arg) {
		
		List<List<Integer>> connections = Arrays.asList(Arrays.asList(0,1), Arrays.asList(1,2), Arrays.asList(2,0), Arrays.asList(1,3));
		System.out.println(criticalConnections(4,connections));

		List<List<Integer>> connections1 = Arrays.asList(Arrays.asList(0,1), Arrays.asList(1,2), Arrays.asList(2,0), Arrays.asList(1,3), Arrays.asList(3,4), Arrays.asList(4,5), Arrays.asList(5,3));
		System.out.println(criticalConnections(6,connections1));

	}

}
