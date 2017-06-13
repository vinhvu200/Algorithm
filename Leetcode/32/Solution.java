import java.util.Stack;

public class Solution {

	// Solution 2
	// Stack
	// Time : O(n)
	// Space : O(n)
	public static int longestValidParentheses3(String s) {
	
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		for (int i=0; i<s.length(); i++) {
		
			if (s.charAt(i) == '(')
				stack.push(i);
			else {
			
				stack.pop();

				if (stack.isEmpty())
					stack.push(i);
				else {
					int temp = i-stack.peek();
					max = Math.max(temp, max);
				}
			}
		}

		return max;
	}

	// Solution 1
	// Dynamic Programming
	// Time : O(n)
	// Space : O(n)
	public static int longestValidParentheses2(String s) {
	
		int[] dp = new int[s.length()];
		int maxans = 0;

		for (int i=1; i<s.length(); i++) {
		
			if (s.charAt(i) == ')'){
			
				if (s.charAt(i-1) == '(') {
				
					if (i-2 >= 1) 
						dp[i] = dp[i-2] + 2;
					else 
						dp[i] = 2;
				}
				else if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {

					if (i-dp[i-1]-2 >= 0)
						dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2];
					else
						dp[i] = dp[i-1] + 2;
				}
			}
			maxans = Math.max(maxans, dp[i]);
		}

		return maxans;
	}

	// Attempt
	// Dynamic Programming (used incorrectly)
	// More of an optimized brute force
	// Time : O(n/2) * O(n) * O(n/2) = O(n^3)
	// Space : O(n^2)
	// Result : 221/229 cases passed.. Time Limit Exceeded
	public static int longestValidParentheses(String s) {
	
		boolean array[][] = new boolean[s.length()][s.length()];
		boolean flag = false;
		int row=0, col=1;

		while (col < s.length()) {
		
			if (s.charAt(row) == '(' && s.charAt(col) == ')') {
			
				flag = true;
				array[row][col] = true;
			}
			else 
				array[row][col] = false;
			row++; col++;
		}

		if (flag == false)
			return 0;

		int max = 2;
		int iteration = s.length() / 2;
		int t_row=0, t_col=0;

		for (int i=1; i<iteration; i++) {
		
			row = 0;
			col = 2*i+1;

			while (col < s.length()) {
			
				flag = false;

				if (s.charAt(col-1) == '(' && s.charAt(col) == ')') {
				
					if (array[row][col-2] == true) {
						flag = true;
						array[row][col] = true;
						if (col-row+1 > max)
							max = col-row+1;

					}
				}
				if (s.charAt(row) == '(' && s.charAt(col) == ')') {
				
					if (array[row+1][col-1] == true) {
						flag = true;
						array[row][col] = true;
						if (col-row+1 > max)
							max = col-row+1;
					}
				}
				t_row = row+2;
				t_col = row+1;

				if (flag == false) {
					while (t_col < col) {
						
						if (array[row][t_col] == true && array[t_row][col] == true) {
						
							array[row][col] = true;
							if (col-row+1 > max)
								max = col-row+1;
						}
						t_row += 2;
						t_col += 2;
					}
				}

				row++; col++;
			}
		}

		return max;
	}

	public static void main(String[] args) {
	
		String s = "()(())";
		String s1 = "))))))()((()(((()((()((())()((()))()()(()()))))()())()))())())))(((()()()()(()()))()((()))))()(()()(((()())(((())(((())((()))))()(()(())(()(()(((((())(())))(()))())(((((())))))))()(())((((((()())()))))(()))(((()()(()(())()((())))()(())))())()())((((()))))()()((((((())()((((()(())((((()()())(())()())))()(()((())))))))()())((((()))())())))()))((())))()((()(())((()((())))((())((()())()))))())))())(((((((()))(((())(((()((()))(((()(())))((((()()())))))))())()))(()))())))()(()))((())()))((())))((())(()())(((()((()()))))()()(())))))()))))()((()((()(((()())(((())))(()(())())))((((((()()()))))((()))))(()(())()(()((())((()))()()()()(()((()())((((())()((()()))()))))()(((()())())))(()(((()()))()())))()()))))((()((((()(()))()(()()(((()()()()())((())()(((())(())))))()))))()())()()())(())))((())(()))(((())()))))))())()())((()((()()(())))())((()(((()(((((()(())(())()()))()))(()((((((((()(()()))()(()(()))(())(())())))))(())))))))()))))()())()()(((())()))((()))))))(())((()))(()((()()())())((()))))((()()())(()(((()))))(())(((()(()()()()((())())(())()))()())))())))()(((()))(()))()))()((((()()()(()(()))(((())()()(((())()((()(())((())())(((()()))((()())))())(()(())(()()))(((()(())(())))(()())(()()()()(()((()()()))(())(()(((()())))()((((())()())((()(()(())))(()()(()(()))))))(()())((()))()))()(()))((()()))))()()()))(())(())(())))()(()))(()()(((()((((())())))(()(())(()()))))))((()((()()))())))((((((())()))())(())())(()()(()(()()))()))((()((())(()((()(())))()((()))()(((()()()())()((())))(()()()()(()((()()((()((()()()(()(((())))))(())(()()(()())((((()()()()((()(())()(((()))(()(())(((()())())((()()))(";
		String s2 = "()()()";
		long start = System.nanoTime();
		System.out.println(longestValidParentheses3(s1));
		long end = System.nanoTime();
		long duration = (end - start) / 1000000;
		System.out.println("duration : " + duration + "ms");
	}
}
