public class BinarySearch {

	public int binarySearch(int[] arr, int key) {
	
		int l,r;
		l = 0;
		r = arr.length-1;

		while (l <= r) {
		
			int mid = (l+r) / 2;
			if (key == arr[mid])
				return mid;
			if (key > arr[mid])
				l = mid+1;
			else 
				r = mid-1;
		}
		return -1;
	}

	public static void main(String[] args) {

		BinarySearch obj = new BinarySearch();
		int[] arr = {2,5,8,12,16,23,38,56,72,91};
		System.out.println(obj.binarySearch(arr, 23));
	}
}
