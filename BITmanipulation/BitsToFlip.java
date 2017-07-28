public class BitsToFlip {

	public int flip(int num1, int num2) {

		int result = num1 ^ num2;
		int count = 0;
		for (int i=0; i<32; i++) {
		
			if ( (result & (1 << i)) == (1 << i))
				count++;
		}
		return count;
	}

	public static void main(String[] args) {

		BitsToFlip obj = new BitsToFlip();
		System.out.println(obj.flip(10,20));
	}
}
