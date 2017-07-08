// http://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/

public class Alternate {

	public ListNode alternate(ListNode head1, ListNode head2) {
	
		if (head1 == null && head2 == null)
			return null;
		if (head1 == null) {
		
			head2.display();
			return null;
		}
		if (head2 == null) {
		
			head1.display();
			return null;
		}

		ListNode a,b,c,d,head;
		a=head1; head=head1;
		b=head2;
		c=head1.next;
		d=head2.next;

		while (c != null && d != null) {
		
			a.next = b;
			b.next = c;
			a = c;
			b = d;
			c = c.next;
			d = d.next;
		}
		a.next = b;
		b.next = null;

		if (c != null) {

			System.out.print("Second List: ");
			c.display();
		}
		if (d != null){

			System.out.print("Second List: ");
			d.display();
		}

		return head;
	}

	public static void main(String[] args) {

		Alternate obj = new Alternate();

		ListNode h1 = new ListNode(5);
		h1.add(7);
		h1.add(17);
		h1.add(13);
		h1.add(11);
		System.out.print("List 1: ");
		h1.display();

		ListNode h2 = new ListNode(12);
		h2.add(10);
		h2.add(2);
		h2.add(4);
		//h2.add(6);
		System.out.print("List 2: ");
		h2.display();

		ListNode result = obj.alternate(h1,h2);
		System.out.print("Alternating List: ");
		result.display();
	}
}
