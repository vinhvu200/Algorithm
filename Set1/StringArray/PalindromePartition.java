// http://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/

import java.util.Vector;

public class PalindromePartition {

	private boolean isPalindrome(int start, int end, String s) {
	
		int _start = start;
		int _end = end;
		while (_start < _end) {
		
			if (s.charAt(_start) == s.charAt(_end)) {
			
				_start++;
				_end--;
			}
			else 
				return false;
		}
		return true;
	}

	private void palUtil(Vector< Vector<String> > all, Vector<String> curr, 
						int start, int end, String s) {
	
		if (start >= end) {
		
			for (int i=0; i<curr.size(); i++) {
			
				System.out.print(curr.get(i) + " ");
			}
			System.out.println();

			all.add(curr);
			
			return;
		}

		for (int i=start; i<end; i++) {
		
			if (isPalindrome(start,i,s)) {
	
				curr.add(s.substring(start, i+1));

				palUtil(all, curr, i+1, end, s);

				curr.remove(curr.size()-1);
			}
		}
	}

	public void pal(String s) {
	
		Vector< Vector<String> > all = new Vector< Vector<String> >();
		Vector<String> curr = new Vector<String>();

		palUtil(all, curr, 0, s.length(), s);
	}

	public static void main(String[] args) {

		String s = "nitin";

		PalindromePartition obj = new PalindromePartition();
		obj.pal(s);
	}
}
