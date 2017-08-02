public class Dijkstra {

	public int min(int[] dist, boolean[] spt) {
	
		int min = Integer.MAX_VALUE;
		int min_index = -1;

		for (int i=0; i<dist.length; i++) {
		
			if (dist[i] <= min && !spt[i]){
				min = dist[i];
				min_index = i;
			}
		}
		return min_index;
	}

	public void dijkstra(Graph graph, int start) {

		int[] dist = new int[graph.V];
		boolean[] spt = new boolean[graph.V];

		for (int i=0; i<graph.V; i++) {
		
			dist[i] = Integer.MAX_VALUE;
			spt[i] = false;
		}

		dist[start] = 0;

		for (int i=0; i<graph.V-1; i++) {
		
			int u = min(dist, spt);

			spt[u] = true;

			for (int v=0; v<graph.V; v++) {
			
				if (!spt[v] && graph.weights[u][v] != 0 &&
					dist[u] != Integer.MAX_VALUE &&
					dist[u] + graph.weights[u][v] < dist[v]) {

					dist[v] = dist[u] + graph.weights[u][v];
				}
			}
		}

		for (int i=0; i<dist.length; i++)
			System.out.println(i + " : " + dist[i]);
	}

	public static void main(String[] args) {

		Dijkstra obj = new Dijkstra();
		int[][] weights = {{0,4,0,0,0,0,0,8,0},
							{4,0,8,0,0,0,0,11,0},
							{0,8,0,7,0,4,0,0,2},
							{0,0,7,0,9,14,0,0,0},
							{0,0,0,9,0,10,0,0,0},
							{0,0,4,14,10,0,2,0,0},
							{0,0,0,0,0,2,0,1,6},
							{8,11,0,0,0,0,1,0,7},
							{0,0,2,0,0,0,6,7,0}};

		Graph graph = new Graph(9,weights);
		obj.dijkstra(graph, 0);
	}
}
