package org.problems.topology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * 
 */
public class CriticalConnections {

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

		public Graph(int n, List<List<Integer>> connections) {
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
						critical.add(Arrays.asList(current, neighbor));
					}
				} else {
					lowTime[current] = Math.min(lowTime[current], visitedTime[neighbor]);
				}
			}
		}

		public void createGraph(List<List<Integer>> connections) {
			for (int i = 0; i < n; i++) {
				graph[i] = new Edge();
			}
			for (List<Integer> list : connections) {
				graph[list.get(0)].add(list.get(1));
				graph[list.get(1)].add(list.get(0));
			}
		}

	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		Graph g = new Graph(n, connections);
		g.dfs(0, -1);
		return g.critical;
	}

	public static void main(String[] arg) {
	}

}
