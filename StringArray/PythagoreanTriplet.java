// http://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/

import java.util.Vector;
import java.util.Arrays;

public class PythagoreanTriplet {

	private boolean pythagorean(Vector<Integer> triplet) {
	
		int a,b,c;
		a = b = c = triplet.get(0);

		for (int i=1; i<3; i++) {
		
			if (triplet.get(i) < a)
				a = triplet.get(i);
			if (triplet.get(i) > c)
				c = triplet.get(i);
		}

		for (int i=0; i<3; i++) {
		
			if (triplet.get(i) < c && triplet.get(i) > a)
				b = triplet.get(i);
		}

		return a*a + b*b == c*c;
	}

	private boolean tripletUtil(Vector<Integer> triplet, 
								int[] array, int i) {
	
		if (triplet.size() == 3)
			return pythagorean(triplet);
		if (i == 0)
			return false;

		triplet.add(array[i-1]);
		boolean include = tripletUtil(triplet, array, i-1);
		triplet.remove(triplet.size()-1);
		boolean exclude = tripletUtil(triplet, array, i-1);

		return include || exclude;
	}

	public boolean triplet(int[] array) {
	
		Vector<Integer> v = new Vector<>();

		return tripletUtil(v, array, array.length);
	}

	public boolean triplet2(int[] array) {
	
		Arrays.sort(array);

		for (int i=0; i<array.length; i++)
			array[i] = array[i] * array[i];

		for (int i = array.length-1; i >= 2; i--) {
		
			int l = 0;
			int r = i-1;

			while (l < r) {
				
				if (array[l] + array[r] == array[i])
					return true;

				if (array[l] + array[r] < array[i])
					l++;
				else
					r--;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		PythagoreanTriplet obj = new PythagoreanTriplet();
		int[] arr = {3,1,4,6,5};
		System.out.println(obj.triplet(arr));
		System.out.println(obj.triplet2(arr));
		int[] arr2 = {10,4,6,12,5};
		System.out.println(obj.triplet(arr2));
		System.out.println(obj.triplet2(arr2));
	}
}
