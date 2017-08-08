import java.util.HashSet;

public class Intersection {

	public Node intersection(Node head1, Node head2) {
	
		// Go through first head and store it into hashmap
		// Go through second head and check if inside hashset
		// If it is, create new node for Result
		// If not, then continue

		Node temp1 = head1;
		Node temp2 = head2;
		Node result = null;
		Node resultBegin = null;
		HashSet<Integer> map = new HashSet<>();

		while (temp1 != null) {
		
			map.add(temp1.data);
			temp1 = temp1.next;
		}

		while (temp2 != null) {
		
			if (map.contains(temp2.data)) {
			
				if (result == null) {
					result = new Node(temp2.data);
					resultBegin = result;
				}
				else {

					result.next = new Node(temp2.data);
					result = result.next;
				}
				map.remove(temp2.data);
			}
			temp2 = temp2.next;
		}

		return resultBegin;
	}

	public static void main(String[] args) {

		Node head1 = new Node(1);
		head1.add(2);
		head1.add(5);
		head1.add(7);
		head1.add(2);
		head1.add(4);

		Node head2 = new Node(2);
		head2.add(3);
		head2.add(6);
		head2.add(1);
		head2.add(4);
		
		head1.print();
		head2.print();

		Intersection obj = new Intersection();
		obj.intersection(head1, head2).print();
	}
}
