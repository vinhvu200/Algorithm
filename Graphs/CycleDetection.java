// http://www.geeksforgeeks.org/union-find/

public class CycleDetection {

	public boolean isCycle(Graph2 graph) {
	
		int[] parent = new int[graph.V];

		for (int i=0; i<graph.V; i++)
			parent[i] = -1;

		for (int i=0; i<graph.E; i++) {
		
			int x = graph.find(parent, graph.edges[i].src);
			int y = graph.find(parent, graph.edges[i].dest);

			if (x == y)
				return true;

			graph.union(parent, x, y);
		}
		

		return false;
	}

	public static void main(String[] args) {

		int V = 3, E = 3;
		Graph2 graph = new Graph2(V,E);
		CycleDetection obj = new CycleDetection();

		graph.edges[0].src = 0;
		graph.edges[0].dest = 1;

		graph.edges[1].src = 1;
		graph.edges[1].dest = 2;

		graph.edges[2].src = 0;
		graph.edges[2].dest = 2;

		System.out.println(obj.isCycle(graph));
	}
}
