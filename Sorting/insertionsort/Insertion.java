public class Insertion {

	public static void insertionSort(int[] array){
		
		for (int i=0; i<array.length; i++){
		
			int j=i;
			int hold = array[i];

			while (j>0) {
				
				if (array[j] < array[j-1]){
				
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
					j--;
				}
				else
					break;
			}

			array[j] = hold;
		}
	}

	public static void main(String[] args){

		int[] array = {9, 1, 2, 8, 3, 7, 5, 6};
		System.out.println("Before sorting");
		for (int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		
		insertionSort(array);

		System.out.println("\nAfter sorting");
		for (int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
