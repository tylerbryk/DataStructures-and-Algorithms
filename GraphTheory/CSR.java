package GraphTheory;

import java.io.File;
import java.util.*;

public class CSR {
    
    private int V = 5;
    private static ArrayList<LinkedList<Edge>> edges;
    
    private static class Edge {
        int dest;
	double w;
	public Edge(int dest, double w) { 
            this.dest = dest; 
            this.w = w; 
        }
    }
    
    public CSR (File file) throws Exception {
        Scanner s = new Scanner(file);
        edges = new ArrayList(V);
        for (int i = 0; i < V; i++)
            edges.add(new LinkedList<>());
        while (s.hasNext()) {
            int from = s.nextInt();
            int to = s.nextInt();
            double w = s.nextDouble();
            edges.get(from).add(new Edge(to,w));
        }
    }
    
    public void DFS(int v) {
        boolean[] visited = new boolean[V];
	Stack<Integer> todo = new Stack<>();
        todo.push(v);
	visited[v] = true;
	while (!todo.isEmpty()) {
            int currentV = todo.pop();
            System.out.print(currentV + " ");
            LinkedList<Edge> adjacent = edges.get(currentV);
            for (Edge e : adjacent)
		if (!visited[e.dest]) {
                    todo.push(e.dest);
                    visited[e.dest] = true;
                }
	}
    }
    
    public void BFS(int v) {
        
    }
    
    public void floydWarshall(float[] cost) {
        
    }
    
    public String toString() {
        return null;
    }
    
    public static void main(String[] args) throws Exception {
        CSR csr = new CSR(new File("hwgraph.dat"));
        csr.DFS(0);     // (0,1,2,4,3,5)
        /*csr.BFS(0);     // (0,1,3,2,4,5)
        
        float[] dist = new float[6*6];
        csr.floydWarshall(dist);
        
        int c = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++)
                System.out.print(dist[c++] + " ");
            System.out.println();
        }*/
    }
}
