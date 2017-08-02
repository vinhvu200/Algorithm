public class Insertion {

	public void insertion(int[] arr) {
	
		for (int i=1; i<arr.length; i++) {
		
			int placeholder = arr[i];
			int j = i-1;

			while (j >= 0 && placeholder < arr[j]) {

				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = placeholder;
		}
	}

	public static void main(String[] args) {

		int[] arr = {9,7,6,15,16,5,10,11};
		Insertion obj = new Insertion();

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		obj.insertion(arr);

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

	}
}
