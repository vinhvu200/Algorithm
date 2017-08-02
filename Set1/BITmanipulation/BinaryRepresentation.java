public class BinaryRepresentation {

	public void binary(int num) {
	
		for (int i = 31; i >= 0; i--) {
		
			if ( (num & (1 << i)) == 1 << i )
				System.out.print("1" + " ");
			else
				System.out.print("0" + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {

		BinaryRepresentation obj = new BinaryRepresentation();
		obj.binary(30);
	}
}
