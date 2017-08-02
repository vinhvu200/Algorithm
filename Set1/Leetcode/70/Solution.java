public class Solution {

	// Dynamic Programming
	// Time : O(n)
	// Space : O(n)
	public static int climbStairs(int n) {
	
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;

		int i=2;
		while (i <= n) {
		
			dp[i] = dp[i-1] + dp[i-2];
			i++;
		}

		return dp[i-1] + dp[i-2];
	}

	public static void main(String[] args) {

		System.out.println(climbStairs(10));
	}
}
