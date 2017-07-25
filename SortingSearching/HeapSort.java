public class HeapSort {

	private void heapify(int[] arr, int n, int i) {
	
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;

		if (left < n && arr[left] > arr[largest])
			largest = left;

		if (right < n && arr[right] > arr[largest])
			largest = right;

		if (largest != i) {
		
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;

			heapify(arr, n, largest);
		}
	}

	public void heapsort(int[] arr) {
	
		int n = arr.length;

		for (int i = n/2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		for (int i = n-1; i >= 0; i--) {
		
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}
	}

	public static void main(String[] args) {

		int[] arr = {4,10,3,5,1};

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		HeapSort obj = new HeapSort();
		obj.heapsort(arr);

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
