package org.problems.favourite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Largest Association Group.
 * 
 * Given a graph representing item association relationships (i.e. group of
 * items likely to be ordered together), write the algorithm to find the largest
 * association group.
 * 
 * 
 */
public class AssociationGroup {
	
	static class Node {
	    public int id;
	    public String name;
	    public Node parent;
	    public int size = 1;
	    public List<Node> relations = new LinkedList<>();
	    
	    Node(int id, String name){
	        this.id = id;
	        this.name = name;
	        parent = this;
	        relations.add(this); // loop relation
	    }
	}

	
	static class Graph {
	    public Map<Integer, Node> nodes;
	    public int maxSize;
	    public List<Node> largest;
	    
	    public Graph(){
	        nodes = new HashMap<>();
	        maxSize = 0;
	        largest = new LinkedList<>();
	    }
	    
	    public void add(int id, String name) {
            nodes.put(id, new Node(id, name));
	    }
	    
	    public void union(int id1, int id2){
	        if(isRelated(id1, id2) || id1 == id2) {
	        	return;
	        }
	        
	        Node parent1 = nodes.get(find(id1));
	        Node parent2 = nodes.get(find(id2));
	        
	        if(parent1.relations.get(0).name.compareTo(parent2.relations.get(0).name) < 0){
	            link(parent1, parent2);
	        }else{
	            link(parent2, parent1);
	        }
	    }
	    
	    public void link(Node n1, Node n2){
	        n1.size += n2.size;
	        n1.relations.addAll(n2.relations);
	        n2.relations = null; 
	        n2.parent = n1;
	        
	        if(n1.size > maxSize){
	            maxSize = n1.size;
	            largest = n1.relations;
	        }else if(n1.size == maxSize){
	            if(largest.get(0).name.compareTo(n1.relations.get(0).name) > 0){
	                largest = n1.relations;
	            }
	        }
	    }
	    
	    public boolean isRelated(int s1, int s2){
	        return find(s1) == find(s2);
	    }
	    
	    public int find(int itemId){
	        Node node = nodes.get(itemId);
	        while(node.parent.id != node.id){
	            node = nodes.get(node.parent.id);
	        }
	        Node suffix = nodes.get(itemId);
	        while(suffix.parent.id != node.id){
	        	int parentId = suffix.parent.id;
	            suffix.parent = node;
	            suffix = nodes.get(parentId);
	        }
	        return node.id;
	    }
	}

	
	public static List<String> largestItemAssociation(int n, int[][] itemAssociations, String[] names) {
	      if(itemAssociations.length == 0) {
	    	  return new ArrayList<>();
	      }
	      
	      // building graph
	      Graph g = new Graph();
	      for (int[] link : itemAssociations) {
	    	  if (!g.nodes.containsKey(link[0])) {
	    		  g.add(link[0], names[link[0]]);
	    	  }
	    	  if (!g.nodes.containsKey(link[1])) {
	    		  g.add(link[1], names[link[1]]);
	    	  }
	    	  
	      }
	      
	      // connecting nodes
	      for (int[] link : itemAssociations) {
	            g.union(link[0], link[1]);
	      }
	        
	      return g.largest.stream().map(node -> node.name).collect(Collectors.toList());

	}
	

	public static void main(String[] arg) {
		
		String[] names = {"item1","item2","item3","item4","item5"};
		int[][] itemAssociations = {
				{0, 1},
				{2, 3},
				{3, 4}
		};
		System.out.println(largestItemAssociation(5, itemAssociations, names));// item3 item4 item5
		

		String[] names1 = {"item1","item2","item3","item4","item5","item6"};
		int[][] itemAssociations1 = {
				{5, 0},
				{5, 1},
				{1, 2},
				{3, 4}
		};
		System.out.println(largestItemAssociation(5, itemAssociations1, names1));// item1 item2 item3 item6

		String[] names2 = {"item1","item2","item3","item4","item5","item6"};
		int[][] itemAssociations2 = {
				{5, 4},
				{0, 5},
				{1, 2},
				{2, 3}
		};
		System.out.println(largestItemAssociation(5, itemAssociations2, names2));// item1 item5 item6

		String[] names3 = {"a","b","c","d","e","f", "w","x","y","z"};// testing lexicographicity
		int[][] itemAssociations3 = {
				{0, 1},
				{1, 0},
				{0, 2},
				{3, 4},
				{4, 5},
				{5, 4},
				{1, 4},
				{6, 7},
				{7, 8},
				{8, 9}
		};
		System.out.println(largestItemAssociation(5, itemAssociations3, names3));// a b c d e f


	}

}
