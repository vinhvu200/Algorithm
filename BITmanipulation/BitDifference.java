// http://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/

public class BitDifference {

	public int bitDifference(int num1, int num2){

		int diff = 0;

		while (num1 != 0 || num2 != 0) {
		
			if (((num1 & 1) ^ (num2 & 1)) == 1)
				diff++;

			num1 >>= 1;
			num2 >>= 1;
		}

		return diff;
	}

	public int sumBitDifference(int[] arr) {
	
		int result = 0;

		for (int i=0; i<arr.length; i++) {
		
			for (int j=0; j<arr.length; j++) {
			
				result += bitDifference(arr[i], arr[j]);
			}
		}
		return result;
	}

	public int sumBitDifference2(int[] arr) {
	
		int result = 0;

		for (int i=0; i<32; i++) {
		
			int count = 0;
			for (int j=0; j<arr.length; j++)
				if ((arr[j] & (1 << i)) == 1 << i)
					count++;

			result += count * (arr.length-count) * 2;
		}
		return result;
	}

	public static void main(String[] args) {

		BitDifference obj = new BitDifference();
		int[] arr = {1,3,5};
		System.out.println(obj.sumBitDifference2(arr));
	}
}
