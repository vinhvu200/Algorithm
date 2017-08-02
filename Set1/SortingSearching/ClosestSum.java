// http://www.geeksforgeeks.org/given-sorted-array-number-x-find-pair-array-whose-sum-closest-x/

public class ClosestSum {

	public void closestSum(int[] arr, int target) {
	
		int left = 0;
		int right = arr.length-1;
		int min_diff = 1000;
		int first = -1, second = -1;

		while (left <= right) {
		
			int sum = arr[left] + arr[right];
			int diff = Math.abs(target-sum);

			if (diff < min_diff) {
			
				first = arr[left];
				second = arr[right];
				min_diff = diff;
			}

			if (sum < target)
				left++;
			else
				right--;
		}
		
		System.out.println(first + " and " + second + "\n");
	}

	public static void main(String[] args) {

		int[] arr = {10,22,28,29,30,40};
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		ClosestSum obj = new ClosestSum();
		System.out.println("target : 54");
		obj.closestSum(arr, 54);

		int[] arr2 = {1,3,4,7,10};

		for (int i=0; i<arr2.length; i++)
			System.out.print(arr2[i] + " ");
		System.out.println();

		System.out.println("target : 15");
		obj.closestSum(arr, 15);
	}
}
