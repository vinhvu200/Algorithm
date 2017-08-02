import java.util.HashMap;
import java.util.ArrayList;

public class StringCompression {

	public String compress(String s) {
	
		StringBuilder sb = new StringBuilder();

		int count = 1;
		char last = s.charAt(0);
		for (int i=1; i<s.length(); i++) {
		
			if (s.charAt(i) != last) {
			
				sb.append(last);
				sb.append(String.valueOf(count));
				last = s.charAt(i);
				count = 1;
			}
			else 
				count++;
		}

		sb.append(last);
		sb.append(String.valueOf(count));

		return String.valueOf(sb);
	}

	public static void main(String[] args) {

		String s = "aabccccaa";
		StringCompression obj = new StringCompression();
		System.out.println(obj.compress(s));
	}
}
