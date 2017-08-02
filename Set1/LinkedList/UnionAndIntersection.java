// http://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/

import java.util.HashSet;

public class UnionAndIntersection {

	public void union(ListNode head1, ListNode head2) {

		ListNode temp1, temp2, ref, ref2, result1, result2;
		HashSet<Integer> set = new HashSet<>();
		temp1 = head1;
		temp2 = head2;
		ref = null; ref2 = null; result1 = null; result2 = null;

		while (temp1 != null) {
		
			if (!set.contains(temp1.val)) {
			
				if (result1 == null) {
				
					result1 = temp1;
					ref = result1;
				}
				else {
				
					result1.next = temp1;
					result1 = result1.next;
				}
			}
			else {
			
				if (result2 == null) {
				
					result2 = temp1;
					ref2 = result2;
				}
				else {
				
					result2.next = temp1;
					result2 = result2.next;
				}
			}
			set.add(temp1.val);
			temp1 = temp1.next;
		}

		while (temp2 != null) {
		
			if (!set.contains(temp2.val)) {
			
				if (result1 == null) {
				
					result1 = temp2;
					ref = result1;
				}
				else {
				
					result1.next = temp2;
					result1 = result1.next;
				}
				//set.add(temp2.val);
			}
			else {
			
				if (result2 == null) {
				
					result2 = temp2;
					ref2 = result2;
				}
				else {
				
					result2.next = temp2;
					result2 = result2.next;
				}
			}
			set.add(temp2.val);
			temp2 = temp2.next;
		}

		if (result1 != null)
			result1.next = null;
		if (result2 != null)
			result2.next = null;
		System.out.print("Union: ");
		ref.display();
		System.out.print("Intersection: ");
		ref2.display();
	}

	public static void main(String[] args) {

		ListNode h1 = new ListNode(10);
		h1.add(15);
		h1.add(4);
		h1.add(20);
		System.out.print("List 1: ");
		h1.display();

		ListNode h2 = new ListNode(8);
		h2.add(4);
		h2.add(2);
		h2.add(10);
		System.out.print("List 2: ");
		h2.display();

		UnionAndIntersection obj = new UnionAndIntersection();
		obj.union(h1,h2);
	}
}
