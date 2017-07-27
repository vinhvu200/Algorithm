// http://www.geeksforgeeks.org/find-nth-magic-number/

public class MagicNumber {

	public int magicNumber(int n) {
	
		int result = 0;
		int power = 1;

		while (n != 0) {

			power *= 5;

			if ((n & 1) == 1)
				result += power;

			n >>= 1;
		}
		return result;
	}

	public static void main(String[] args) {

		MagicNumber obj = new MagicNumber();
		System.out.println(obj.magicNumber(3));
		System.out.println(obj.magicNumber(4));
		System.out.println(obj.magicNumber(5));
	}
}
