public class Solution {

	public static void nextPermutation2(int[] nums) {
	
		int pos=0;
		int pos2=nums.length-1;
		boolean flag=false;

		for (int i=nums.length-1; i>=1; i--) {
		
			if (nums[i-1] < nums[i]){

				flag = true;
				pos = i-1;
				break;
			}
		}

		if (flag == false) {
		
			int s = 0;
			int e = nums.length-1;
			while (s < e) {
			
				int t = nums[s];
				nums[s] = nums[e];
				nums[e] = t;
				s++; e--;
			}
			return;
		}

		for (int i=pos+1; i<nums.length; i++) {
		
			if (nums[pos] >= nums[i]) {

				pos2 = i - 1;
				break;
			}
		}

		int swap = nums[pos];
		nums[pos] = nums[pos2];
		nums[pos2] = swap;

		int start = pos+1;
		int end = nums.length-1;

		while (start < end) {
		
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++; end--;
		}
	}

	// Attempt
	// Run time : O(n^2)
	// Space : O(1)
	// Result : 213/265 cases passed
	public static void nextPermutation(int[] nums) {
	
		if (nums.length == 0 || nums.length == 1)
			return;

		boolean flag = true;
		int pos = nums.length-1;

		for (int i=nums.length-1; i>=1; i--) {
		
			boolean flag2 = false;
			for (int j=i-1; j>=0; j--){
			
				if (nums[j] < nums[i]) {
				
					int swap = nums[j];
					nums[j] = nums[i];
					nums[i] = swap;
					flag2 = true;
					flag = false;
					pos = j;
					break;
				}
			}
			if (flag2 == true)
				break;
		}

		if (flag == true) {
		
			for (int i=0; i<nums.length-1; i++) {
			
				for (int j=i+1; j<nums.length; j++) {
				
					if (nums[i] >= nums[j]) {
					
						int swap = nums[i];
						nums[i] = nums[j];
						nums[j] = swap;
					}	
				}
			}
			return;
		}

		for (int i=pos+1; i<nums.length-1; i++) {
		
			for (int j=i+1; j<nums.length; j++) {
			
				if (nums[i] > nums[j]) {
				
					int swap = nums[i];
					nums[i] = nums[j];
					nums[j] = swap;
				}
			}
		}
	}

	public static void main(String[] args) {
	
		int nums[] = {1,5,1};
		nextPermutation2(nums);
		
		for (int i=0; i<nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}
}
