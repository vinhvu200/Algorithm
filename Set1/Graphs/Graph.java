import java.util.LinkedList;

public class Graph {

	int V;
    LinkedList<Integer> adj[];
	int[][] weights;

	Graph(int v) {
	
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; i++)
			adj[i] = new LinkedList();
	}

	Graph(int v, int[][] w) {

		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; i++)
			adj[i] = new LinkedList();

		weights = w;
	}

	public void addEdge(int vertex1, int vertex2) {

		adj[vertex1].add(vertex2);
	}
}
