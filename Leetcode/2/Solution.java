public class Solution {

	public static Listnode revised_addTwoNumbers(Listnode L1, Listnode L2){
	
		Listnode link1 = L1, link2 = L2, answerHead = null, curr = null;
		int sum, val1, val2, carrier = 0;

		while(link1 != null || link2 != null){
		
			val1 = (link1 != null) ? link1.value : 0;
			val2 = (link2 != null) ? link2.value : 0;
			sum = val1 + val2 + carrier;
			carrier = sum / 10;
			if (answerHead == null){
				answerHead = new Listnode(sum%10);
				curr = answerHead;
			}
			else{
				curr.next = new Listnode(sum%10);
				curr = curr.next;
			}
			if (link1 != null) link1 = link1.next;
			if (link2 != null) link2 = link2.next;
		}

		if (carrier == 1){
		
			curr.next = new Listnode(carrier);
			curr = curr.next;
		}
		curr.next = null;

		return answerHead;
	}

	public static Listnode addTwoNumbers(Listnode L1, Listnode L2){
	
		if (L1 == null)
			return reverseList(L2);

		if (L2 == null)
			return reverseList(L1);

		int sum, carrier;
		sum = carrier = 0;
		Listnode link1, link2;
		link1 = L1;
		link2 = L2;
		Listnode answerHead, last;
		answerHead = last = null;

		int iteration = 0;
		while (link1 != null && link2 != null){
		
			sum = link1.value + link2.value + carrier;
			carrier = 0;

			if (sum > 9){
			
				carrier = 1;
				sum = sum%10;
			}

			link1 = link1.next;
			link2 = link2.next;

			Listnode current = new Listnode(sum);
			current.next = null;

			if (answerHead == null){
			
				answerHead = current;
				last = current;
			}
			else{

				last.next = current;
				last = current;
			}
		}

		if (link1 == null){
		
			while (link2 != null){

				sum = carrier + link2.value;
				carrier = 0;

				if (sum > 9){
				
					carrier = 1;
					sum = sum%10;
				}

				Listnode current = new Listnode(sum);
				current.next = null;
				
				last.next = current;
				last = current;
				link2 = link2.next;
			}
		}
		else if (link2 == null){
		
			while (link1 != null){

				sum = carrier + link1.value;
				carrier = 0;

				if (sum > 9){
				
					carrier = 1;
					sum = sum%10;
				}

				Listnode current = new Listnode(sum);
				current.next = null;
				
				last.next = current;
				last = current;
				link1 = link1.next;
			}
		}

		if (carrier == 1){

			Listnode current = new Listnode(carrier);
			current.next = null;

			last.next = current;
		}

		return answerHead;
	}

	public static Listnode reverseList(Listnode head){

		if (head == null)
			return head;
		if (head.next == null)
			return head;

		Listnode n1 = head;
		Listnode n2 = head.next;
		Listnode n3 = head.next.next;

		n1.next = null;
		while (n3 != null){
		
			n2.next = n1;
			n1 = n2;
			n2 = n3;
			n3 = n3.next;
		}

		n2.next = n1;
		head = n2;

		return head;
	}

	public static void display(Listnode head){
	
		Listnode temp = head;
		while (temp != null){
		
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.print("x\n");
	}

	public static void main(String[] args){
	
		Listnode node1 = new Listnode(1);
		Listnode node2 = new Listnode(4);
		Listnode node3 = new Listnode(3);
		node1.next = node2;
		node2.next = node3;
		Listnode L1 = node1;

		Listnode node4 = new Listnode(9);
		Listnode node5 = new Listnode(9);
		Listnode node6 = new Listnode(9);
		Listnode node7 = new Listnode(9);
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		Listnode L2 = node4;

		Listnode answer = addTwoNumbers(L1, L2);
		display(answer);
		Listnode answer2 = revised_addTwoNumbers(L1, L2);
		display(answer2);
	}
}
