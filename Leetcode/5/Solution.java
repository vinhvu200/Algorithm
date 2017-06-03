import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {

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

		System.out.println(longestPalindrome2(s1));
		System.out.println(longestPalindrome1(s1));
	}
}
