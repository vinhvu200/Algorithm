public class DeleteMiddle {

	public void deleteMiddle(Node head) {
	
		// Make second pointer go at double speed
		// Make first pointer go at normal speed
		// check for .next != null

		Node fast, slow;
		fast = slow = head;

		while (fast.next != null) {
		
			fast = fast.next;
			if (fast.next != null)
				fast = fast.next;

			if (fast.next == null) {
			
				slow.next = slow.next.next;
				break;
			}
			slow = slow.next;
		}

	}

	public static void main(String[] args) {

		Node head = new Node(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);
		head.print();

		DeleteMiddle obj = new DeleteMiddle();
		obj.deleteMiddle(head);
		head.print();
	}
}
