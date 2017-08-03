import java.util.ArrayList;

public class LCA {

	boolean findPath(Node root, ArrayList<Integer> path, int num) {
	
		if (root == null)
			return false;

		path.add(root.data);

		if (root.data == num)
			return true;

		if (root.left != null && findPath(root.left, path, num))
			return true;

		if (root.right != null && findPath(root.right, path, num))
			return true;

		path.remove(path.size()-1);

		return false;
	}

	public int lca2(Node root, int num1, int num2) {
	
		ArrayList<Integer> path1 = new ArrayList<>();
		ArrayList<Integer> path2 = new ArrayList<>();

		if (!findPath(root, path1, num1) || !findPath(root, path2, num2))
			return -1;

		int i;
		for (i=0; i<path1.size() && i<path2.size(); i++) {
		
			if (!path1.get(i).equals(path2.get(i)))
				break;
		}
		return path1.get(i-1);
	}

	private boolean traverse(Node root, int num1, int num2) {

		if (root == null)
			return false;

		if (root.data == num1 || root.data == num2)
			return true;

		boolean left = traverse(root.left, num1, num2);
		boolean right = traverse(root.right, num1, num2);

		return left || right;
	}

	public int lca(Node root, int num1, int num2) {
	
		// variable for integer leftFound and rightFound
		// traverse left, traverse right
		// conditions if left && root OR right && root return
		// else if left && right
		// if only left, traverse left
		// if only right traverse right

		boolean left, right;
		left = right = false;

		left = traverse(root.left, num1, num2);
		right = traverse(root.right, num1, num2);

		if (left && right || root.data == num1 || root.data == num2)
			return root.data;
		else if (left)
			return lca(root.left, num1, num2);
		else 
			return lca(root.right, num1, num2);
	}

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		LCA obj = new LCA();
		int num1=4, num2=5;
		int num3=4, num4=6;
		int num5=3, num6=4;
		int num7=2, num8=4;

		System.out.println(num1 + " : " + num2 + " -- " + obj.lca(n1, num1, num2));
		System.out.println(num3 + " : " + num4 + " -- " + obj.lca(n1, num3, num4));
		System.out.println(num5 + " : " + num6 + " -- " + obj.lca(n1, num5, num6));
		System.out.println(num7 + " : " + num8 + " -- " + obj.lca(n1, num7, num8));
		System.out.println();
		System.out.println(num1 + " : " + num2 + " -- " + obj.lca2(n1, num1, num2));
		System.out.println(num3 + " : " + num4 + " -- " + obj.lca2(n1, num3, num4));
		System.out.println(num5 + " : " + num6 + " -- " + obj.lca2(n1, num5, num6));
		System.out.println(num7 + " : " + num8 + " -- " + obj.lca2(n1, num7, num8));

	}
}
