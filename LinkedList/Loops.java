// http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/

public class Loops {

	public boolean hasLoop(ListNode head) {
	
		ListNode x,y;
		x=head;
		y=head;

		while (y != null) {
		
			y = y.next;
			if(y == null)
				return false;
			y = y.next;
			if (y == null)
				return false;
			x = x.next;
			if (x == y)
				return true;
		}
		return false;
	}

	public void removeLoop(ListNode head) {
	
		ListNode x,y;
		x=y=head;

		while (y != null) {
		
			y=y.next;
			if (y == null)
				return;
			y=y.next;
			if (y == null)
				return;
			x=x.next;
			if (x==y)
				break;
		}
		x=head;
		
		while (x != y) {

			x=x.next;
			y=y.next;
		}

		while (x.next != y) 
			x=x.next;
		x.next=null;
	}

	public static void main(String[] args) {

		Loops obj = new Loops();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n2;

		System.out.println(obj.hasLoop(n1));
		obj.removeLoop(n1);
		n1.display();
	}
}
