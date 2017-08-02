// http://www.geeksforgeeks.org/generate-all-possible-sorted-arrays-from-alternate-elements-of-two-given-arrays/

import java.util.Vector;

public class Alternate {
	
	private void print(Vector<Integer> array) {
	
		for (int i=0; i<array.size(); i++)
			System.out.print(array.get(i) + " ");
		System.out.println();
	}

	private void alternateUtil(Vector<Integer> result, int i,
							   int j, int[] arr1, int[] arr2,
							   boolean first) {

		if (first && i >= arr1.length)
			return;
		if (!first && j >= arr2.length)
			return;

		if (!first) {
		
			if (result.get(result.size()-1) < arr2[j]) {
			
				result.add(arr2[j]);
				print(result);
				alternateUtil(result, i, j+1, arr1, arr2, !first);
				result.remove(result.size()-1);
			}
			alternateUtil(result,i,j+1,arr1,arr2,first);
		}
		else {

			if (result.get(result.size()-1) < arr1[i]) {
			
				result.add(arr1[i]);
				alternateUtil(result, i+1, j, arr1, arr2, !first);
				result.remove(result.size()-1);
			}
			alternateUtil(result,i+1,j,arr1,arr2,first);
		}
	}

	public void alternate(int[] arr1, int[] arr2) {
	
		Vector<Integer> result = new Vector<>();
		boolean first = true;

		for (int i=0; i<arr1.length; i++) {
		
			result.add(arr1[i]);
			alternateUtil(result, i+1, 0, arr1, arr2, !first);
			result.remove(result.size()-1);
		}
	}

	public static void main(String[] args) {

		Alternate obj = new Alternate();
		int[] arr1 = {10,15,25};
		int[] arr2 = {1,5,20,30};
		obj.alternate(arr1,arr2);
	}
}
