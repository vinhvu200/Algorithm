// http://www.geeksforgeeks.org/count-total-set-bits-in-all-numbers-from-1-to-n/

public class TotalSetBits {

	private int countBits(int num) {
	
		int count = 0;
		for (int i=0; i<32; i++) {
		
			if ( (num & (1 << i)) == (1 << i))
				count++;
		}

		return count;
	}

	public int setBits(int n) {
	
		int total = 0;

		for (int i=0; i<=n; i++)
			total += countBits(i);

		return total;
	}

	public static void main(String[] args) {

		TotalSetBits obj = new TotalSetBits();
		System.out.println(obj.setBits(3));
		System.out.println(obj.setBits(6));
		System.out.println(obj.setBits(7));
		System.out.println(obj.setBits(8));

	}
}
