public class MergeSort {

	private void merge(int[] arr, int left, int mid, int right) {
	
		int leftSize = mid-left+1;
		int rightSize = right-mid;
		int[] Left = new int[leftSize];
		int[] Right = new int[rightSize];

		for (int i=0; i<leftSize; i++) {
		
			Left[i] = arr[left+i];
		}
		for (int i=0; i<rightSize; i++) {
		
			Right[i] = arr[mid+1+i];
		}

		int i=0, j=0, k=left;
		while (i < leftSize && j < rightSize) {
		
			if (Left[i] < Right[j]) {
			
				arr[k] = Left[i];
				i++;
			}
			else {
			
				arr[k] = Right[j];
				j++;
			}
			k++;
		}

		while (i < leftSize) {
		
			arr[k] = Left[i];
			i++; k++;
		}
		while (j < rightSize) {
		
			arr[k] = Right[j];
			j++; k++;
		}
	}

	public void mergeSort(int[] arr, int left, int right) {
	
		if (left < right) {
		
			int mid = (left+right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}

	public static void main(String[] args) {

		int[] arr = {38,27,43,3,9,82,10};

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		MergeSort obj = new MergeSort();
		obj.mergeSort(arr,0,arr.length-1);

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

	}
}
