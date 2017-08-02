// http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/

public class Reverse {

	public ListNode reverse(ListNode head, int k) {
	
		if (head == null)
			return null;

		ListNode prev,curr,next;
		int count=0;

		curr=head;
		prev=null;
		next=null;
		
		while(count<k && curr!=null) {
		
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (curr != null)
			head.next = reverse(curr,k);
		return prev;
	}

	public static void main(String[] args) {

		ListNode h1 = new ListNode(1);
		h1.add(2);
		h1.add(3);
		h1.add(4);
		h1.add(5);
		h1.add(6);
		h1.add(7);
		h1.add(8);
		System.out.print("List: ");
		h1.display();

		int k=3;
		System.out.println("k : " + k);
		System.out.print("Result: ");
		Reverse obj = new Reverse();
		obj.reverse(h1,k).display();
	}
}
