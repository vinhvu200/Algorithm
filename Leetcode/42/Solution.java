public class Solution {

	public static int trap(int[] height) {
	
		if (height.length == 0)
			return 0;

		int ans=0;
		int[] dp1 = new int[height.length];
		int[] dp2 = new int[height.length];
		dp1[0] = height[0];
		dp2[height.length-1] = height[height.length-1];

		for (int i=1; i<height.length; i++) 
			dp1[i] = Math.max(dp1[i-1], height[i]);

		for (int i=height.length-2; i>=0; i--)
			dp2[i] = Math.max(dp2[i+1], height[i]);

		for (int i=0; i<height.length; i++) 
			ans += Math.min(dp1[i],dp2[i]) - height[i];

		return ans;
	}

	public static void main(String[] args){
	
		int[] height = {3,3,4};
		System.out.println(trap(height));
	}
}
