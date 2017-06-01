import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Solution {

	// Optimized Sliding Door
	// This solves in O(n)
	public static int lengthOfLongestSubstring3(String s){
	
		Map<Character, Integer> map = new HashMap<>();
		int max=0;

		for (int i=0, j=0; j<s.length(); j++){
		
			if (map.containsKey(s.charAt(j)))
				i = Math.max(map.get(s.charAt(j)), i);

			max = Math.max(max, j-i+1);
			map.put(s.charAt(j), j+1);
		}
		return max;
	}

	// Sliding door technique
	// This solves in O(2n) = O(n)
	public static int lengthOfLongestSubstring2(String s){
	
		Set<Character> set = new HashSet<>();
		int p=0, q=0, max=0;

		while (p < s.length() && q < s.length()){
		
			if (!set.contains(s.charAt(q))){

				set.add(s.charAt(q));
				q++;
				max = Math.max(max, q-p);
			}
			else {
			
				set.remove(s.charAt(p));
				p++;
			}
		}
		return max;
	}

	// Brute force with Hashmap
	// This only solves it in O(n^2)
	public static int lengthOfLongestSubstring1(String s){

		char[] c = s.toCharArray();
		int count=0, max=0;
		Map<Character, Boolean> map = new HashMap<>();
		for (int i=0; i<c.length; i++){
		
			map = new HashMap<>();
			count = 0;
			for (int j=i; j<c.length; j++){
			
				if (map.containsKey(c[j]))
					break;
				else {
					
					count++;
					map.put(c[j], true);
				}
			}
			if (max < count) max = count;
		}

		return max;
	}

	public static void main(String[] args){
	
		String s = "dvdf";
		System.out.println("String: " + s);
		System.out.println("method 1 max: " + lengthOfLongestSubstring1(s));
		System.out.println("method 2 max: " + lengthOfLongestSubstring2(s));
		System.out.println("method 3 max: " + lengthOfLongestSubstring3(s));
		
		String s2 = "dvdfajfdsalijnqklwinvisoamwqzskladfm,wqikmnc,sva";
		System.out.println("String: " + s2);
		System.out.println("method 1 max: " + lengthOfLongestSubstring1(s2));
		System.out.println("method 2 max: " + lengthOfLongestSubstring2(s2));
		System.out.println("method 3 max: " + lengthOfLongestSubstring3(s2));

	}
}
