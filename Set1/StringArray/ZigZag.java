// http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/

public class ZigZag {

	public void zigzag(int[] arr) {
	
		boolean lessThan = true;

		for (int i=0; i<arr.length-2; i++) {
		
			if (lessThan) {
			
				if (arr[i] > arr[i+1]) {
				
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			else {
			
				if (arr[i] < arr[i+1]) {
				
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}

			}
			lessThan = !lessThan;
		}
	}

	public static void main(String[] args) {
		
		ZigZag obj = new ZigZag();
		int[] arr = {3,7,4,8,2,6,1};
		obj.zigzag(arr);
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
