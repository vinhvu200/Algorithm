public class URL {

	public String url(String s1) {
	
		// count number of spaces
		int spaces = 0;
		for (int i=0; i<s1.length(); i++) {
		
			if (s1.charAt(i) == ' ')
				spaces++;
		}

		// new array with proper correct size
		char[] url = new char[s1.length() + 2 * spaces];

		// iterate through s1, when space is encountered, place filler
		int j = 0;
		for (int i=0; i<s1.length(); i++) {
		
			if (s1.charAt(i) == ' ') {
			
				url[j++] = '%';
				url[j++] = '2';
				url[j++] = '0';
			}
			else
				url[j++] = s1.charAt(i);
		}

		return new String(url);
	}

	public static void main(String[] args) {

		String s = "Mr John Smith";
		URL obj = new URL();
		System.out.println(s + " : " + obj.url(s));
	}
}
