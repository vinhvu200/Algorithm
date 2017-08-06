public class Node {

	int data;
	Node next;

	Node (int data) {
	
		this.data = data;
		next = null;
	}

	public void print() {
	
		Node temp = this;
		while (temp != null) {
		
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void add(int n) {
	
		Node temp = this;
		while (temp.next != null) {
		
			temp = temp.next;
		}
		Node newNode = new Node(n);
		temp.next = newNode;
	}
}
