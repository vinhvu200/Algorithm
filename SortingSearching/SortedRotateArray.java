// http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

public class SortedRotateArray {

	private int binarySearch(int[] array, int l, int r, int key) {
	
		while (l <= r) {
		
			int mid = (l+r) / 2;
			if (array[mid] == key)
				return mid;
			if (key > array[mid])
				l = mid+1;
			else
				r = mid-1;
		}
		return -1;
	}

	public int rotateArray(int[] array, int key) {
	
		if (array.length == 0)
			return -1;

		int localMaxima = array[0];
		int i = 1;

		while (i < array.length && localMaxima < array[i])
			i++;

		int firstStartIndex = 0;
		int firstEndIndex = i-1;
		int secondStartIndex = i;
		int secondEndIndex = array.length-1;

		int result = binarySearch(array,firstStartIndex,
									firstEndIndex, key);

		if (result != -1)
			return result;

		return binarySearch(array,secondStartIndex, 
							secondEndIndex, key);
	}

	public static void main(String[] arg) {

		int[] arr1 = {3,4,5,1,2};
		int[] arr2 = {5,6,7,8,9,10,1,2,3};
		int[] arr3 = {5,6,7,8,9,10,1,2,3};
		int[] arr4 = {30,40,50,10,20};

		SortedRotateArray obj = new SortedRotateArray();
		System.out.println(obj.rotateArray(arr1,1));
		System.out.println(obj.rotateArray(arr2,3));
		System.out.println(obj.rotateArray(arr3,30));
		System.out.println(obj.rotateArray(arr4,10));
	}
}
