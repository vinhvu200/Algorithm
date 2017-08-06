import java.util.HashMap;

public class RemoveDuplicate {

	public Node removeDup2 (Node head) {
	
		// Double while loop
		// First loop contains number to be searched
		// Second loop checks rest of list and deletes if it exists

		Node temp = head;
		Node temp2 = null;

		while (temp != null) {
		
			int num = temp.data;
			temp2 = temp;
			while (temp2.next != null) {
			
				if (temp2.next.data == num) {
				
					temp2.next = temp2.next.next;
				}
				if (temp2.next != null)
					temp2 = temp2.next;
			}
			temp = temp.next;
		}

		return head;
	}

	public Node removeDup (Node head) {
	
		if (head == null)
			return null;

		HashMap<Integer, Integer> map = new HashMap<>();
		Node temp = head;

		while (temp != null) {
		
			if (!map.containsKey(temp.data)) {
			
				map.put(temp.data, 1);
			}
			else {
			
				int num = map.get(temp.data);
				map.put(temp.data, num+1);
			}
			temp = temp.next;
		}

		temp = head;
		while (temp.next != null) {
		
			int num = map.get(temp.next.data);
			if (num > 1) {
				
				map.put(temp.next.data, num-1);
				temp.next = temp.next.next;
			}
			
			if (temp.next != null)
				temp = temp.next;
		}

		return head;
	}

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(3);
		Node n3 = new Node(5);
		Node n4 = new Node(3);
		Node n5 = new Node(2);
		Node n6 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		n1.print();

		RemoveDuplicate obj = new RemoveDuplicate();
		//obj.removeDup(n1).print();
		obj.removeDup2(n1).print();
	}
}
