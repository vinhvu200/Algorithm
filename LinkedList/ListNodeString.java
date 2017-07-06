public class ListNodeString {

	char val;
	ListNodeString next;
	ListNodeString(char x) {val=x;}

	public void add(char num) {
	
		ListNodeString n = new ListNodeString(num);
		ListNodeString temp = this;
		while (temp.next != null)
			temp = temp.next;
		temp.next = n;
	}

	public void display() {
	
		ListNodeString temp = this;

		while (temp != null) {
		
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.print("x");
		System.out.println();
	}
}
