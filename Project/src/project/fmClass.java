package project;

import java.util.ArrayList;
import java.util.List;

class fmClass
{
    // Recursive function to print path of given vertex `u` from source vertex `v`
    private static void printPath(int[][] path, int v, int u, List<Integer> route)
    {
        if (path[v][u] == v) {
            return;
        }
        printPath(path, v, path[v][u], route);
        route.add(path[v][u]);
    }
 
    // Function to print the shortest cost with path information between
    // all pairs of vertices
    private static void printSolution(int[][] path, int n)
    {
        for (int v = 0; v < n; v++)
        {
            for (int u = 0; u < n; u++)
            {
                if (u != v && path[v][u] != -1)
                {
                    List<Integer> route = new ArrayList<>();
                    route.add(v);
                    printPath(path, v, u, route);
                    route.add(u);
                    System.out.printf("The shortest path from %d —> %d is %s\n",
                        v, u, route);
                }
            }
        }
    }
 
    // Function to run the Floyd–Warshall algorithm
    public static void floydWarshall(int[][] adjMatrix)
    {
        // base case
        if (adjMatrix ==null || adjMatrix.length == 0) {
            return;
        }
 
        // total number of vertices in the `adjMatrix`
        int n = adjMatrix.length;
 
        // cost[] and path[] stores shortest path
        // (shortest cost/shortest route) information
        int[][] cost = new int[n][n];
        int[][] path = new int[n][n];
 
        // initialize cost[] and path[]
        for (int v = 0; v < n; v++)
        {
            for (int u = 0; u < n; u++)
            {
                // initially, cost would be the same as the weight of the edge
                cost[v][u] = adjMatrix[v][u];
 
                if (v == u) {
                    path[v][u] = 0;
                }
                else if (cost[v][u] != Integer.MAX_VALUE) {
                    path[v][u] = v;
                }
                else {
                    path[v][u] = -1;
                }
            }
        }
 
        // run Floyd–Warshall
        for (int k = 0; k < n; k++)
        {
            for (int v = 0; v < n; v++)
            {
                for (int u = 0; u < n; u++)
                {
                    // If vertex `k` is on the shortest path from `v` to `u`,
                    // then update the value of cost[v][u] and path[v][u]
 
                    if (cost[v][k] != Integer.MAX_VALUE
                            && cost[k][u] != Integer.MAX_VALUE
                            && (cost[v][k] + cost[k][u] < cost[v][u]))
                    {
                        cost[v][u] = cost[v][k] + cost[k][u];
                        path[v][u] = path[k][u];
                    }
                }
                if (cost[v][v] < 0)
                {
                    System.out.println("Negative-weight cycle found!!");
                    return;
                }
            }
        }
        printSolution(path, n);
    }
}
