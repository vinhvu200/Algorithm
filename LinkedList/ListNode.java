public class ListNode {

	int val;
	ListNode next;
	ListNode(int x) {val=x;}

	public void add(int num) {
	
		ListNode n = new ListNode(num);
		ListNode temp = this;
		while (temp.next != null)
			temp = temp.next;
		temp.next = n;
	}

	public void display() {
	
		ListNode temp = this;

		while (temp != null) {
		
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.print("x");
		System.out.println();
	}
}
