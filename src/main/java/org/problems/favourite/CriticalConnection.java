package org.problems.favourite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Data Center Critical Connection
 * 
 * Given a data center with n servers from 1 to n. To make the data center
 * running, all servers must be connected, that means there exists at least one
 * path between any pair of servers. Now we know there could be some critical
 * connections broken which brings down the whole data center. You need to write
 * a program to find out all these broken critical connections. A server
 * connection is a critical connection which when removed will make the whole
 * data center disconnected. Write a method to output all critical connections.
 * 
 * Input: serversNum, the number of servers in the data center. connectionsNum,
 * the number of connections between the servers. connections, a list of pairs
 * representing the connections between two severs.
 * 
 * Output: Return a list of integer pairs representing the critical connections.
 * Output an empty array if there are no critical connections.
 * 
 * Example : 
 * Input: 
 * serversNum = 4 
 * connectionsNum = 4 
 * connections = [[1, 2], [1, 3], [3, 2], [3, 4]]
 * 
 * Output: [[3,4]] Explanation: There are one critical connections: 1. Between
 * server 3 and 4 If the connection [3, 4] breaks, then the network will be
 * disconnected since servers 3 and 4 cannot communicate with the rest of the
 * network. Remaining three connections are not critical.
 */
public class CriticalConnection {
	
	static class Edge {
		public List<Integer> ties = new ArrayList<>();
		
		public void add(Integer i) {
			ties.add(i);
		}
	}

	static class Graph {
		Edge[] graph;
		int[] visitedTime;
		int[] lowTime;
		int time;
		List<List<Integer>> critical;
		boolean[] visited;
		int n;


		public Graph(int n, int[][] connections) {
			this.n = n;
			critical = new ArrayList<>();
			graph = new Edge[n];
			visitedTime = new int[n];
			lowTime = new int[n];
			visited = new boolean[n];
			time = 0;
			createGraph(connections);

		}

		public void dfs(int current, int parent) {
			visited[current] = true;
			lowTime[current] = time++;
			visitedTime[current] = lowTime[current];
			for (int neighbor : graph[current].ties) {
				if (neighbor == parent) {
					continue;
				}
				if (!visited[neighbor]) {
					dfs(neighbor, current);
					lowTime[current] = Math.min(lowTime[current], lowTime[neighbor]);
					if (lowTime[neighbor] > visitedTime[current]) {
						critical.add(Arrays.asList(current + 1, neighbor + 1));
					}
				} else {
					lowTime[current] = Math.min(lowTime[current], visitedTime[neighbor]);
				}
			}
		}

		public void createGraph(int[][] connections) {
			for (int i = 0; i < n; i++) {
				graph[i] = new Edge();
			}
			for (int[] list : connections) {
				graph[list[0] - 1].add(list[1] - 1);
				graph[list[1] - 1].add(list[0] - 1);
			}
		}

	}

	public static List<List<Integer>> criticalConnections(int n, int[][] connections) {
		Graph g = new Graph(n, connections);
		g.dfs(0, -1);
		return g.critical;
	}

	public static void main(String[] arg) {
		int[][] connections = {
				{1, 2}, {1, 3}, {3, 2}, {3, 4}
		};
		
		System.out.println(criticalConnections(4, connections));
	}

}
