import java.util.HashMap;

public class Permutation {

	public boolean permutation(String s1, String s2) {
	
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i=0; i<s1.length(); i++) {
		
			if (!map.containsKey(s1.charAt(i))) 
				map.put(s1.charAt(i), 1);
			else {
			
				int num = map.get(s1.charAt(i));
				map.put(s1.charAt(i), num+1);
			}
		}

		for (int i=0; i<s2.length(); i++) {
		
			if (!map.containsKey(s2.charAt(i)))
				return false;
			else {
			
				int num = map.get(s2.charAt(i));
				map.put(s2.charAt(i), num-1);
			}
		}

		for (int i=0; i<s2.length(); i++) {
		
			if (!map.containsKey(s2.charAt(i)))
				return false;
			
			int num = map.get(s2.charAt(i));
			if (num != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		String s1 = "", s2 = "";
		String s3 = "abcd", s4 = "dcba";
		String s5 = "abcddddd", s6 = "ddcba";

		Permutation obj = new Permutation();
		System.out.println(s1 + " : " + s2 + " -- " + obj.permutation(s1,s2));
		System.out.println(s3 + " : " + s4 + " -- " + obj.permutation(s3,s4));
		System.out.println(s5 + " : " + s6 + " -- " + obj.permutation(s5,s6));
	}
}
