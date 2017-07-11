// http://www.geeksforgeeks.org/merge-sort-for-linked-list/

public class MergeSort {

	public ListNode merge(ListNode head1, ListNode head2) {
	
		if (head1 == null && head2 == null)
			return null;
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		ListNode merged, merged_ref;

		if (head1.val < head2.val) {
		
			merged = head1;
			head1 = head1.next;
		}
		else {
		
			merged = head2;
			head2 = head2.next;
		}
		merged_ref = merged;

		while (head1 != null && head2 != null) {
		
			if (head1.val < head2.val) {
			
				merged.next = head1;
				head1 = head1.next;
			}
			else {
			
				merged.next = head2;
				head2 = head2.next;
			}
			merged = merged.next;
		}

		while (head1 != null) {
		
			merged.next = head1;
			head1 = head1.next;
			merged = merged.next;
		}

		while (head2 != null) {
		
			merged.next = head2;
			head2 = head2.next;
			merged = merged.next;
		}
		merged.next = null;
		return merged_ref;
	}

	private ListNode getMiddle(ListNode head) {
	
		if (head == null)
			return null;

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null) {
		
			fast = fast.next;
			if (fast != null) {
			
				slow = slow.next;
				fast = fast.next;
			}
		}

		return slow;
	}

	public ListNode mergeSort(ListNode head) {
		
		if (head == null || head.next == null)
			return head;

		ListNode middle = getMiddle(head);
		ListNode middleNext = middle.next;
		middle.next = null;

		ListNode left = mergeSort(head);
		ListNode right = mergeSort(middleNext);

		return merge(left,right);
	}

	public static void main(String[] args) {

		ListNode h1 = new ListNode(7);
		h1.add(3);
		h1.add(5);
		h1.add(8);
		h1.add(1);
		h1.add(2);
		h1.display();

		MergeSort obj = new MergeSort();
		obj.mergeSort(h1).display();
	}
}
