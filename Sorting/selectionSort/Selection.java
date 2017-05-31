public class Selection {

	public static void selectionsort(int[] array){
	
		for (int i=0; i<array.length-1; i++){
		
			int min = i;
			for (int j=i+1; j<array.length; j++){
				
				if (array[j]<array[min])
					min = j;
			}

			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}

	public static void main(String[] args){
	
		int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
		System.out.println("Before sorting");
		for (int i=0; i<array.length; i++){
		
			System.out.print(array[i] + " ");
		}

		selectionsort(array);

		System.out.println("\nAfter sorting");
		for (int i=0; i<array.length; i++){
		
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
