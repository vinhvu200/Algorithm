// http://www.geeksforgeeks.org/swap-all-odd-and-even-bits/

public class SwapOddEvenBits {
	
	public int swap(int num) {
	
		int even = num & 0xAAAAAAAA;
		int odd = num & 0x55555555;

		even >>= 1;
		odd <<= 1;

		return (even | odd);
	}

	public static void main(String[] args) {

		SwapOddEvenBits obj = new SwapOddEvenBits();
		System.out.println(obj.swap(23));
	}
}
