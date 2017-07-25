public class Bubble {

	public void bubble(int[] arr) {
	
		for (int i=0; i<arr.length-1; i++) {
		
			for (int j=i; j<arr.length-1; j++) {
			
				if (arr[j] > arr[j+1]) {
				
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {

		int[] arr = {5,1,4,2,8};
		Bubble obj = new Bubble();

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		obj.bubble(arr);

		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

	}
}
