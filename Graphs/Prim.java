public class Prim {

	private int minimum(int[] key, boolean[] mstSet) {
	
		int min = Integer.MAX_VALUE;
		int min_index = -1;

		for (int i=0; i<key.length; i++) {
		
			if (mstSet[i] == false &&
				key[i] < min) {
			
				min = key[i];
				min_index = i;
			}
		}
		return min_index;
	}

	private void print(int[] parent, int[] key) {
	
		for (int i=1; i<key.length; i++) {
		
			System.out.println(parent[i] + " - " + i + " : " + key[i]);
		}
	}

	public void prim(Graph graph) {
	
		int[] parent = new int[graph.V];
		int[] key = new int[graph.V];
		boolean[] mstSet = new boolean[graph.V];

		for (int i=0; i<graph.V; i++) {
		
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0;
		
		for (int i=0; i<graph.V-1; i++) {
		
			int u = minimum(key, mstSet);

			mstSet[u] = true;

			for (int v=0; v<graph.V; v++) {
			
				if (mstSet[v] == false &&
					graph.weights[u][v] != 0 &&
					graph.weights[u][v] < key[v]) {

					parent[v] = u;
					key[v] = graph.weights[u][v];
				}
			}
		}

		print(parent, key);
	}

	public static void main(String[] args) {

		Prim obj = new Prim();
		int[][] weights = { {0, 2, 0, 6, 0},
							{2, 0, 3, 8, 5},
							{0, 3, 0, 0, 7},
							{6, 8, 0, 0, 9},
							{0, 5, 7, 9, 0} };

		Graph graph = new Graph(5, weights);
		obj.prim(graph);
	}
}
