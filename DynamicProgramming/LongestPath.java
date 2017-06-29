// http://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/

public class LongestPath {

	private boolean isValid(int m_row, int m_col, int row, int col) {
	
		if (row < 0 || col < 0)
			return false;
		if (row >= m_row || col >= m_col)
			return false;
		return true;
	}

	private int lp_util(int[][] matrix, int pathNumber, int row, int col) {
	
		if (matrix[row][col] != pathNumber+1)
			return 0;

		int left = isValid(matrix.length, matrix[0].length, row, col-1) ? 
							lp_util(matrix, matrix[row][col], row, col-1)+1 : 0;
		int right = isValid(matrix.length, matrix[0].length, row, col+1) ?
							lp_util(matrix, matrix[row][col], row, col+1)+1 : 0;
		int up = isValid(matrix.length, matrix[0].length, row-1, col) ?
							lp_util(matrix, matrix[row][col], row-1, col)+1 : 0;
		int down = isValid(matrix.length, matrix[0].length, row+1, col) ?
							lp_util(matrix, matrix[row][col], row+1, col)+1 : 0;

		int max1 = Math.max(left, right);
		int max2 = Math.max(up, down);
		return Math.max(max1, max2);
	}

	// Naive Recursion method
	// Run time : O(4^n)
	// Space : O(1)
	public int lp(int[][] matrix) {
	
		int max=0;

		for (int i=0; i<matrix.length; i++) {
		
			for (int j=0; j<matrix[0].length; j++) {
			
				int left = isValid(matrix.length, matrix[0].length, i, j-1) ? 
							lp_util(matrix, matrix[i][j], i, j-1)+1 : 0;
				int right = isValid(matrix.length, matrix[0].length, i, j+1) ?
							lp_util(matrix, matrix[i][j], i, j+1)+1 : 0;
				int up = isValid(matrix.length, matrix[0].length, i-1, j) ?
							lp_util(matrix, matrix[i][j], i-1, j)+1 : 0;
				int down = isValid(matrix.length, matrix[0].length, i+1, j) ?
						lp_util(matrix, matrix[i][j], i+1, j)+1 : 0;
				
				int max1 = Math.max(left, right);
				int max2 = Math.max(up, down);
				int max3 = Math.max(max1, max2);
				max = Math.max(max, max3);
			}
		}

		return max;
	}

	private int dp_lp_util(int[][] matrix, int row, int col, int[][] dp) {
	
		if (!isValid(matrix.length, matrix.length, row, col))
			return 0;

		if (dp[row][col] != -1)
			return dp[row][col];

		if (isValid(matrix.length, matrix.length, row, col-1) && 
			matrix[row][col]+1 == matrix[row][col-1]) {

			dp[row][col] = 1 + dp_lp_util(matrix, row, col-1, dp);
			return dp[row][col];
		}
		if (isValid(matrix.length, matrix.length, row, col+1) && 
			matrix[row][col]+1 == matrix[row][col+1]) {
			
			dp[row][col] = 1 + dp_lp_util(matrix, row, col+1, dp);
			return dp[row][col];
		}
		
		if (isValid(matrix.length, matrix.length, row-1, col) && 
			matrix[row][col]+1 == matrix[row-1][col]) {

			dp[row][col] = 1 + dp_lp_util(matrix, row-1, col, dp);
			return dp[row][col];
		}

		if (isValid(matrix.length, matrix.length, row+1, col) && 
			matrix[row][col]+1 == matrix[row+1][col]) {

			dp[row][col] = 1 + dp_lp_util(matrix, row+1, col, dp);
			return dp[row][col];
		}

		dp[row][col] = 1;
		return dp[row][col];
	}

	// Dynamic Programming
	// Run time : O(n^2)
	// Space : O(n^2)
	public int dp_lp(int[][] matrix) {
	
		int[][] dp = new int[matrix.length][matrix.length];
		int max = 1;

		for (int i=0; i<matrix.length; i++)
			for (int j=0; j<matrix.length; j++)
				dp[i][j] = -1;
		
		for (int i=0; i<matrix.length; i++) {
		
			for (int j=0; j<matrix.length; j++) {
			
				int result = dp_lp_util(matrix, i, j, dp);

				max = Math.max(max, result);
			}
		}

		return max;
	}

	public static void main(String[] args) {
	
		LongestPath obj = new LongestPath();
		int[][] matrix = {{1,2,9},
							{5,3,8},
							{4,6,7}};

		System.out.println(obj.lp(matrix));
		System.out.println(obj.dp_lp(matrix));
	}
}
