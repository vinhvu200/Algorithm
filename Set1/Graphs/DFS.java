import java.util.Stack;
import java.util.Iterator;

public class DFS {

	public void dfs(Graph graph, int s) {
	
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[graph.V];

		visited[s] = true;
		System.out.print(s + " ");

		stack.push(s);

		while (!stack.empty()) {
		
			boolean allVisited = true;

			int current = stack.peek();

			Iterator<Integer> i = graph.adj[current].listIterator();

			while (i.hasNext()) {
			
				int n = i.next();

				if (!visited[n]) {
				
					visited[n] = true;
					System.out.print(n + " ");
					stack.push(n);
					allVisited = false;
					break;
				}
			}

			if (allVisited)
				stack.pop();
		}
	}

	private void dfs2_util(Graph graph, int s, boolean[] visited) {
	
		visited[s] = true;
		System.out.print(s + " ");

		Iterator<Integer> i = graph.adj[s].listIterator();

		while (i.hasNext()) {
		
			int n = i.next();

			if (!visited[n])
				dfs2_util(graph, n, visited);
		}
	}

	public void dfs2(Graph graph, int s) {
	
		boolean[] visited = new boolean[graph.V];

		dfs2_util(graph, s, visited);
	}

	public static void main(String[] args) {

		Graph graph = new Graph(4);
		DFS obj = new DFS();

		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(1,2);
		graph.addEdge(2,0);
		graph.addEdge(2,3);
		graph.addEdge(3,3);

		obj.dfs(graph, 2);
		System.out.println();
		obj.dfs2(graph, 2);
		System.out.println();
	}
}
