public class LoopDetection {

	public int loopDetection(Node head) {
	
		// have fast and slow pointer
		// If they meet, then loop exists
		// If loop exists, move one pointer to front
		// loop one by one with both pointers
		// When they meet, the loop begins there

		Node slow, fast;
		slow = fast = head;

		while (fast != null) {
		
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
			slow = slow.next;

			if (fast.data == slow.data)
				break;
		}
		if (fast == null)
			return -1;

		fast = head;
		while (fast.data != slow.data) {
		
			fast = fast.next;
			slow = slow.next;
		}
		return slow.data;
	}

	public static void main(String[] args) {

		LoopDetection obj = new LoopDetection();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;

		System.out.println(obj.loopDetection(n1));
	}
}
