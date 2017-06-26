public class MinimumPartition {

	// DP approach
	// Run time : O(nm) where n is size of array
	//					and m is the sum of array
	// **Note : This approach is only pseduo polynomial
	// 			because its dependent on the sum
	public int dp_mp(int[] arr) {
	
		int sum=0;

		for (int i=0; i<arr.length; i++)
			sum += arr[i];

		boolean[][] dp = new boolean[arr.length+1][sum+1];

		for (int i=0; i<=arr.length; i++)
			dp[i][0] = true;

		for (int i=1; i<=arr.length; i++) {
		
			for (int j=1; j<=sum; j++) {
			
				dp[i][j] = dp[i-1][j];

				if (arr[i-1] <= j)
					dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
			}
		}

		int min = sum;
		for (int i=sum/2; i>=0; i--) {
		
			if (dp[arr.length][i] == true){
			
				min = sum-2*i;
				break;
			}
		}
		return min;
	}

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

		int[] array = {1,6,11};
		System.out.println(obj.mp(array));
		System.out.println(obj.dp_mp(array));
	}
}
