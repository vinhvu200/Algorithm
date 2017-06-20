import java.util.Stack;

public class Solution {

	public static int largestRectangleArea(int[] heights) {
	
		Stack<Integer> s = new Stack<>();
		int i=0;
		int area;
		int maxArea = -1;
		int top;

		while (i < heights.length) {

			if (s.empty() || heights[s.peek()] < heights[i])
				s.push(i++);
			else {
			
				top = s.pop();
				area = heights[top] * (s.empty() ? i : (i-s.peek()-1));
				maxArea = Math.max(maxArea, area);
			}
		}

		while (!s.empty()) {

			top = s.pop();
			area = heights[top] * (s.empty() ? i : (i-s.peek()-1));
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}

	public static void main(String[] args) {

		int[] height = {6,2,5,4,5,1,6};
		int[] height2 = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height2));
	}
}
