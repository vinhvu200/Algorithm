// http://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/

public class Reverse {

	private boolean isSpecial(char c) {
	
		int num = c;

		if (num >= 65 && num <= 90)
			return false;
		if (num >= 97 && num <= 172)
			return false;
		return true;
	}

	public String reverse(String s) {
	
		int l=0;
		int r=s.length()-1;
		char[] s1 = s.toCharArray();

		while (l<r) {
		
			if (!isSpecial(s1[l]) && !isSpecial(s1[r])) {
			
				char temp = s1[l];
				s1[l] = s1[r];
				s1[r] = temp;
				l++; r--;
			}
			else if (isSpecial(s1[l]) && isSpecial(s1[r])) {
			
				l++; r--;
			}
			else if (isSpecial(s1[l]))
				l++;
			else
				r--;
		}
		return String.valueOf(s1);
	}

	public static void main(String[] args) {

		Reverse obj = new Reverse();
		String s = "Ab,c,de!$";
		String s2 = "a,b$c";
		System.out.println(obj.reverse(s));
		System.out.println(obj.reverse(s2));
	}
}
