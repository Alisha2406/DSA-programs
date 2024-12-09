package dsa;


	import java.util.*;

	 public class Graph {
	    private int V; // Number of vertices
	    private List<List<Integer>> adjList; // Adjacency list

	    // Constructor
	    public Graph(int V) {
	        this.V = V;
	        adjList = new ArrayList<>();
	        for (int i = 0; i < V; i++) {
	            adjList.add(new ArrayList<>());
	        }
	    }

	    // Add an undirected edge to the graph
	    public void addEdge(int u, int v) {
	        adjList.get(u).add(v);
	        adjList.get(v).add(u);
	    }

	    // Function to detect a cycle in the undirected graph
	    public boolean hasCycle() {
	        boolean[] visited = new boolean[V]; // To keep track of visited nodes

	        // Call the recursive helper function for all unvisited nodes
	        for (int i = 0; i < V; i++) {
	            if (!visited[i]) {
	                if (dfs(i, -1, visited)) {
	                    return true; // Cycle found
	                }
	            }
	        }

	        return false; // No cycle found
	    }

	    // DFS helper function
	    private boolean dfs(int node, int parent, boolean[] visited) {
	        visited[node] = true;

	        // Recurse for all adjacent vertices
	        for (int neighbor : adjList.get(node)) {
	            // If the neighbor is not visited, recurse for it
	            if (!visited[neighbor]) {
	                if (dfs(neighbor, node, visited)) {
	                    return true; // Cycle found
	                }
	            }
	            // If the neighbor is visited and is not the parent, a cycle is detected
	            else if (neighbor != parent) {
	                return true; // Cycle detected
	            }
	        }

	        return false; // No cycle found
	    }

	    public static void main(String[] args) {
	        Graph g = new Graph(5); // Create a graph with 5 vertices

	        // Add edges
	        g.addEdge(0, 1);
	        g.addEdge(1, 2);
	        g.addEdge(2, 3);
	        g.addEdge(3, 4);
	        g.addEdge(4, 0); // Adding a cycle

	        // Detect cycle
	        if (g.hasCycle()) {
	            System.out.println("Cycle detected in the graph.");
	        } else {
	            System.out.println("No cycle detected in the graph.");
	        }

	        // Example of a graph without a cycle
	        Graph g2 = new Graph(4); // Create another graph with 4 vertices
	        g2.addEdge(0, 1);
	        g2.addEdge(1, 2);
	        g2.addEdge(2, 3);

	        // Detect cycle
	        if (g2.hasCycle()) {
	            System.out.println("Cycle detected in the graph.");
	        } else {
	            System.out.println("No cycle detected in the graph.");
	        }
	    }
	}


