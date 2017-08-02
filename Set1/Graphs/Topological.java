import java.util.Stack;
import java.util.Iterator;

public class Topological {

	private void topological_util(Graph graph, Stack<Integer> stack, boolean[] visited, int current) {
	
		visited[current] = true;
		Iterator<Integer> i = graph.adj[current].listIterator();

		while (i.hasNext()) {
		
			int n = i.next();
			if (!visited[n])
				topological_util(graph, stack, visited, n);
		}
		stack.push(current);
	}

	public void topological(Graph graph) {
	
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[graph.V];

		for (int i=0; i<graph.V; i++)
			visited[i] = false;

		for (int i=0; i<graph.V; i++)
			if (!visited[i])
				topological_util(graph, stack, visited, i);

		while (!stack.empty())
			System.out.print(stack.pop() + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		Topological obj = new Topological();
		Graph graph = new Graph(6);
		graph.addEdge(5,2);
		graph.addEdge(5,0);
		graph.addEdge(4,0);
		graph.addEdge(4,1);
		graph.addEdge(2,3);
		graph.addEdge(3,1);

		obj.topological(graph);
	}
}
