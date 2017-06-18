public class Solution {

	public static boolean validSquare(int[][] grid, int row, int col) {
	
		if (row >= grid.length)
			return false;
		if (col >= grid[0].length)
			return false;
		return true;
	}


	/*
		Dynamic Programming
		Run time : O(n^2)
		Space : O(n^2)
	*/
	public static int minPathSum(int[][] grid) {

		int[][] dp = new int[grid.length][grid[0].length];

		for (int i=grid.length-1; i>=0; i--) {
		
			for (int j=grid[0].length-1; j>=0; j--) {
			
				if (validSquare(grid, i+1, j) && validSquare(grid, i, j+1)) 
					dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
				else if (validSquare(grid, i+1, j))
					dp[i][j] = grid[i][j] + dp[i+1][j];
				else if (validSquare(grid, i, j+1))
					dp[i][j] = grid[i][j] + dp[i][j+1];
				else 
					dp[i][j] = grid[i][j];
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {

		int[][] grid = { {1,2,3},
						 {4,5,6},
						 {7,8,9},
						 {11,12,13} };

		System.out.println(minPathSum(grid));

	}
}
