public class SubsetSum {

	private boolean ss_util(int[] array, int i, int sum) {
	
		if (sum == 0)
			return true;

		if (sum < 0 || i == 0)
			return false;

		return ss_util(array, i-1, sum-array[i-1]) ||
				ss_util(array, i-1, sum);
	}

	// Naive Recursion
	// Run time : O(2^n)
	public boolean ss(int[] array, int sum) {
	
		return ss_util(array, array.length, sum);
	}		

	public static void main(String[] args) {
	
		SubsetSum obj = new SubsetSum();
		int[] array = {3,34,4,12,5,2};
		System.out.println(obj.ss(array,9));
	}
}
