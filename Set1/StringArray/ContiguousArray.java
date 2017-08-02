// http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/

import java.util.Arrays;

public class ContiguousArray {

	public int contiguous(int[] array) {

		Arrays.sort(array);
		int[] dp = new int[array.length];
		int max = 1;
		dp[0] = 1;
		for (int i=1; i<array.length; i++) {
		
			if (array[i] == array[i-1] + 1)
				dp[i] = dp[i-1] + 1;
			else
				dp[i] = 1;

			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {

		int[] arr = {1,56,58,57,90,92,94,93,91,45};
		int[] arr2 = {14,12,11,20};
		ContiguousArray obj = new ContiguousArray();
		System.out.println(obj.contiguous(arr));
		System.out.println(obj.contiguous(arr2));
	}
}
