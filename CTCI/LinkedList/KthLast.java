public class KthLast {

	public int kth(Node head, int k) {
	
		// Two pointers to head
		// Have second move forward k amount of time
		// Once set, move both pointers together until
		// second reaches null

		Node temp1, temp2;
		temp1 = temp2 = head;
		int count = 0;

		while (count < k) {
		
			temp2 = temp2.next;
			count++;
		}

		while (temp2 != null) {
		
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		return temp1.data;
	}

	public static void main(String[] args) {

		Node head = new Node(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);
		head.add(6);
		head.add(7);
		head.print();

		KthLast obj = new KthLast();
		System.out.println(obj.kth(head, 1));
		System.out.println(obj.kth(head, 3));
		System.out.println(obj.kth(head, 5));
		System.out.println(obj.kth(head, 7));
	}
}
