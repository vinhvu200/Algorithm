// http://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/

public class OptimalStrategy {

	// Dynamic Programming
	// Run time : O(n^2)
	// Space : O(n^2)
	public int dp_os(int[] arr) {

		int[][] dp = new int[arr.length][arr.length];
		
		for (int gap=0; gap<arr.length; gap++) {
		
			for (int i=0,j=gap; j<arr.length; i++, j++) {
			
				int x = (i+2 <= j) ? dp[i+2][j] : 0;
				int y = (i+1 <= j-1) ? dp[i+1][j-1] : 0;
				int z = (i <= j-2) ? dp[i][j-2] : 0;

				dp[i][j] = Math.max(arr[i] + Math.min(x,y), arr[j] + Math.min(y,z));
			}
		}

		return dp[0][arr.length-1];
	}

	private int os_util(int[] arr, int left, int right) {

		if (left>right)
			return 0;

		int L = arr[left] + (arr[left+1] > arr[right] ? 
							os_util(arr,left+2,right) : 
							os_util(arr,left+1,right-1));

		int R = arr[right] + (arr[left] > arr[right-1] ? 
							 os_util(arr,left+1,right-1) :
							 os_util(arr,left,right-2));

		return Math.max(L,R);
	}

	// Naive Recursion
	// Run time : O(2^n)
	// Space : O(1)
	public int os(int[] arr) {

		return os_util(arr, 0, arr.length-1);
	}

	public static void  main(String[] args) {

		OptimalStrategy obj = new OptimalStrategy();

		int[] arr1 = {5,3,7,10};
		int[] arr2 = {8,15,3,7};

		System.out.print("Array1 : ");
		for (int i=0; i<arr1.length;i++)
			System.out.print(arr1[i] + " ");
		System.out.println();
		System.out.println("Maximum point(recursive) : " + obj.os(arr1));
		System.out.println("Maximum point(dynamic programming) : " + obj.dp_os(arr1));

		System.out.print("\nArray2 : ");
		for (int i=0; i<arr2.length; i++)
			System.out.print(arr2[i] + " ");
		System.out.println();
		System.out.println("Maximum point(recursive) : " + obj.os(arr2));
		System.out.println("Maximum point(dynamic programming) : " + obj.dp_os(arr2));

	}
}
