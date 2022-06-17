package project;

// Create a Random Graph Using
// Random Edge Generation in Java
import java.util.*;
import java.io.*;

public class GFGRandomGraph {
	// Number of vertices
	public int vertices;

	// p represents the probability
	public int edgnum;

	// Set a maximum limit to the vertices
	//final int MAX_LIMIT = 20;

	// A Random instance to generate random values
	Random random = new Random();
	// An adjacency list to represent a graph
	public List<List<Integer> > adjacencyList;

	// Creating the constructor
	public GFGRandomGraph()
	{
		// we wrote n,m here in evere run inestead of asking user
		this.vertices = 9000;
                this.edgnum=45000;
		

		

		// Creating an adjacency list
		// representation for the random graph
		adjacencyList = new ArrayList<>(vertices);
		for (int i = 0; i < vertices; i++)
			adjacencyList.add(new ArrayList<>());

		// A for loop to randomly generate edges
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				
				float edgeProbability = random.nextFloat();
				//if (edgeProbability < p)
					addEdge(i, j);
			}
		}
	}

	// Method to add edges between given vertices
	void addEdge(int v, int w)
	{
		// Note: it is a directed graph

		// Add w to v's adjacency list
		adjacencyList.get(v).add(w);
	}

}
