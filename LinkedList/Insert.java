// http://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
public class Insert {

	public ListNode insert(ListNode head, int num) {
	
		ListNode n = new ListNode(num);

		if (head == null)
			return n;
		if (num < head.val) {
		
			n.next = head;
			return n;
		}

		ListNode temp = head;

		while (temp != null) {
		
			if (temp.next != null && num > temp.val) {
			
				n.next = temp.next;
				temp.next = n;
				break;
			}
			else
				temp.next = n;
			temp = temp.next;
		}
		return head;
	}

	public static void main(String[] args) {
	
		Insert obj = new Insert();
		ListNode head = new ListNode(2);
		head.add(5);
		head.add(7);
		head.add(10);
		head.add(15);
		head.display();

		head = obj.insert(head,9);
		head.display();
	}
}
