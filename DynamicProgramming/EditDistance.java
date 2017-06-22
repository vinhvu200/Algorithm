public class EditDistance {

	// Dynamic Programming
	// Time : O(m * n) where m and n are length of s1 and s2 respectively
	// Space : O(m * n)
	public int dp_ed(String s1, String s2) {
	
		int[][] dp = new int[s1.length()+1][s2.length()+1];

		for (int i=0; i<=s1.length(); i++) {
		
			for (int j=0; j<=s2.length(); j++) {
			
				if (i ==0)
					dp[i][j] = j;
				else if (j==0)
					dp[i][j] = i;
				else {
				
					if (s1.charAt(i-1) == s2.charAt(j-1))
						dp[i][j] = dp[i-1][j-1];
					else
						dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1;
				}
			}
		}

		return dp[s1.length()][s2.length()];
	}

	// Naive Recursive Approach
	// Time : O(3^m) where m is length of s1
	// Space : O(1)
	public int ed(String s1, String s2) {

		if (s1.length() == 0)
			return s2.length();
		if (s2.length() == 0)
			return s1.length();

		int replace = ed(s1.substring(1), s2.substring(1)) + replaceCost(s1, s2);
		int insert = ed(s1, s2.substring(1)) + 1;
		int delete = ed(s1.substring(1), s2) + 1;

		return min(replace, insert, delete);
	}

	private int replaceCost(String s1, String s2) {
	
		return (s1.charAt(0) == s2.charAt(0)) ? 0 : 1;
	}

	private int min(int r, int i, int d) {
	
		int min = Math.min(r, i);
		return Math.min(min, d);
	}

	public static void main(String[] args) {
	
		EditDistance obj = new EditDistance();

		String s1 = "abcdef";
		String s2 = "azced";
		System.out.println("Strings : " + s1 + ", " + s2);
		System.out.println("Naive Recursion ed: " + obj.ed(s1, s2));
		System.out.println("DP ed : " + obj.dp_ed(s1,s2));

		String s3 = "geek";
		String s4 = "gesek";
		System.out.println("Strings : " + s3 + ", " + s4);
		System.out.println("Naive Recursion ed: " + obj.ed(s3, s4));
		System.out.println("DP ed : " + obj.dp_ed(s3,s4));

		String s5 = "cat";
		String s6 = "cut";
		System.out.println("Strings : " + s5 + ", " + s6);
		System.out.println("Naive Recursion ed: " + obj.ed(s5, s6));
		System.out.println("DP ed : " + obj.dp_ed(s5,s6));

		String s7 = "sunday";
		String s8 = "saturday";
		System.out.println("Strings : " + s7 + ", " + s8);
		System.out.println("Naive Recursion ed: " + obj.ed(s7, s8));
		System.out.println("DP ed : " + obj.dp_ed(s7,s8));
	}
}
