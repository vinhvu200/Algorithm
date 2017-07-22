// http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
import java.util.Arrays;

public class SmallestSubarray {

	public int smallestSubarray(int[] arr, int x) {
	
		int end, start, min, curr;
		end = start = curr = 0;
		min = arr.length+1;

		while (end < arr.length) {
		
			while (curr <= x && end < arr.length)
				curr += arr[end++];

			while (curr > x && start < arr.length) {
			
				min = Math.min(min, end-start);

				curr -= arr[start++];
			}
		}

		if (min == arr.length+1)
			return -1;
		return min;
	}

	public static void main(String[] args) {

		int[] arr1 = {1,4,45,6,0,19};
		int[] arr2 = {1,10,5,2,7};
		int[] arr3 = {1,11,100,1,0,200,3,2,1,250};
		int[] arr4 = {1,2,4};

		SmallestSubarray obj = new SmallestSubarray();
		System.out.println(obj.smallestSubarray(arr1,51));
		System.out.println(obj.smallestSubarray(arr2,9));
		System.out.println(obj.smallestSubarray(arr3,280));
		System.out.println(obj.smallestSubarray(arr4,8));
	}
}
