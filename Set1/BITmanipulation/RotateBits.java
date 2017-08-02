// http://www.geeksforgeeks.org/rotate-bits-of-an-integer/

public class RotateBits {

	public int rotateRight(int n, int amount) {

		int part1 = n >> amount;
		int part2 = n << (32-amount);

		return part1 | part2;
	}

	public int rotateLeft(int n, int amount) {
	
		int part1 = n << amount;
		int part2 = n >> (32-amount);

		return part1 | part2;
	}

	public static void main(String[] args) {

		RotateBits obj = new RotateBits();
		System.out.println(obj.rotateLeft(31200, 15));
	}
}
