public class Solution {

	// Run time : O(n) where n is number of nodes
	// Space : O(1)
	// Leaves two pointer behind to keep
	// track of when to delete
	public static ListNode removeNthFromEnd(ListNode head, int n) {
	
		if (head == null)
			return null;

		ListNode p=head, t=head, s=null;
		int i=0;

		while (i<n){
			p = p.next;
			i++;
		}

		while (p != null) {
		
			t = t.next;
			p = p.next;
			if (s == null) { s = head; }
			else { s = s.next; }
		}

		if (s == null) {
		
			t = t.next;
			return t;
		}
		else
			s.next = t.next;

		return head;
	}

	public static void main(String[] args) {
	
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		ListNode temp = n1;

		System.out.println(removeNthFromEnd(temp, 1).val);
	}
}
