import java.util.Stack;

public class Palindrome {

	public boolean palindrome(Node head) {
	
		// Create stack of integer
		// Go through once to find size
		// integer count = 0
		// integer half = size / 2
		// if even : >= half mean start popping and comparing
		// if odd : don't do anything at half

		Stack<Integer> stack = new Stack<>();
		Node temp = head;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		int half = size / 2;
		int count = 0;
		temp = head;
		if (size % 2 == 0) {
		
			while (temp != null) {
			
				if (count < half) {

					stack.push(temp.data);
				}
				else {
				
					int num = stack.pop();
					if (num != temp.data)
						return false;
				}
				temp = temp.next;
				count++;
			}
		}
		else {
		
			if (count < half)
				stack.push(temp.data);
			else if (count == half)
				;
			else {
			
				int num = stack.pop();
				if (num != temp.data)
					return false;
			}
			temp = temp.next;
			count++;
		}

		return true;
	}

	public static void main(String[] args) {

		Node head = new Node(1);
		head.add(2);
		head.add(3);
		head.add(5);
		head.add(3);
		head.add(2);
		//head.add(1);
		head.print();

		Palindrome obj = new Palindrome();
		System.out.println(obj.palindrome(head));
	}
}
