public class LongestIncreasingSubsequence {

	public static void printArray(int[] array) {
	
		System.out.print("array : ");
		for (int i=0; i<array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	public int lis(int[] array) {
	
		if (array.length == 0)
			return 0;

		int[] dp = new int[array.length];
		int max = 1;
		dp[0] = 1;

		for (int i=1; i<dp.length; i++) {
		
			int temp = i-1;
			dp[i] = 1;
			while (temp >= 0) {

				if (array[i] > array[temp])
					dp[i] = Math.max(dp[i], 1+dp[temp]);
				temp--;
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	public static void main(String[] args) {

		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();

		int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		printArray(array);
		System.out.println("LIS : " + obj.lis(array));

		int[] array2 = {3,10,2,1,20};
		printArray(array2);
		System.out.println("LIS : " + obj.lis(array2));

		int[] array3 = {3,2};
		printArray(array3);
		System.out.println("LIS : " + obj.lis(array3));

		int[] array4 = {50,3,10,7,40,80};
		printArray(array4);
		System.out.println("LIS : " + obj.lis(array4));

		int[] array5 = {3,4,-1,0,6,2,3};
		printArray(array5);
		System.out.println("LIS : " + obj.lis(array5));

		int[] array6 = {2,5,1,8,3};
		printArray(array6);
		System.out.println("LIS : " + obj.lis(array6));

	}
}
