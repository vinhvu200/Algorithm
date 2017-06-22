public class LongestCommonSubsequence {

	public boolean valid(int row, int col) {
	
		if (row < 0 || col < 0)
			return false;
		return true;
	}

	public int lcs(String s1, String s2) {
	
		if (s1.length() == 0 || s1.length() == 0)
			return 0;

		int[][] dp = new int[s1.length()][s2.length()];

		for (int i=0; i<s1.length(); i++) {
		
			for (int j=0; j<s2.length(); j++) {
			
				int temp = s1.charAt(i) == s2.charAt(j) ? 1 : 0;

				if (temp == 1){
					
					if (valid(i-1, j-1))
						dp[i][j] = temp + dp[i-1][j-1];
					else
						dp[i][j] = temp;
				}
				else {
					if (valid(i, j-1) && valid(i-1, j))
						dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
					else if (valid(i, j-1))
						dp[i][j] = dp[i][j-1];
					else if (valid(i-1, j))
						dp[i][j] = dp[i-1][j];
					else
						dp[i][j] = 0;
				}
			}
		}
		return dp[s1.length()-1][s2.length()-1];
	}

	public static void main(String[] args) {

		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		String s1 = "abcdaf";
		String s2 = "acbcf";
		System.out.println("Comparing : " + s1 + ", " + s2);
		System.out.println("lcs : " + obj.lcs(s1, s2));

		String s3 = "AGGTAB";
		String s4 = "GXTXAYB";
		System.out.println("Comparing : " + s3 + ", " + s4);
		System.out.println("lcs : " + obj.lcs(s3, s4));

		String s5 = "ABCDGH";
		String s6 = "AEDFHR";
		System.out.println("Comparing : " + s5 + ", " + s6);
		System.out.println("lcs : " + obj.lcs(s5, s6));

	}
}
