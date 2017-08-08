public class Sum {

	public Node sum (Node head1, Node head2) {
	
		Node temp1, temp2, result, start;
		temp1 = head1;
		temp2 = head2;
		result = null;
		start = null;
		int carry = 0;

		while (temp1 != null && temp2 != null) {
		
			int total = temp1.data + temp2.data + carry;
			int sum = total % 10;
			carry = total / 10;

			if (result == null) {
				result = new Node(sum);
				start = result;
			}
			else {
				result.next = new Node(sum);
				result = result.next;
			}

			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		while (temp1 != null) {
		
			int total = temp1.data + carry;
			int sum = total % 10;
			carry = total / 10;

			result.next = new Node(sum);
		}
		while (temp2 != null) {
		
			int total = temp2.data + carry;
			int sum = total % 10;
			carry = total / 10;

			result.next = new Node(sum);
		}

		if (carry == 1)
			result.next = new Node(carry);

		return start;
	}

	public static void main(String[] args) {

		Node head1 = new Node(7);
		head1.add(1);
		head1.add(6);

		Node head2 = new Node(5);
		head2.add(9);
		head2.add(2);

		head1.print();
		head2.print();

		Sum obj = new Sum();
		obj.sum(head1, head2).print();
	}
}
