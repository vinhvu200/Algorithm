import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {

	// Dynamic Programming
	// Run time O(n^2)
	// Space Complexity O(n^2)
	// Ex: If 'aba' is palindrome, then 'cabac' will be palindrome etc
	// Accepted
	public static String longestPalindrome4(String s) {
	
		if (s.isEmpty() || s == null)
			return "";

		boolean[][] table = new boolean[s.length()][s.length()];
		int max_row=0, max_col=0;

		for (int i=0; i<s.length(); i++) {
			
			table[i][i] = true;
		
			if (i+1 < s.length()){
				
				if (s.charAt(i) == s.charAt(i+1)){
					table[i][i+1] = true;
					max_row = i;
					max_col = i+1;
				}
			}
		}

		for (int i=1; i<s.length(); i++) {
		
			int row=0;
			int col=i;

			while (col < s.length()) {
			
				if (s.charAt(row) == s.charAt(col)) {
				
					if (table[row+1][col-1] == true) {
					
						table[row][col] = true;
						max_row = row;
						max_col = col;
					}
				}
				row++; col++;
			}
		}
		return s.substring(max_row, max_col+1);
	}

	// Solution method 1
	// Reverse string and find longest common substring
	// All cases pass but "Time Limit Exceeded"
	// *** Technically still O(n^2) but handling condition for 
	// strings such as "abcdzfdcba" makes the time exceed limit
	public static String longestPalindrome3(String s) {

		String s_reverse = reverseString(s);
		int[][] array = new int[s.length()][s_reverse.length()];
		int row=0, col=0, max=0;
		int start, complement, size;
		String s1, s2;

		for (int i=0;i<s.length(); i++){
		
			for (int j=0; j<s_reverse.length(); j++){
			
				if (s.charAt(i) == s_reverse.charAt(j)){
				
					if (i-1 >= 0 && j-1 >=0)
						array[i][j] = array[i-1][j-1] + 1;
					else
						array[i][j] = 1;

					if (array[i][j] > max){
					
						max = array[i][j];
						row = i;
						col = j;
					}
				}
				else
					array[i][j] = 0;
			}
		}
		String lcs = "";

		while (s.charAt(row) != s_reverse.charAt(s.length()-row-1+max-1)) {
		
			// If not along the diagonal, then erase
			while (row >= 0 && col >= 0) {
			
				if (row != s.length()-col-1)
					array[row][col] = 0;
				else
					array[row][col] = 1;
				row--; col--;
			}

			max = 0;
			// Search for new max
			for (int i=0; i<s.length(); i++)
				for (int j=0; j<s.length(); j++){
				
					if (array[i][j] > max){

						max = array[i][j];
						row = i;
						col = j;
					}
				}
		}
		lcs = s.substring(row-max+1, row+1);

		return lcs;
	}

	// Attempt #2
	// HashMap to store indices
	// Answer not accepted : Time Limit Exceeded (92/94 cases)
	// NOTE : I believe that this is O(n^2) but because of 
	// such expensive datastructures (ArrayList), the run
	// time actually fell further behind... May be wrong still
	public static String longestPalindrome2(String s) {
	
		if (s.isEmpty() || s == null)
			return "";
		String longest = s.substring(0,1);
		Map<Character, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> c;

		for (int i=0; i<s.length(); i++){
		
			if (!map.containsKey(s.charAt(i))){
			
				c = new ArrayList<>();
				c.add(i);
				map.put(s.charAt(i), c);
			}
			else{
			
				c = map.get(s.charAt(i));
				for(int j=0; j<c.size(); j++){
				
					if (i-c.get(j)+1 < longest.length())
						break;

					if (isPalindrome(s.substring(c.get(j), i+1))){
						longest = s.substring(c.get(j), i+1);
						break;
					}
				}
				c.add(i);
			}
		}
		return longest;
	}

	// Attempt #1..
	// Optimized Brute Force
	// Run time : O(n^3)
	// Answer not accepted : Time Limit Exceeded
	public static String longestPalindrome1(String s) {

		if (s.isEmpty() || s == null)
			return "";

		String longest = s.substring(0,1);

		for (int i=0; i<s.length()-1; i++){
		
			for (int j=s.length()-1; j>i; j--){
			
				if (s.charAt(i) == s.charAt(j))
					if (j-i+1 > longest.length())
						if(isPalindrome(s.substring(i,j+1)))
							if (s.substring(i,j+1).length() > longest.length())
								longest = s.substring(i,j+1);
			}
		}
		return longest;
	}

	public static String reverseString(String s) {
	
		String s_reverse = "";
		for (int i=s.length()-1; i>=0; i--){
		
			s_reverse += s.charAt(i);
		}
		return s_reverse;
	}

	// Checking palindrome 
	// Run time : O(n/2) = O(n)
	public static boolean isPalindrome(String s){
	
		int i=0, j=s.length()-1;
		while (i < j)
			if (s.charAt(i++) != s.charAt(j--))
				return false;

		return true;
	}

	public static void main(String[] args){
	
		String s = "aaaaaaaaaaaaaaaaaa";
		String s1 = "lphbehiapswjudnbcossedgioawodnwdruaaxhbkwrxyzaxygmnjgwysafuqbmtzwdkihbwkrjefrsgjbrycembzzlwhxneiijgzidhngbmxwkhphoctpilgooitqbpjxhwrekiqupmlcvawaiposqttsdgzcsjqrmlgyvkkipfigttahljdhtksrozehkzgshekeaxezrswvtinyouomqybqsrtegwwqhqivgnyehpzrhgzckpnnpvajqevbzeksvbezoqygjtdouecnhpjibmsgmcqcgxwzlzztdneahixxhwwuehfsiqghgeunpxgvavqbqrelnvhnnyqnjqfysfltclzeoaletjfzskzvcdwhlbmwbdkxnyqappjzwlowslwcbbmcxoiqkjaqqwvkybimebapkorhfdzntodhpbhgmsspgkbetmgkqlolsltpulgsmyapgjeswazvhxedqsypejwuzlvegtusjcsoenrcmypexkjxyduohlvkhwbrtzjnarusbouwamazzejhnetfqbidalfomecehfmzqkhndpkxinzkpxvhwargbwvaeqbzdhxzmmeeozxxtzpylohvdwoqocvutcelgdsnmubyeeeufdaoznxpvdiwnkjliqtgcmvhilndcdelpnilszzerdcuokyhcxjuedjielvngarsgxkemvhlzuprywlypxeezaxoqfges";
		String s2 = "abcdasdfghjkldcba";
		String s3 = "cbbd";
		String s4 = "abczdcba";

		System.out.println(longestPalindrome1(s1));
		System.out.println(longestPalindrome2(s1));
		System.out.println(longestPalindrome3(s1));
		System.out.println(longestPalindrome4(s3));
	}
}
