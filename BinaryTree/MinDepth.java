// http://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/

import java.util.Queue;
import java.util.LinkedList;

public class MinDepth {

	public int minDepth2(Node root) {
	
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;

		if (root.left == null)
			return minDepth2(root.right) + 1;
		if (root.right == null)
			return minDepth2(root.left) + 1;

		return Math.min(minDepth2(root.left),
						minDepth2(root.right)) + 1;
	}

	public int minDepth(Node root) {
	
		if (root == null)
			return 0;

		int count = 1;
		Queue<Node> q = new LinkedList<>();
		Node dummy = new Node(-1);
		q.add(root);
		q.add(dummy);

		while (!q.isEmpty()) {
		
			Node p = q.remove();
			if (p.data == -1) {
			
				count++;
				q.add(p);
			}
			else {
			
				if (p.left == null && p.right == null)
					break;

				if (p.left != null)
					q.add(p.left);
				if (p.right != null)
					q.add(p.right);
			}
		}
		return count;
	}

	public static void main(String[] args) {
	
		Node root = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);

		n2.left = n4;
		n2.right = n5;
		root.left = n2;
		root.right = n3;
		n3.left = n6;

		MinDepth obj = new MinDepth();
		System.out.println(obj.minDepth(root));
		System.out.println(obj.minDepth2(root));
	}
}
