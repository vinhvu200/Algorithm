public class Solution {

	// Run time : O(n)
	// Space : O(1)
	public static int removeElement(int[] nums, int val) {
	
		int count = nums.length;

		for (int i=0; i<count; i++) {
		
			if (nums[i] == val) { 
			
				int temp = nums[i];
				nums[i] = nums[count-1];
				nums[count-1] = temp;
				i--; count--;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int nums[] = {2, 3, 3, 2};
		System.out.println(removeElement(nums, 3));
		for (int i=0; i<nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}
}
