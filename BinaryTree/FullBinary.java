// http://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not/

public class FullBinary {

	public boolean isFullBinary(Node root) {
	
		if (root == null)
			return true;

		boolean left = isFullBinary(root.left);
		boolean right = isFullBinary(root.right);

		if (root.right == null && root.left == null)
			return true;

		if (root.right == null || root.left == null)
			return false;

		return left && right;
	}

	public static void main(String[] args) {
	
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;

		FullBinary obj = new FullBinary();
		System.out.println(obj.isFullBinary(n1));
	}
}
