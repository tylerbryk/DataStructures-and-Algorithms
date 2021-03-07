package GraphTheory;

import java.util.*;

public class GraphList {
	
    private int V;
    private ArrayList<LinkedList<Edge>> edges;
    
    private static class Edge {
        int dest;
	double w;
	public Edge(int dest, double w) { 
            this.dest = dest; 
            this.w = w; 
        }
    }
    
    public GraphList(int V) {
	this.V = V;
	edges = new ArrayList<>(V);
	for (int i = 0; i < V; i++)
            edges.add(new LinkedList<>());
    }
	
    public void set(int src, int dest, double w) {
	LinkedList<Edge> srcEdges = edges.get(src);
	for (Edge e : srcEdges)
            if (e.dest == dest) {
		e.w = w;
		return;
            }
	srcEdges.add(new Edge(dest, w));
    }

    public double get(int src, int dest) {
	for (Edge e : edges.get(src))
            if (e.dest == dest)
		return e.w;
        return Double.POSITIVE_INFINITY;
    }
    
    public boolean isAdjacent(int src, int dest) {
        LinkedList<Edge> list = edges.get(src);
        for (Edge e : list)
            if (e.dest == dest)
                return true;
        return false;
    }
    
    public void allAdjacent(int src) {
        LinkedList<Edge> list = edges.get(src);
        for (Edge e : list)
            System.out.print(e.dest + " ");
        System.out.println();
    }
	
    public void DFS(int v) {
	boolean[] visited = new boolean[V];
        DFSR(v, visited);
    }
    private void DFSR(int v, boolean[] visited) {
        visited[v] = true;
	System.out.print(v);
	for (Edge e : edges.get(v))
            if (!visited[e.dest])
		DFSR(e.dest, visited);
    }
	
    public void iterativeDFS(int v) {
	boolean[] visited = new boolean[V];
	Stack<Integer> todo = new Stack<>();
        visited[v] = true;
        todo.push(v);
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
        boolean[] visited = new boolean[V];
        Queue<Integer> todo = new LinkedList();
        visited[v] = true;
        todo.add(v);
        while (!todo.isEmpty()) {
            int currentV = todo.remove();
            System.out.print(currentV + " ");
            LinkedList<Edge> adjacent = edges.get(currentV);
            for (Edge e : adjacent) {
                if (!visited[e.dest]) {
                    todo.add(e.dest);
                    visited[e.dest] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphList gl = new GraphList(5);
	gl.set(0, 1, 1.5);
	gl.set(1, 2, 2.0);
	gl.set(2, 3, 2.5);
        gl.set(2, 4, 1.0);
	gl.set(3, 4, 3.0);
	gl.DFS(0);
        System.out.println();
        gl.BFS(0);
    }
}