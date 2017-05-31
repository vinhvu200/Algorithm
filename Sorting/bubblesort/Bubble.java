public class Bubble
{
	public static void sort(int[] array) {

		for (int i=0; i<array.length-1; i++){
			
			for (int j=i; j<array.length-1; j++){
				
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	public static void main(String[] args){

		int[] arr = {9, 1, 8, 2, 7, 3, 6, 4, 5};

		System.out.println("Before sorting");
		for (int i=0; i< arr.length; i++){

			System.out.print(arr[i] + " ");
		}

		sort(arr);

		System.out.println("\nAfter Sorting");
		for (int i=0; i< arr.length; i++){
            
            System.out.print(arr[i] + " ");
        }
		System.out.println();
	}
}
