public class Solution {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int nums1_left=0, nums1_right=nums1.length-1;
		int nums2_left=0, nums2_right=nums2.length-1;
		int nums1_median, nums2_median;

		while (nums1_right - nums1_left + 1 > 2 || 
				nums2_right - nums2_left + 1 > 2) {
		
			nums1_median = (nums1_left + nums1_right) / 2;
			nums2_median = (nums2_left + nums2_right) / 2;

			if (nums1[nums1_median] > nums2[nums2_median]) {
			
				nums1_right = nums1_median;
				nums2_left = nums2_median;
			}
			else {
			
				nums1_left = nums1_median;
				nums2_right = nums2_median;
			}
		}

		System.out.println("nums1_left : " + nums1_left + " nums1_right : " + nums1_right);
		System.out.println("nums2_left : " + nums2_left + " nums2_right : " + nums2_right);

		return 0;
	}

	public static void main(String[] args) {
	
		int[] nums1 = {1,38};
		int[] nums2 = {2,13,17,30,45};

		findMedianSortedArrays(nums1, nums2);
	}
}
