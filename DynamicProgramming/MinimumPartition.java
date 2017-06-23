public class MinimumPartition {

	private int find_mp(int[] arr, int i, int sumCalculated, int sumTotal) {
	
		if (i == 0)
			return Math.abs((sumTotal-sumCalculated) - sumCalculated);

		return Math.min(find_mp(arr, i-1, sumCalculated+arr[i-1], sumTotal),
						find_mp(arr, i-1, sumCalculated, sumTotal));
	}

	// Naive Recursion
	// Run time : O(2^n)
	// Space : O(1)
	public int mp(int[] array) {
		
		int total = 0;

		for (int i=0; i<array.length; i++)
			total += array[i];

		return find_mp(array, array.length, 0, total);
	}

	public static void main(String[] args) {
	
		MinimumPartition obj = new MinimumPartition();

		int[] array = {1,6,11,5};
		System.out.println(obj.mp(array));
	}
}
