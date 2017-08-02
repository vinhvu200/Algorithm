public class KthSmallest {

	public int kthSmallest(int[] arr, int k) {

		int left = 0;
		int right = arr.length-1;

		while (left <= right) {
		
			int i = left - 1;
			int pivot = arr[right];

			for (int j=0; j<=right-1; j++) {
			
				if (arr[j] < pivot) {
				
					i++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

			i++;
			int temp = arr[right];
			arr[right] = arr[i];
			arr[i] = temp;
			
			if (k == i)
				return arr[i];
			if (k < i) {

				left = 0;
				right = i-1;
			}
			else 
				left = i+1;
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] arr = {7,10,4,3,20,15};
		KthSmallest obj = new KthSmallest();
		
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		int k = 0;
		System.out.println("k = " + k + " : " + obj.kthSmallest(arr,k++));
		System.out.println("k = " + k + " : " + obj.kthSmallest(arr,k++));
		System.out.println("k = " + k + " : " + obj.kthSmallest(arr,k++));
		System.out.println("k = " + k + " : " + obj.kthSmallest(arr,k++));
		System.out.println("k = " + k + " : " + obj.kthSmallest(arr,k++));
		System.out.println("k = " + k + " : " + obj.kthSmallest(arr,k++));
	}
}
