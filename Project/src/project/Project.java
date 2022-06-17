
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;
import java.io.*;
import java.util.*;
import java.util.List;

public class Project {
    public static void main(String[] args) {
        int I = Integer.MAX_VALUE;
        int[][] adjMatrix = new int[][]
        {
            { 0, 10, 13, 17,17,13,5,7,18,21 },
            { I, 0, 3, 7,3,I,I,5,8,11 },
            {5,4,0,I,5,3,4,I,12,6},
            { I, 10, 13, 0,17,13,5,7,18,21 },
            { I, 0, 3, 7,0,I,I,5,8,11 },
            {I,4,0,I,5,0,4,I,12,6},
            { I, 10, 13, 17,17,13,0,7,18,21 },
            { I, 0, 3, 7,3,I,I,0,8,11 },
            {I,4,0,I,5,3,4,I,0,6},
            { I, 0, 3, 7,3,I,I,5,8,0 },
        };
        fmClass.floydWarshall(adjMatrix);
        DijkstraAlg l = new DijkstraAlg() ;
       l.DijkstraAlg(adjMatrix,01);
        
        //start time
        double startTime = System.currentTimeMillis();
        GFGRandomGraph randomGraph = new GFGRandomGraph();
		System.out.println("The generated random graph :");
		for (int i = 0;
			i < randomGraph.adjacencyList.size(); i++) {
			System.out.print(i + " -> { ");

			List<Integer> list
				= randomGraph.adjacencyList.get(i);

			if (list.isEmpty())
				System.out.print(" No adjacent vertices ");
			else {
				int size = list.size();
				for (int j = 0; j < size; j++) {

					System.out.print(list.get(j));
					if (j < size - 1)
						System.out.print(" , ");
				}
			}

			System.out.println("}");
		}
                 
                
                
                //finish time of the algorithm
        double ftime = System.currentTimeMillis();
        //print the total time consumed by the algorithm
        System.out.println("Total runtime : " + (ftime - startTime) + " ms.");
    
    }
    

    
    
    }
