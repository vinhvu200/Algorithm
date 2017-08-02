// http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/

public class SubsetSum {

	// Dynamic Programming
	// Run time : O(nm) where n is size of array and m is sum
	// Space : O(nm)
	public boolean dp_ss(int[] array, int sum) {
	
		boolean[][] dp = new boolean [array.length+1][sum+1];

		for (int i=0; i<=array.length; i++)
			dp[i][0] = true;

		for (int i=1; i<=array.length; i++) {
		
			for (int j=1; j<=sum; j++) {
				
				dp[i][j] = dp[i-1][j];

				if (j-array[i-1] >= 0 && dp[i][j-array[i-1]] == true)
					dp[i][j] = true;
			}
		}

		return dp[array.length][sum];
	}

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
		
		System.out.print("Array : ");
		for (int i=0; i<array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();

		System.out.println("Subset sum 9 (Recursive) : " + obj.ss(array,9));
		System.out.println("Subset sum 9 (Dynamic Programming) : " + obj.dp_ss(array,9));
	}
}
