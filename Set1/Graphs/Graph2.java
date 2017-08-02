public class Graph2 {

	class Edge {
	
		int src;
		int dest;
	}

	int V, E;
	Edge[] edges;

	Graph2(int v, int e) {
	
		V = v;
		E = e;
		edges = new Edge[E];
		for (int i=0; i<E; i++)
			edges[i] = new Edge();
	}

	int find(int[] parent, int i) {
	
		if (parent[i] == -1)
			return i;

		return find(parent, parent[i]);
	}

	void union(int[] parent, int x, int y) {
	
		int xset = find(parent, x);
		int yset = find(parent, y);

		parent[xset] = yset;
	}
}
