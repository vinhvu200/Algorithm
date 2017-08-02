public class Solution {

	public static int maxArea2(int[] height) {
	
		int i=0, j=height.length-1, max=0;

		while (i<j) {
		
			max = Math.max(max, (j-i) * Math.min(height[i], height[j]));
			if (height[i] < height[j])
				i++;
			else
				j--;
		}
		return max;
	}

	// Brute Force
	// O(n^2)
	// Time Limit Exceeded
	public static int maxArea1(int[] height) {
	
		int max=0;

		for (int i=0; i<height.length-1; i++) {
		
			for (int j=i+1; j<height.length; j++) {

				int container = (j-i) * Math.min(height[i],height[j]);
				if (container > max)
					max = container;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		
		int height[] = {1, 0, 3};
		System.out.println(maxArea1(height));
		System.out.println(maxArea2(height));
	}
}
