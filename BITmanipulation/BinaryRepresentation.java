public class BinaryRepresentation {

	public void binary(int num) {
	
		int exp = 0;
		
		while (Math.pow(2,exp) < num)
			exp++;

		exp--;

		while (exp >= 0) {
		
			if (Math.pow(2,exp) <= num){
				
				System.out.print("1" + " ");
				num -= Math.pow(2,exp);
			}
			else
				System.out.print("0" + " ");
			exp--;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		BinaryRepresentation obj = new BinaryRepresentation();
		obj.binary(30);
	}
}
