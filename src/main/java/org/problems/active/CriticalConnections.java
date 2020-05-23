package org.problems.active;

import java.util.ArrayList;
import java.util.HashMap;
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
		
		public List<Integer> in = new ArrayList<>();
		public List<Integer> out = new ArrayList<>();
		
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

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		Map<Integer,Server> servers = new HashMap<>();
		return connections;

	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
