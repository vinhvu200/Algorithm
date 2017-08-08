public class Partition {

	public Node partition(Node head, int x) {
	
		// Two list, one for left, one for right
		// Go through head and connect to left if < x
		// Connect right if > x
		// Connect left and right afterward
		// If left doesn't exist, return right
		// Make pointer to keep track of beginning of
		// left and right

		Node left, right, leftStart, rightStart, temp;
		left = right = leftStart = rightStart = null;
		temp = head;

		while (temp != null) {
		
			if (temp.data < x) {
			
				if (left == null) {
				
					left = temp;
					leftStart = left;
				}
				else {
					left.next = temp;
					left = left.next;
				}
			}
			else {
			
				if (right == null) {
				
					right = temp;
					rightStart = right;
				}
				else {
					right.next = temp;
					right = right.next;
				}
			}
			temp = temp.next;
		}

		if (rightStart != null)
			right.next = null;
		if (leftStart != null)
			left.next = null;

		if (leftStart == null) 
			return rightStart;

		left.next = rightStart;
		return leftStart;
	}

	public static void main(String[] args) {

		Node head = new Node(3);
		head.add(5);
		head.add(8);
		head.add(5);
		head.add(10);
		head.add(2);
		head.add(1);
		head.print();

		Partition obj = new Partition();
		obj.partition(head, 5).print();

	}
}
