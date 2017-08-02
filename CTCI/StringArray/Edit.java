import java.util.HashMap;

public class Edit {

	private boolean editInsert(String s1, String s2) {
	
		boolean foundFlag = false;
		int i = 0;
		int j = 0;

		while (i < s1.length() && j < s2.length()) {
		
			if (s1.charAt(i) != s2.charAt(j)) {
			
				if (foundFlag)
					return false;
				foundFlag = true;
				i++;
			}
			else {
			
				i++;
				j++;
			}
		}

		return true;
	}

	private boolean editReplace(String s1, String s2) {

		boolean foundFlag = false;
		for (int i=0; i<s1.length(); i++) {
		
			if (s1.charAt(i) != s2.charAt(i)) {
			
				if (foundFlag)
					return false;
			
				foundFlag = true;
			}
		}
		return true;
	}

	public boolean edit2(String s1, String s2) {
	
		if (s1.length() == s2.length())
			return editReplace(s1, s2);
		else if (s1.length() - 1 == s2.length())
			return editInsert(s1, s2);
		else if (s1.length() + 1 == s2.length())
			return editInsert(s2, s1);

		return false;
	}

	public boolean edit(String s1, String s2) {
	
		// HashMap
		HashMap<Character, Integer> map = new HashMap<>();

		// Add one for s1
		for (int i=0; i<s1.length(); i++) {
		
			if (!map.containsKey(s1.charAt(i))) {
			
				map.put(s1.charAt(i), 1);
			}
			else {
			
				int num = map.get(s1.charAt(i));
				map.put(s1.charAt(i), num+1);
			}
		}

		// Subtract one for s2
		for (int i=0; i<s2.length(); i++) {
		
			if (!map.containsKey(s2.charAt(i)))
				map.put(s2.charAt(i), 1);
			else {
			
				int num = map.get(s2.charAt(i));
				map.put(s2.charAt(i), num-1);
			}
		}

		// Check longest length of 2
		int count = 0;
		if (s1.length() > s2.length()) {
		
			for (int i=0; i<s1.length(); i++)
				count += map.get(s1.charAt(i));
		}
		else {
		
			for (int i=0; i<s2.length(); i++)
				count += map.get(s2.charAt(i));
		}

		// if count == 1, return true
		if (count == 1)
			return true;
		return false;
	}

	public static void main(String[] args) {

		String s1 = "pale", s2 = "ple";
		String s3 = "pales", s4 = "pale";
		String s5 = "pale", s6 = "bale";
		String s7 = "pale", s8 = "bake";

		Edit obj = new Edit();
		System.out.println(s1 + " : " + s2 + " -- " + obj.edit(s1,s2));
		System.out.println(s3 + " : " + s4 + " -- " + obj.edit(s3,s4));
		System.out.println(s5 + " : " + s6 + " -- " + obj.edit(s5,s6));
		System.out.println(s7 + " : " + s8 + " -- " + obj.edit(s7,s8));

		System.out.println(s1 + " : " + s2 + " -- " + obj.edit2(s1,s2));
		System.out.println(s3 + " : " + s4 + " -- " + obj.edit2(s3,s4));
		System.out.println(s5 + " : " + s6 + " -- " + obj.edit2(s5,s6));
		System.out.println(s7 + " : " + s8 + " -- " + obj.edit2(s7,s8));

	}
}
