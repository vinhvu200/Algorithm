import java.util.Stack;
import java.util.Iterator;

public class DFS {

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

	public void dfs(Graph graph, int s) {

		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[graph.V];

		visited[s] = true;
		stack.push(s);
		System.out.print(s + " ");

		while (!stack.empty()) {
		
			boolean visitFlag = false;
			int current = stack.peek();

			Iterator<Integer> i = graph.adj[current].listIterator();
			while (i.hasNext()) {
			
				int n = i.next();
				if (!visited[n]) {
				
					visited[n] = true;
					System.out.print(n + " ");
					stack.push(n);
					visitFlag = true;
					break;
				}
			}

			if (visitFlag == false)
				stack.pop();
		}
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
