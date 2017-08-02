// http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/

public class LCA {

	public int findElement(Node root, int e1, int e2) {
	
		if (root == null)
			return 0;

		int left = findElement(root.left,e1,e2);
		int right = findElement(root.right,e1,e2);

		if (root.data == e1 || root.data == e2)
			return 1 + left + right;
		return left + right;
	}

	public int lca(Node root, int e1, int e2) {

		if (root == null)
			return -1;

		if (root.data == e1 || root.data == e2)
			return root.data;

		int left = findElement(root.left,e1,e2);
		int right = findElement(root.right,e1,e2);

		if (left == 1 && right == 1)
			return root.data;
		if (left == 2)
			return lca(root.left,e1,e2);
		return lca(root.right,e1,e2);
	}

	public static void main(String[] args) {

		Node n20 = new Node(20);
		Node n8 = new Node(8);
		Node n22 = new Node(22);
		Node n4 = new Node(4);
		Node n12 = new Node(12);
		Node n10 = new Node(10);
		Node n14 = new Node(14);

		n20.left = n8;
		n20.right = n22;
		n8.left = n4;
		n8.right = n12;
		n12.left = n10;
		n12.right = n14;

		LCA obj = new LCA();
		System.out.println(obj.lca(n20,10,14));
		System.out.println(obj.lca(n20,14,8));
		System.out.println(obj.lca(n20,10,22));
	}
}
