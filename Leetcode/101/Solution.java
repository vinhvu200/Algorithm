import java.util.Queue;
import java.util.LinkedList;

public class Solution {

	public static boolean isMirror(TreeNode node1, TreeNode node2) {
	
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;
		return (node1.val == node2.val) 
			&& isMirror(node1.left, node2.right)
			&& isMirror(node1.right, node2.left);
	}

	public static boolean isSymmetric2(TreeNode root) {

		return isMirror(root, root);
	}

	public static boolean isSymmetric(TreeNode root) {
	
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		TreeNode n1, n2;

		while (!q.isEmpty()) {
		
			n1 = q.poll();
			n2 = q.poll();

			if (n1 == null && n2 == null)
				continue;
			else
				if (n1 == null || n2 == null)
					return false;

			if (n1.val != n2.val)
				return false;

			q.add(n1.left);
			q.add(n2.right);
			q.add(n1.right);
			q.add(n2.left);
		}
		return true;
	}

	public static void main(String[] args) {
	
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(3);

		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		n4.left = null; n4.right = null;
		n5.left = null; n5.right = null;
		n6.left = null; n6.right = null;
		n7.left = null; n7.right = null;

		System.out.println("Method 1 : " + isSymmetric(n1));
		System.out.println("Method 2 : " + isSymmetric2(n1));
	}
}
