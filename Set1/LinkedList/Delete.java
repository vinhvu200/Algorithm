public class Delete {

	public ListNode delete(ListNode head, int num) {
	
		if (head == null)
			return null;
		if (head.next == null)
			return null;
		if (head.val == num)
			return head.next;

		ListNode temp = head;

		while (temp.next != null) {
		
			if (temp.next.val == num) {
			
				temp.next = temp.next.next;
				break;
			}
			temp = temp.next;
		}
		return head;
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(12);
		head.add(15);
		head.add(10);
		head.add(11);
		head.add(5);
		head.add(6);
		head.add(2);
		head.add(3);
		head.display();

		Delete obj = new Delete();
		System.out.println("Deleting 10");
		head = obj.delete(head,10);
		head.display();
		System.out.println("Deleting 12");
		head = obj.delete(head,12);
		head.display();
	}
}
