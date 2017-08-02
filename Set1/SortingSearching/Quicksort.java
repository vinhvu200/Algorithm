public class Quicksort {

	public int partition(int[] arr, int left, int right) {
	
		int pivot = arr[right];
		int i = left-1;
		for (int j=left; j<=right-1; j++) {
		
			if (arr[j] < pivot) {

				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = temp;

		return i+1;
	}

	public void quicksort(int[] arr, int left, int right) {

		if (left < right) {
		
			int pi = partition(arr, left, right);

			quicksort(arr, left, pi-1);
			quicksort(arr, pi+1, right);
		}
	}

	public static void main(String[] args) {

		int[] arr = {10,80,30,90,40,50,70};

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		Quicksort obj = new Quicksort();
		obj.quicksort(arr,0,arr.length-1);

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

	}
}
