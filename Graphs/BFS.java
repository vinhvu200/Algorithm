import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;

public class BFS {


	public void bfs(Graph graph, int start) {
	
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.V];

		visited[start] = true;

		queue.add(start);

		while (queue.size() != 0) {

			int current = queue.poll();
			System.out.print(current + " ");

			Iterator<Integer> i = graph.adj[current].listIterator();

			while (i.hasNext()) {
		
				int n = i.next();
				if (!visited[n]) {
				
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Graph graph = new Graph(4);
		BFS obj = new BFS();

		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(1,2);
		graph.addEdge(2,0);
		graph.addEdge(2,3);
		graph.addEdge(3,3);
		
		obj.bfs(graph, 2);
	}
}
