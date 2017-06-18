public class Solution {

	/*
		Greedy Approach
		Time : O(n)
		Space : O(1)
		** Note : This was the proper solution
					and what my attempt should have
					done
	*/
	public static boolean canJump2(int[] nums) {
	
		if (nums.length == 0)
			return false;

		int closest = nums.length-1;

		for (int i=nums.length-1; i>=0; i--) {
		
			if (i+nums[i] >= closest)
				closest = i;
		}

		return closest == 0;
	}

	/*
		Dynamic Programming
		Time : O(n)
		Space : O(n)

		** Note : this was my attempt and I was trying
					to use DP to solve it. Without
					realizing, I used the Greedy method
					to solve it. The array I created for
					DP was updated but not even utilized
	*/
	public static boolean canJump(int[] nums) {
	
		if (nums.length == 0)
			return false;

		int closest = nums.length-1;
		boolean[] dp = new boolean[nums.length];
		dp[nums.length-1] = true;

		for (int i=nums.length-2; i>=0; i--) {
		
			if (i+nums[i] >= closest) {
			
				dp[i] = true;
				closest = i;
			}
		}

		return dp[0] == true ? true : false;
	}

	public static void main(String[] args) {

		int[] nums = {3,2,1,0,4};
		System.out.println(canJump(nums));
	}
}
