// http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/

public class MaxPathSum {

	public int maxPathSum(Node root, Node res) {
	
		if (root == null)
			return 0;

		int left = maxPathSum(root.left, res);
		int right = maxPathSum(root.right, res);

		int maxLeft = left + root.data;
		int maxRight = right + root.data;
		int maxLeftRight = left + right + root.data;
		int singular = root.data;

		int max = Math.max( Math.max(maxLeft,maxRight),
							Math.max(maxLeftRight,singular));

		res.data = Math.max(res.data, max);

		return Math.max(Math.max(maxLeft,maxRight),root.data);
	}

	public static void main(String[] args) {

		Node n1 = new Node(10);
		Node n2 = new Node(2);
		Node n3 = new Node(10);
		Node n4 = new Node(20);
		Node n5 = new Node(1);
		Node n6 = new Node(-25);
		Node n7 = new Node(3);
		Node n8 = new Node(4);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		n6.left = n7;
		n6.right = n8;

		Node res = new Node(-1000);

		MaxPathSum obj = new MaxPathSum();
		obj.maxPathSum(n1,res);
		System.out.println(res.data);
	}
}
