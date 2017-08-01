import java.util.HashSet;

public class Unique {

	public boolean isUnique2(String s) {
	
		for (int i=0; i<s.length()-1; i++) {
		
			for (int j=i+1; j<s.length(); j++) {
			
				if (s.charAt(i) == s.charAt(j))
					return false;
			}
		}
		return true;
	}

	public boolean isUnique(String s) {
	
		HashSet<Character> hash = new HashSet<>();

		for (int i=0; i<s.length(); i++) {
		
			if (hash.contains(s.charAt(i)))
				return false;
			else
				hash.add(s.charAt(i));
		}
		return true;
	}

	public static void main(String[] args) {

		Unique obj = new Unique();
		String s1 = "";
		String s2 = "abca";
		String s3 = "bbbbbbbbb";
		String s4 = "a$cd7#l";

		System.out.println(s1 + " : " + obj.isUnique(s1));
		System.out.println(s2 + " : " + obj.isUnique(s2));
		System.out.println(s3 + " : " + obj.isUnique(s3));
		System.out.println(s4 + " : " + obj.isUnique(s4));

		System.out.println(s1 + " : " + obj.isUnique2(s1));
		System.out.println(s2 + " : " + obj.isUnique2(s2));
		System.out.println(s3 + " : " + obj.isUnique2(s3));
		System.out.println(s4 + " : " + obj.isUnique2(s4));

	}
}
