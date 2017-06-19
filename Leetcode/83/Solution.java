public class Solution {

	public static ListNode deleteDuplicates(ListNode head) {
	
		ListNode current = head;

		while (current != null && current.next != null) {
		
			if (current.val == current.next.val)
				current.next = current.next.next;
			else
				current = current.next;
		}
		return head;
	}

	public static void main(String[] args){

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;

		ListNode temp = n1;
		while (temp != null) {
		
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();

		temp = deleteDuplicates(n1);

		while (temp != null) {
		
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
