public class CycleDetection {

	public boolean isCycle(Graph2 graph) {
	
		
		

		return false;
	}

	public static void main(String[] args) {

		int V = 3, E = 3;
		Graph2 graph = new Graph2(V,E);

		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

	}
}
