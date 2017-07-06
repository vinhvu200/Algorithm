public class CompareString {

	public boolean compare(ListNodeString head1, ListNodeString head2) {
	
		if (head1 == null && head2 == null)
			return true;
		if (head1 == null || head2 == null)
			return false;

		ListNodeString temp1 = head1;
		ListNodeString temp2 = head2;

		while (temp1 != null && temp2 != null) {
		
			if (temp1.val != temp2.val)
				return false;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		if (temp1 == null && temp2 == null)
			return true;
		return false;
	}

	public static void main(String[] args) {

		ListNodeString head1 = new ListNodeString('g');
		head1.add('e');
		head1.add('e');
		head1.add('k');
		head1.add('s');

		ListNodeString head2 = new ListNodeString('g');
		head2.add('e');
		head2.add('e');
		head2.add('k');
		head2.add('s');

		head1.display();
		head2.display();

		CompareString obj = new CompareString();
		System.out.println(obj.compare(head1,head2));
	}
}
