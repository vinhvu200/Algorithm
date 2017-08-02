// http://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/

public class ShortestPathNode {

	public Node shortestPathNode(Node root, int length, int k) {
	
		if (root == null)
			return null;

		root.left = shortestPathNode(root.left, length+1, k);
		root.right = shortestPathNode(root.right, length+1, k);

		if (root.left == null && root.right == null && length < k)
			return null;

		return root;
	}

	public void printInOrder(Node root) {
	
		if (root == null)
			return;

		printInOrder(root.left);
		printInOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {
	
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n7;
		n3.right = n6;
		n6.left = n8;

		int k = 4;

		ShortestPathNode obj = new ShortestPathNode();

		obj.printInOrder(n1);
		System.out.println();
		obj.printInOrder(obj.shortestPathNode(n1, 1, k));
		System.out.println();
	}
}
