import java.util.HashSet;
import java.util.Set;

public class Solution {

	static void merge(int[] array, int left, int mid, int right) {
	
		int i = mid-left+1;
		int j = right-mid;

		int L[] = new int[i];
		int R[] = new int[j];

		i=0; j=0; 
		int k=left;

		while (i<L.length)
			L[i++] = array[k++];
		while (j<R.length)
			R[j++] = array[k++];

		i=0; j=0; k=left;

		while (i<L.length && j<R.length) {
		
			if (L[i] < R[j])
				array[k++] = L[i++];
			else
				array[k++] = R[j++];
		}

		while (i<L.length)
			array[k++] = L[i++];
		while (j<R.length)
			array[k++] = R[j++];
	}

	static void mergeSort(int[] array, int left, int right) {
	
		if (left < right) {
		
			int mid = (left+right) / 2;
			mergeSort(array, 0, mid);
			mergeSort(array, mid+1, right);
			merge(array, left, mid, right);
		}
	}

	public static int removeDuplicates1(int[] nums) {

		if (nums.length == 0)
			return 0;
		mergeSort(nums, 0, nums.length-1);
		int last = nums[0];
		int count = 1;

		for (int i=1; i<nums.length; i++) {
		
			if(nums[i] != last)
				count++;
			last = nums[i];
		}

		return count;
	}

	public static int removeDuplicates2(int[] nums) {
	
		Set<Integer> set = new HashSet<>();
		int count = 0;
		int[] array = new int[nums.length];
		
		for (int i=0; i<nums.length; i++) {
		
			if (!set.contains(nums[i])){
			
				set.add(nums[i]);
				array[count] = nums[i];
				count++;
			}
		}

		for (int i=0; i<nums.length; i++) 
			nums[i] = array[i];

		return count;
	}

	public static void main(String[] args) {
	
		int array[] = {5, 5, 3, 1, 2, 7, 9, 7};
		
		System.out.println(removeDuplicates2(array));
	}
}
