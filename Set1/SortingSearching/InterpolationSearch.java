public class InterpolationSearch {

	public int interpolation(int[] arr, int key) {
	
		int left = 0;
		int right = arr.length - 1;

		while (left <= right && 
				key >= arr[left] && 
				key <= arr[right]) {

			int pos = left + ((right-left) / (arr[right] - arr[left]) 
						* (key - arr[left]));

			if (arr[pos] == key)
				return pos;
			if (key > arr[pos])
				left = pos+1;
			else
				right = pos-1;
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] arr = {1,2,4,6,7,10,11,14,15};

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		InterpolationSearch obj = new InterpolationSearch();

		System.out.println("Element 4 at index : " + obj.interpolation(arr,4));
	}
}
