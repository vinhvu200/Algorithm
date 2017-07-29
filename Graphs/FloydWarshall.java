public class FloydWarshall {

	static final int INF = 99999;

	public void floydWarshall(Graph graph) {

		int[][] dist = new int[graph.V][graph.V];

		for (int i=0; i<graph.V; i++)
			for (int j=0; j<graph.V; j++)
				dist[i][j] = graph.weights[i][j];

		for (int k=0; k<graph.V; k++)
			for (int i=0; i<graph.V; i++)
				for (int j=0; j<graph.V; j++) {
				
					if (graph.weights[i][k] + graph.weights[k][j] < dist[i][j])
						dist[i][j] = graph.weights[i][k] + graph.weights[k][j];
				}

		for (int i=0; i<graph.V; i++) {
			for (int j=0; j<graph.V; j++) {
			
				if (dist[i][j] == INF)
					System.out.print("x ");
				else
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		FloydWarshall obj = new FloydWarshall();

		int[][] weight = {{0,5,INF,10},
							{INF,0,3,INF},
							{INF,INF,0,1},
							{INF,INF,INF,0}};

		Graph graph = new Graph(4,weight);
		obj.floydWarshall(graph);
	}
}
