public class AddNumber {

	public ListNode reverse(ListNode head) {
	
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode prev, curr, after;
		prev = null;
		curr = head;
		after = head.next;

		while (after != null) {
		
			curr.next = prev;
			prev = curr;
			curr = after;
			after = after.next;
		}
		curr.next = prev;
		return curr;
	}

	public ListNode addition(ListNode head1, ListNode head2) {
	
		if (head1 == null && head2 == null)
			return null;
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		ListNode result = new ListNode();
		ListNode temp1, temp2;
		temp1 = reverse(head1);
		temp2 = reverse(head2);
		int carry = 0;

		while (temp1 != null || temp2 != null) {
		
			int sum = temp1.val + temp2.val + carry;
			carry = sum/10;
			sum = sum%10;
			result.add(sum);
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		while (temp1 != null) {
		
			int sum = temp1.val+carry;
			carry = sum/10;
			sum = sum%10;
			result.add(sum);
			temp1 = temp1.next;
		}

		while (temp2 != null) {
		
			int sum = temp2.val+carry;
			carry = sum/10;
			sum = sum%10;
			result.add(sum);
			temp2 = temp2.next;
		}

		if (carry > 0)
			result.add(carry);

		return reverse(result);
	}

	public static void main(String[] args) {

		ListNode head1 = new ListNode(5);
		head1.add(6);
		head1.add(3);
		ListNode head2 = new ListNode(8);
		head2.add(4);
		head2.add(2);

		head1.display();
		head2.display();

		AddNumber obj = new AddNumber();
		obj.addition(head1,head2).display();
	}
}
