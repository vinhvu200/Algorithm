// http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/

public class Subtree {

	public boolean compare(Node root1, Node root2) {
	
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		if (root1.data != root2.data)
			return false;

		boolean left = compare(root1.left, root2.left);
		boolean right = compare(root1.right, root2.right);

		return left && right;
	}

	public boolean subtree(Node root1, Node root2) {
	
		if (root1 == null && root2 == null)
			return true;
		if (root2 == null)
			return false;

		if (compare(root1,root2))
			return true;

		boolean left = subtree(root1,root2.left);
		boolean right = subtree(root1,root2.right);

		return left || right;
	}

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);

		n5.left = n1;
		n5.right = n6;
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n6.right = n7;

		Node _n1 = new Node(1);
		Node _n2 = new Node(2);
		Node _n3 = new Node(3);
		Node _n4 = new Node(4);
		Node _n5 = new Node(5);

		_n1.left = _n2;
		_n1.right = _n3;
		_n2.right = _n4;

		Subtree obj = new Subtree();
		System.out.println(obj.subtree(n1,_n1));
	}
}
