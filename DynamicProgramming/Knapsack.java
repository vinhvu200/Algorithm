public class Knapsack {

	// Dynamic Programming
	// Run time : O(n^2)
	// Space : O(n^2)
	public int dp_ks(int[] val, int[] weight, int sack) {

		int[][] dp = new int[weight.length+1][sack+1];

		for (int i=0; i<=weight.length; i++) {
		
			for (int j=0; j<=sack; j++) {

				if (i==0 || j==0)
					dp[i][j] = 0;
				else if(weight[i-1] <= j)
					dp[i][j] = Math.max(val[i-1]+dp[i-1][j-weight[i-1]], dp[i-1][j]);
				else 
					dp[i][j] = dp[i-1][j];
			}
		}

		return dp[weight.length][sack];
	}

	private int ks_util(int[] val, int[] weight, int sack, int calcWeight, int i) {
	
		if (i == 0)
			return 0;

		if (calcWeight+weight[i-1] > sack)
			return ks_util(val,weight,sack,calcWeight,i-1);
		else {
			return Math.max(val[i-1] + ks_util(val,weight,sack,calcWeight+weight[i-1], i-1),
						ks_util(val,weight,sack,calcWeight,i-1));
		}
	}

	// Naive Recursion
	// Run Time : O(2^n)
	// Space : O(1)
	public int ks(int[] val, int[] weight, int sack) {
	
		return ks_util(val, weight, sack, 0, val.length);
	}

	public static void main(String[] args) {
	
		int[] val1 = {60,100,120};
		int[] weight1 = {10,20,30};
		int sack1 = 50;

		int[] val2 = {1,4,5,7};
		int[] weight2 = {1,3,4,5};
		int sack2 = 7;

		Knapsack obj = new Knapsack();

		System.out.print("Values : ");
		for (int i=0; i<val1.length; i++)	
			System.out.print(val1[i] + " ");
		System.out.println();
		System.out.print("Weights : ");
		for (int i=0; i<weight1.length; i++)
			System.out.print(weight1[i] + " ");
		System.out.println();
		System.out.println("Knapsack (recursive) : " + obj.ks(val1,weight1,sack1));
		System.out.println("Knapsack (dynamic programming) : " + obj.dp_ks(val1,weight1,sack1));

		System.out.print("\nValues : ");
		for (int i=0; i<val2.length; i++)	
			System.out.print(val2[i] + " ");
		System.out.println();
		System.out.print("Weights : ");
		for (int i=0; i<weight2.length; i++)
			System.out.print(weight2[i] + " ");
		System.out.println();
		System.out.println("Knapsack (recursive) : " + obj.ks(val2,weight2,sack2));
		System.out.println("Knapsack (dynamic programming) : " + obj.dp_ks(val2,weight2,sack2));
	}
}
