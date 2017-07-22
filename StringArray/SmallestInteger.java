// http://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/

public class SmallestInteger {

	public int smallestInteger(int[] arr) {
	
		int result = 1;

		for (int i=0; i<arr.length && arr[i] <= result; i++)
			result += arr[i];

		return result;
	}

	public static void main(String[] args) {

		SmallestInteger obj = new SmallestInteger();
		int[] arr1 = {1,3,6,10,11,15};
		int[] arr2 = {1,1,1,1};
		int[] arr3 = {1,1,3,4};
		int[] arr4 = {1,2,5,10,20,40};
		int[] arr5 = {1,2,3,4,5,6};

		System.out.println(obj.smallestInteger(arr1));
		System.out.println(obj.smallestInteger(arr2));
		System.out.println(obj.smallestInteger(arr3));
		System.out.println(obj.smallestInteger(arr4));
		System.out.println(obj.smallestInteger(arr5));
	}
}
