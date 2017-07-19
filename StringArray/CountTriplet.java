// http://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/

public class CountTriplet {

	private int tripletUtil(int calcSum, int pos, int sum,
							int amount, int[] array, int total) {
	
		if (amount == 3) {
		
			if (total-calcSum < sum)
				return 1;
			else 
				return 0;
		}
		if (pos == 0)
			return 0;

		int include = tripletUtil(calcSum-array[pos-1], pos-1,
								  sum, amount+1, array, total);
		int exclude = tripletUtil(calcSum, pos-1, sum, amount,
								  array, total);

		return include + exclude;
	}

	public int triplet(int[] array, int sum) {
		
		int total = 0;
		for (int i=0; i<array.length; i++)
			total += array[i];

		return tripletUtil(total,array.length,sum,0,array, total);
	}

	public static void main(String[] args) {

		CountTriplet obj = new CountTriplet();
		int[] array = {5,1,3,4,7};
		System.out.println(obj.triplet(array,12));
	}
}
