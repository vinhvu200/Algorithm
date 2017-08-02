public class Solution {

	public static String dnq_commonPrefix(String left, String right) {
	
		int min = Math.min(left.length(), right.length());

		for (int i=0; i<min; i++) {
		
			if (left.charAt(i) != right.charAt(i))
				return left.substring(0, i);
		}
		return left.substring(0, min);
	}

	public static String dnq_longestCommonPrefix(String[] strs, int l, int r) {
	
		if (l == r)
			return strs[l];
		else {
		
			int mid = (l+r) / 2;
			String leftPrefix = dnq_longestCommonPrefix(strs, 0, mid);
			String rightPrefix = dnq_longestCommonPrefix(strs, mid+1, r);
			return dnq_commonPrefix(leftPrefix, rightPrefix);
		}
	}

	// Divide and Conquer
	// Run time : O(S)
	// Best time : O(minLen * n) minLen = length of shortest string
	// Space : O(m * log(n))
	public static String longestCommonPrefix3(String[] strs) {
	
		if (strs == null || strs.length == 0)
			return "";

		return dnq_longestCommonPrefix(strs, 0, strs.length-1);
	}

	// Horizontal Scanning
	// O(S)
	// More efficient because it only goes through the list
	// of string once
	public static String longestCommonPrefix2(String[] strs) {
	
		if (strs.length == 0)
			return "";
		String prefix = "";
		prefix = strs[0];

		for (int i=1; i<strs.length; i++) {
		
			while (strs[i].indexOf(prefix) != 0) {
			
				prefix = prefix.substring(0, prefix.length()-1);
				if (prefix.length() == 0)
					return "";
			}
		}
		return prefix;
	}

	// Vertical Scanning
	// O(S)
	public static String longestCommonPrefix1(String[] strs) {
	
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];

		boolean flag=false;
		String prefix = "";
		int i=0;

		while (i < 1000) {
		
			char letter;
			if (i >= strs[0].length())
				return prefix;
			else
				letter = strs[0].charAt(i);
			
			for (int j=0; j<strs.length; j++){
			
				if (i >= strs[j].length()){
				
					flag = true;
					break;
				}
				if (strs[j].charAt(i) != letter){
				
					flag = true;
					break;
				}
			}
			if (flag == true)
				break;
			else
				prefix += letter;
			i++;
		}
		return prefix;
	}

	public static void main(String[] args){

		String strs[] = { "alabama", "alaska", "alamo" };
		String strs1[] = { "c", "c" };
		System.out.println(longestCommonPrefix1(strs));
		System.out.println(longestCommonPrefix2(strs));
		System.out.println(longestCommonPrefix3(strs));
	}
}
